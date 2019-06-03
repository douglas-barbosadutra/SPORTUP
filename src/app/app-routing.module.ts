import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
/** Login */
import { LoginComponent } from './components/login/login.component';
/** Home */
import { HomeAdminComponent } from './components/home-admin/home-admin.component';
import { HomePlayerComponent } from './components/home-player/home-player.component';
import { HomeNutritionistComponent } from './components/home-nutritionist/home-nutritionist.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeTrainerComponent } from './components/home-trainer/home-trainer.component';
/** Training */
import { TrainerTrainingComponent } from './components/trainer-training/trainer-training.component';
import { TrainerBiomedicalDataViewComponent } from './components/trainer-biomedical-data-view/trainer-biomedical-data-view.component';

import { TrainerTeamComponent } from './components/trainer-team/trainer-team.component';
import { PlayerTrainingComponent } from './components/player-training/player-training.component';
import { PlayerInfoComponent } from './components/player-info/player-info.component';

/** Player */
import { PlayerBiomedicalDataViewComponent } from './components/player-biomedical-data-view/player-biomedical-data-view.component';
import { PlayerPerformanceViewComponent } from './components/player-performance-view/player-performance-view.component';
import { TrainerPerformanceViewComponent } from './components/trainer-performance-view/trainer-performance-view.component';
import { BiomedicalGraphComponent } from './components/biomedical-graph/biomedical-graph.component';
import { NutritionistDietViewComponent } from './components/nutritionist-diet-view/nutritionist-diet-view.component';
const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'homeAdmin', component: HomeAdminComponent },
  { path: 'homePlayer/:idUser', component: HomePlayerComponent },
  { path: 'homeTrainer', component: HomeTrainerComponent },
  { path: 'trainerTraining', component: TrainerTrainingComponent },
  { path: 'trainerTeam', component: TrainerTeamComponent },
  { path: 'playerTraining/:idUser', component: PlayerTrainingComponent },
  { path: 'playerBiomedicalDataView/:idUser', component: PlayerBiomedicalDataViewComponent},
  { path: 'playerPerformanceView/:idUser', component: PlayerPerformanceViewComponent},
  { path: 'playerInfo/:idUser', component: PlayerInfoComponent},
  { path: 'trainerPerformanceView/:id', component: TrainerPerformanceViewComponent},
  { path: 'trainerBiomedicalDataView/:id', component: TrainerBiomedicalDataViewComponent},
  { path: 'homeNutritionist', component: HomeNutritionistComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'biomedicalGraph', component: BiomedicalGraphComponent },
  { path: 'nutritionistDietView/:idPlayer', component: NutritionistDietViewComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
