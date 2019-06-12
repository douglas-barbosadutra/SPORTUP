import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/models/User';
import { NutritionistService } from 'src/app/services/nutritionist.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Daily } from 'src/app/models/Daily';

@Component({
  selector: 'app-home-nutritionist',
  templateUrl: './home-nutritionist.component.html',
  styleUrls: ['./home-nutritionist.component.css']
})

export class HomeNutritionistComponent implements OnInit {
  dietList: Daily[];
  playerList: User[];
  idPlayer: number;

  constructor(private nutritionistService: NutritionistService, private router: Router) { }

  ngOnInit() {
    this.playerList = this.getPlayersList();
  }

  getPlayersList(): User[] {
    console.log('stampo la lista di players ');
    this.nutritionistService.getUsersList().subscribe((response) => {
        console.log('Risposta ricevuta');
        if (response != null) {
            this.playerList=response;
            this.playerList.splice(this.playerList.findIndex(user => user.type === "admin"),1);
            var b = this.playerList.filter(e => e.type === "trainer");
            b.forEach(f => this.playerList.splice(this.playerList.findIndex(e => e.type === f.type),1));
            var b = this.playerList.filter(e => e.type === "nutritionist");
            b.forEach(f => this.playerList.splice(this.playerList.findIndex(e => e.type === f.type),1));
            var b = this.playerList.filter(e => e.type === "pending");
            b.forEach(f => this.playerList.splice(this.playerList.findIndex(e => e.type === f.type),1));
             
            console.log(this.playerList);
        }
    }
  )
    return this.playerList;         
  }


  viewDiet(): void {
    this.router.navigateByUrl('/nutritionistDietView/'+ this.idPlayer);
  }
  
  


}


