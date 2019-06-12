import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/models/User';
import { NutritionistService } from 'src/app/services/nutritionist.service';
import { Router, ActivatedRoute  } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Daily } from 'src/app/models/Diet';

@Component({
  selector: 'app-nutritionist-diet-view',
  templateUrl: './nutritionist-diet-view.component.html',
  styleUrls: ['./nutritionist-diet-view.component.css']
})
export class NutritionistDietViewComponent implements OnInit {
  dietList: Daily[];
  idPlayer: number;
  day: Daily;
  breakfast: string;
  snack:string;
  lunch:string;
  snackAfternoon:string;
  dinner:string;
  idDay: number;
  tempD: Daily;

  constructor(private nutritionistService: NutritionistService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.idPlayer = Number(this.route.snapshot.paramMap.get('idPlayer'));
    this.nutritionistService.viewDiet(this.idPlayer).subscribe((response) => {
      console.log('Dieta:Risposta ricevuta');
            if (response != null) {
                console.log("c'è nessuno?");
                console.log(response);
                this.dietList=response;
                }
     });
  }

  showDay(daily: Daily): void{
    this.day = daily;
    console.log("day " + daily.day + " id " + daily.id);
  }

  updateDay(): void{
    this.day.breakfast = this.breakfast;
    this.day.snack = this.snack; 
    this.day.lunch = this.lunch;
    this.day.snackAfternoon = this.snackAfternoon;
    this.day.dinner = this.dinner;
    console.log("ricevo " + this.day.breakfast  + this.day.id);
    this.nutritionistService.updateDay(this.day)
    //this.router.navigateByUrl('/nutritionistDietView/'+ this.idPlayer);
    //console.log("esito " + );
  }



}
