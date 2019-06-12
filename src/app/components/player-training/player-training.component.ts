import { Component, OnInit } from '@angular/core';

import { PlayerService } from 'src/app/services/player.service';
import { TrainingCardService } from 'src/app/services/training-card.service';
import { Player } from '../../models/player';
import { Training } from '../../models/training';
import { TrainingCard } from '../../models/trainingCard';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-player-training',
  templateUrl: './player-training.component.html',
  styleUrls: ['./player-training.component.css']
})
export class PlayerTrainingComponent implements OnInit {
  public training: Training;
  public trainingCards: TrainingCard[];
  idUser: number;
  idTraining: number;

  constructor(private trainingCardService: TrainingCardService,private playerService: PlayerService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.idUser = Number(this.route.snapshot.paramMap.get('idUser'));

    this.playerService.getTraining(this.idUser).subscribe((response) => {
    
      if(response!=null){
        this.training = response;
        console.log('Risposta ricevuta');
         //console.log(bioD);
      }
    })
    return this.training;
  }



    }

  /*getTraining(idUser: number): Training{
    
    this.playerService.getTraining(this.idUser).subscribe((response) => {
      console.log('response ' + response.info);
      this.training = response;
     })
     return this.training;
  }
  */
  

  /*getTrainingCardList(idTraining: number): TrainingCard[]{
       this.trainingCardService.getTrainingCard(idTraining).subscribe((response) => {
        this.trainingCards = response;
       })
       return this.trainingCards;
  }
  */
