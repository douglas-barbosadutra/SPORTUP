import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/models/Player';
import { Router,ActivatedRoute  } from '@angular/router';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-player-info',
  templateUrl: './player-info.component.html',
  styleUrls: ['./player-info.component.css']
})
export class PlayerInfoComponent implements OnInit {
  idUser: number;
  public player: Player;

  constructor(private playerService: PlayerService,private route: ActivatedRoute,private router: Router) { }

  ngOnInit() {
    this.idUser = this.getId();
    this.getInfo();


  }
  getId(): number{   
    return Number(this.route.snapshot.paramMap.get('idUser'));
  }


  getInfo():Player{
    this.playerService.getInfo(this.idUser).subscribe((response) => {
      console.log('Risposta ricevuta');
     if(response!=null){
        console.log(response.info);  
         this.player = response;
      }
   })
  return this.player;

  }


}
