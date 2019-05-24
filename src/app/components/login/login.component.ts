import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/models/User';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  login(f: NgForm): void {
    console.log('mi arrivano username=' + f.value.username + ' password=' + f.value.password);
    this.loginService.login(f.value.username, f.value.password).subscribe((response) => {
        console.log('Risposta ricevuta');
        if (response != null) {
            this.user = response;
            sessionStorage.setItem('user', JSON.stringify(this.user));
            console.log('Username: ' + this.user.username);
            if (response.type === 'admin') {
                this.router.navigateByUrl('/homeAdmin');
            }
            if (response.type === 'player') {
                this.router.navigateByUrl('/homePlayer/'+response.idUser);
            }
            if (response.type === 'trainer') {
                this.router.navigateByUrl('/homeTrainer');
            }
            if (response.type === 'nutritionist') {
                this.router.navigateByUrl('/homeNutritionist');
            }
        }
    });
}

}
