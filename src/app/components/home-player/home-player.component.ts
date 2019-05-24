import { Component, OnInit, ViewChild } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { PlayerService } from 'src/app/services/player.service';
import { UserService } from 'src/app/services/user.service';
import { Player } from 'src/app/models/Player';
import { User } from 'src/app/models/User';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { Training } from 'src/app/models/Training';
import { ChartDataSets, ChartOptions } from 'chart.js';
import { Color, BaseChartDirective, Label } from 'ng2-charts';

@Component({
  selector: 'app-home-player',
  templateUrl: './home-player.component.html',
  styleUrls: ['./home-player.component.css']
})
export class HomePlayerComponent implements OnInit {
  idUser: number;
  public player: Player;
  public training: Training;
  info: string;
  public lineChartData: ChartDataSets[] = [
    { data: [65, 59, 80, 81], label: 'peso' },
    { data: [28, 48, 40, 19], label: 'massa grassa' },
    { data: [180, 480, 770, 90], label: 'massa magra', yAxisID: 'y-axis-1' }
  ];
  public lineChartLabels: Label[] = ['1 sett', '2 sett', '3 sett', '4 sett'];
  public lineChartOptions: (ChartOptions & { annotation: any }) = {
    responsive: true,
    scales: {
      // We use this empty structure as a placeholder for dynamic theming.
      xAxes: [{}],
      yAxes: [
        {
          id: 'y-axis-0',
          position: 'left',
        },
        {
          id: 'y-axis-1',
          position: 'right',
          gridLines: {
            color: 'rgba(255,0,0,0.3)',
          },
          ticks: {
            fontColor: 'red',
          }
        }
      ]
    },
    annotation: {
      annotations: [
        {
          type: 'line',
          mode: 'vertical',
          scaleID: 'x-axis-0',
          value: 'March',
          borderColor: 'orange',
          borderWidth: 2,
          label: {
            enabled: true,
            fontColor: 'orange',
            content: 'LineAnno'
          }
        },
      ],
    },
  };
  public lineChartColors: Color[] = [
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    },
    { // dark grey
      backgroundColor: 'rgba(77,83,96,0.2)',
      borderColor: 'rgba(77,83,96,1)',
      pointBackgroundColor: 'rgba(77,83,96,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(77,83,96,1)'
    },
    { // red
      backgroundColor: 'rgba(255,0,0,0.3)',
      borderColor: 'red',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
  ];
  public lineChartLegend = true;
  public lineChartType = 'line';

  @ViewChild(BaseChartDirective) chart: BaseChartDirective;
  constructor(private playerService: PlayerService,private route: ActivatedRoute,private router: Router) { }

  ngOnInit() {
    this.idUser = Number(this.route.snapshot.paramMap.get('idUser'));
  

  }

       infoPlayer(){
        this.router.navigateByUrl('/playerInfo/' +this.idUser); }
       
    


  vediTraining(){
    this.router.navigateByUrl('/playerTraining/' +this.idUser);
  }

  performance(): void {
    
    this.router.navigateByUrl('/playerPerformanceView/'+ this.idUser);
    }
    
biomedical(): void {
      this.router.navigateByUrl('/playerBiomedicalDataView/'+ this.idUser);
      }

addInfo(): void {
console.log('mi arrivano info=' + this.info);
this.playerService.addInfo(this.idUser,this.info).subscribe((response) => {
      console.log('Risposta ricevuta');
            if (response != null) {
                this.router.navigateByUrl('/homePlayer/'+ this.idUser);
                }
            }
        )};
}
    



