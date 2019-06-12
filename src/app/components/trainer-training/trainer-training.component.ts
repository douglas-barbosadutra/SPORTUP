import { Component, OnInit } from '@angular/core';
import { TrainingService } from 'src/app/services/training.service';
import { Training } from '../../models/training';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-trainer-training',
  templateUrl: './trainer-training.component.html',
  styleUrls: ['./trainer-training.component.css']
})
export class TrainerTrainingComponent implements OnInit {
  info:string;

  public trainings: Training[];

  constructor(private trainingService: TrainingService, private router: Router) { }

  ngOnInit() {
    this.trainingService.getTrainingList().subscribe((response) => {
      this.trainings = response;
     });
  }

  updateTraining(f: NgForm){
    this.trainingService.updateTraining(f.value.idTraining, f.value.info);
    this.router.navigateByUrl('/trainerTraining');
    
  }

  createTraining(): void {
    console.log('mi arrivano info=' + this.info);
      this.trainingService.createTraining(this.info).subscribe((response) => {
    console.log('Risposta ricevuta');
      if (response != null) {
        this.router.navigateByUrl('/homeTrainer');
             }
          }
      )};


}
