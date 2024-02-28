import { Component, OnDestroy, OnInit } from '@angular/core';
import { Footballer } from '../../model/footballer.model';
import { FootballerService } from '../../service/footballer.service';
import { CommonModule } from '@angular/common';
import { Country } from '../../model/country';
import { Gender } from '../../model/gender';
import { RouterModule } from '@angular/router';
import { Subscription } from 'rxjs';
import { RxStompService } from '../../service/rx-stomp.service';
import { Message } from "@stomp/stompjs";

@Component({
  selector: 'app-footballer-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './footballer-list.component.html',
  styleUrl: './footballer-list.component.css'
})
export class FootballerListComponent implements OnInit, OnDestroy {

  footballers: Footballer[] = [];
  Country = Country;
  Gender = Gender;
  private webSocketSub?: Subscription;
  
  constructor(private footballerService: FootballerService, private rxStompService: RxStompService) {}

  ngOnInit(): void {
    this.updateList();
    this.webSocketSub = this.rxStompService.watch("/topic/footballers").subscribe((message: Message) => {
      const footballer = <Footballer><unknown>JSON.parse(message.body);
      let isNewFootballer = true;
      for (let i = 0; i < this.footballers.length; i++) {
        if (this.footballers[i].id === footballer.id) {
          this.footballers[i] = footballer;
          isNewFootballer = false;
          break;
        }
      }
      if (isNewFootballer) {
        this.footballers.push(footballer);
      }
    });
  }

  ngOnDestroy(): void {
    this.webSocketSub?.unsubscribe();
  }

  private updateList() {
    this.footballerService.findAll().subscribe(data => {
      this.footballers = data;
    });
  }
  
}
