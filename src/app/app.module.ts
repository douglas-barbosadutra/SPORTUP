import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ChartDataSets, ChartOptions } from 'chart.js';
import { Color, BaseChartDirective, Label, ChartsModule } from 'ng2-charts';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeAdminComponent } from './components/home-admin/home-admin.component';
import { LoginService } from './services/login.service';
import { HomePlayerComponent } from './components/home-player/home-player.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeTrainerComponent } from './components/home-trainer/home-trainer.component';
import { TrainerTrainingComponent } from './components/trainer-training/trainer-training.component';
import { TrainerPerformanceViewComponent } from './components/trainer-performance-view/trainer-performance-view.component';
import { PlayerBiomedicalDataViewComponent } from './components/player-biomedical-data-view/player-biomedical-data-view.component';
import { TrainerBiomedicalDataViewComponent } from './components/trainer-biomedical-data-view/trainer-biomedical-data-view.component';
import { BiomedicalGraphComponent } from './components/biomedical-graph/biomedical-graph.component';

import { TrainerTeamComponent } from './components/trainer-team/trainer-team.component';
import { PlayerTrainingComponent } from './components/player-training/player-training.component';
import { PlayerPerformanceViewComponent } from './components/player-performance-view/player-performance-view.component';
import { HomeNutritionistComponent } from './components/home-nutritionist/home-nutritionist.component';
import { PlayerInfoComponent } from './components/player-info/player-info.component';
import { NutritionistDietViewComponent } from './components/nutritionist-diet-view/nutritionist-diet-view.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeAdminComponent,
    HomePlayerComponent,
    HomeTrainerComponent,
    TrainerTrainingComponent,
    TrainerTeamComponent,
    PlayerTrainingComponent,
    PlayerBiomedicalDataViewComponent,
    PlayerPerformanceViewComponent,
    HomeNutritionistComponent,
    TrainerPerformanceViewComponent,
    TrainerBiomedicalDataViewComponent,
    PlayerInfoComponent,
    BiomedicalGraphComponent,
    NutritionistDietViewComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    ChartsModule


  ],
  providers: [
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
