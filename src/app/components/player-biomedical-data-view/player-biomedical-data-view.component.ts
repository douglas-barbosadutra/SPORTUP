import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/models/User';
import { PlayerService } from 'src/app/services/player.service';
import { Router,ActivatedRoute  } from '@angular/router';
import { NgForm } from '@angular/forms';
import { BiomedicalData } from 'src/app/models/BiomedicalData';
@Component({
  selector: 'app-player-biomedical-data-view',
  templateUrl: './player-biomedical-data-view.component.html',
  styleUrls: ['./player-biomedical-data-view.component.css']
})
export class PlayerBiomedicalDataViewComponent implements OnInit {
  idUser: number;
  biomedicalData:BiomedicalData;

  constructor(private playerService: PlayerService,private route: ActivatedRoute,private router: Router) { }
  ngOnInit() {
    this.idUser = this.getId();
    this.getBiomedicalData();
    console.log(this.biomedicalData);
  }

  getId(): number{   
    return Number(this.route.snapshot.paramMap.get('idUser'));
  }
  getBiomedicalData():BiomedicalData{
    this.playerService.getBiomedicalData(this.idUser).subscribe((response) => {
      console.log('Risposta ricevuta');
      if(response!=null){
         this.biomedicalData = response;
         //console.log(bioD);
      }
    })
    return this.biomedicalData;
  }
}
