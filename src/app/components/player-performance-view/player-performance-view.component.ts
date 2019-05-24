import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/models/User';
import { PlayerService } from 'src/app/services/player.service';
import { Router,ActivatedRoute  } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Performance } from 'src/app/models/Performance';

@Component({
  selector: 'app-player-performance-view',
  templateUrl: './player-performance-view.component.html',
  styleUrls: ['./player-performance-view.component.css']
})
export class PlayerPerformanceViewComponent implements OnInit {
  idUser: number;
  public performance: Performance;

  constructor(private playerService: PlayerService,private route: ActivatedRoute,private router: Router) { }

  ngOnInit() {
    this.idUser = this.getId();
    this.getPerformance();
  }
  getId(): number{   
    return Number(this.route.snapshot.paramMap.get('idUser'));
  }

  getPerformance():Performance{
    this.playerService.getPerformance(this.idUser).subscribe((response) => {
      
      if(response!=null){
        this.performance = response;
        console.log('Risposta ricevuta');
         //console.log(bioD);
      }
    })
    return this.performance;
  }

}
