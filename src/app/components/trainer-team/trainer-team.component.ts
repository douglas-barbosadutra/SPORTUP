import { Component, OnInit } from '@angular/core';
import { TeamService } from 'src/app/services/team.service';
import { Team } from '../../models/team';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-trainer-team',
  templateUrl: './trainer-team.component.html',
  styleUrls: ['./trainer-team.component.css']
})
export class TrainerTeamComponent implements OnInit {
  info:string;
  public teams: Team[];

  constructor(private teamService: TeamService, private router: Router) { }

  ngOnInit() {
    this.teamService.getTeamList().subscribe((response) => {
      this.teams = response;
     });
  }

  updateTeam(f: NgForm){
    this.teamService.updateTeam(f.value.idTeam, f.value.info);
    //this.router.navigateByUrl('/trainerTeam');
  }
  


  createTeam(): void {
    console.log('mi arrivano info=' + this.info);
              this.teamService.createTeam(this.info).subscribe((response) => {
                    console.log('Risposta ricevuta');
                          if (response != null) {
                              this.router.navigateByUrl('/homeTrainer');
                              }
                          }
                      )};


}
