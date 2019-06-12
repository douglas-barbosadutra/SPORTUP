import { Component, OnInit } from '@angular/core';
import {TrainerService} from 'src/app/services/trainer.service';

import { User } from 'src/app/models/User';
import { Router} from '@angular/router';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-home-trainer',
  templateUrl: './home-trainer.component.html',
  styleUrls: ['./home-trainer.component.css']
})
export class HomeTrainerComponent implements OnInit {

    id:number;

  constructor(private trainerService: TrainerService,private router: Router) { }


  ngOnInit() {
  }

  biomedicalData(): void {
    this.router.navigateByUrl('/trainerBiomedicalDataView/'+ this.id);
    }

    performance(): void {
      this.router.navigateByUrl('/trainerPerformanceView/'+ this.id);
      }


           
              }
        