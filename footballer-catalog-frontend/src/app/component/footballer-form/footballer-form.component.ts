import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { FootballerService } from '../../service/footballer.service';
import { TeamService } from '../../service/team.service';
import { NgSelectModule } from '@ng-select/ng-select';
import { Team } from '../../model/team.model';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-footballer-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NgSelectModule],
  templateUrl: './footballer-form.component.html',
  styleUrl: './footballer-form.component.css'
})
export class FootballerFormComponent implements OnInit {

  teams: Team[] = [];
  isAddTeamMode = false;
  selectedFootballerId?: number;
  paramsSub?: Subscription;
  teamForm = this.formBuilder.group({
    name: ["", Validators.required]
  });
  footballerForm = this.formBuilder.group({
    firstName: ["", Validators.required],
    lastName: ["", Validators.required],
    gender: ["", Validators.required],
    birthdate: ["", Validators.required],
    teamId: [0, [Validators.required, Validators.min(1)]],
    country: ["", Validators.required]
  });

  constructor(private footballerService: FootballerService, private teamService: TeamService,
    private formBuilder: FormBuilder, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.updateTeams();
    this.paramsSub = this.route.params.subscribe(params => {
      if (params["id"] !== undefined) {
        this.selectedFootballerId = parseInt(params["id"]);
        this.footballerService.findById(this.selectedFootballerId!).subscribe(data => {
          this.footballerForm.patchValue(<any>data);
          this.footballerForm.controls["teamId"].patchValue(data.team!.id!);
        });
      }
    })
  }

  submitFootballer() {
    if (this.selectedFootballerId === undefined) {
      this.footballerService.create(<any>this.footballerForm.value).subscribe(() => this.router.navigate(["/"]));
    } else {
      this.footballerService.update(this.selectedFootballerId!, <any>this.footballerForm.value)
        .subscribe(() => this.router.navigate(["/"]));
    }
  }

  createTeam() {
    this.teamService.create(<any>this.teamForm.value).subscribe(() => {
      this.isAddTeamMode = false;
      this.updateTeams();
    });
  }

  private updateTeams() {
    this.teamService.findAll().subscribe(data => this.teams = data);
  }

}
