import { Component } from '@angular/core';
import { Footballer } from '../../model/footballer.model';
import { FootballerService } from '../../service/footballer.service';
import { CommonModule } from '@angular/common';
import { Country } from '../../model/country';
import { Gender } from '../../model/gender';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-footballer-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './footballer-list.component.html',
  styleUrl: './footballer-list.component.css'
})
export class FootballerListComponent {

  footballers: Footballer[] = [];
  Country = Country;
  Gender = Gender;
  
  constructor(private footballerService: FootballerService) {}

  ngOnInit(): void {
    this.updateList();
  }

  private updateList() {
    this.footballerService.findAll().subscribe(data => {
      this.footballers = data;
    });
  }
  
}
