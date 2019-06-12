import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/models/User';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Login } from 'src/app/models/Login';
import { HttpClient } from '@angular/common/http';

@Component({

    selector: 'app-login',
  
    templateUrl: './login.component.html',
  
    styleUrls: ['./login.component.css']
  
  })
  
  export class LoginComponent implements OnInit {
  
  
  
    private idUtenteLocale: number;
  
    public log: Login;
  
  
  
    constructor(private loginService: LoginService, private router:  Router, private http: HttpClient) { }
  
  
  
    ngOnInit(){
  
      this.log = new Login("","");
  
    }
  
  
  
    login(f:NgForm): void{
  
  
  
      this.loginService.login(this.log).subscribe((response: any) => {
  
        console.log(response);
  
        localStorage.setItem("currentUser", JSON.stringify({ "authorities": response.id_token }));
  
  
  
        this.loginService.getUserLogged(this.log.username).subscribe((response: User) => {
  
          console.log(response);
  
          localStorage.setItem("currentUserData", JSON.stringify(response));
  
  
  
          if(response.authorities.includes("ROLE_EMPLOYEE"))
  
            this.router.navigateByUrl("homeEmployee");
  
          else
  
          this.router.navigateByUrl("homeUser");
  
        })
  
      });
  
      
  
    }
  
  
  
  }
