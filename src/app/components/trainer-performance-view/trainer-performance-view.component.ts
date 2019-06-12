import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/models/User';
import { TrainerService } from 'src/app/services/trainer.service';
import { Router,ActivatedRoute  } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Performance } from '../../models/Performance';

@Component({
  selector: 'app-trainer-performance-view',
  templateUrl: './trainer-performance-view.component.html',
  styleUrls: ['./trainer-performance-view.component.css']
})
export class TrainerPerformanceViewComponent implements OnInit {
  id: number;
  performance: Performance;
  

  constructor(private trainerService: TrainerService,private route: ActivatedRoute,private router: Router) { }

  ngOnInit() {
    this.id = this.getId();
    this.getPerformance();
  }
  getId(): number{   
    return Number(this.route.snapshot.paramMap.get('id'));
  }

  
  getPerformance():Performance{
    this.trainerService.getPerformance(this.id).subscribe((response) => {
      if(response!=null){
        this.performance = response;
        console.log('Risposta ricevuta');
         //console.log(bioD);
      }
    })
    return this.performance;
  }
  
}
