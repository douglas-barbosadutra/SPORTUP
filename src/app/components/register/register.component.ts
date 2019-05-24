import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/models/User';
import { RegisterService } from 'src/app/services/register.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  username: string;
  password1: string;
  password2: string;

  constructor(private registerService: RegisterService, private router: Router) { }

  ngOnInit() {
  }

  register(): void {
    console.log('mi arrivano username=' + this.username + ' password1=' + this.password1 + ' password2=' + this.password2);
    if(this.password1 === this.password2){
      console.log("dentro");
      this.registerService.register(this.username, this.password1);
      console.log("dopo register " + this.username + this.password1);
      //this.router.navigateByUrl('/login');
    }
    
  }
}
