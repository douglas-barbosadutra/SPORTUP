import { Component, OnInit } from '@angular/core';

import { BiomedicalData } from 'src/app/models/BiomedicalData';
import { TrainerService } from 'src/app/services/trainer.service';
import { Router, ActivatedRoute} from '@angular/router';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-trainer-biomedical-data-view',
  templateUrl: './trainer-biomedical-data-view.component.html',
  styleUrls: ['./trainer-biomedical-data-view.component.css']
})
export class TrainerBiomedicalDataViewComponent implements OnInit {
  id: number;
  biomedicalData:BiomedicalData;

  constructor(private trainerService: TrainerService, private route: ActivatedRoute,private router:Router) {}


  ngOnInit() {
    this.id = this.getId();
    this.getBiomedicalData();


  }
  getId(): number{   
    return Number(this.route.snapshot.paramMap.get('id'));
  }


  getBiomedicalData(): BiomedicalData {
    console.log('mi arrivano idPlayer=' + this.id);
    this.trainerService.getBiomedicalData(this.id).subscribe((response) => {
        console.log('Risposta ricevuta');
        if(response!=null){
          this.biomedicalData = response;
          //console.log(bioD);
       }
     })
     return this.biomedicalData;
   }

}
