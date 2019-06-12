import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/models/User';
import { AdminService } from 'src/app/services/admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.css']
})
export class HomeAdminComponent implements OnInit {
  user: User;
  userList: User[];
  id: number;
  id1:number;
  type: string;
  constructor(private adminService: AdminService, private router: Router) { }
  

  ngOnInit() {
  }

  assignType(): void {
    console.log('mi arrivano tipo userId=' + this.id + ' type= ' + this.type);
    this.adminService.assignType(this.id, this.type).subscribe((response) => {
        console.log('Risposta ricevuta');
        if (response != null) {
            //console.log(response.)
            this.router.navigateByUrl('/homeAdmin');
            }
        }
    )
  }
      

  delete(): void {
    console.log('mi arrivano userId=' + this.id1);
    this.adminService.delete(this.id1).subscribe((response) => {
        console.log('Risposta ricevuta');
        if (response != null) {
            this.router.navigateByUrl('/homeAdmin');
            }
        }
    )
  }

      getUsersList(): void {
        console.log('stampo la lista di utenti ');
        this.adminService.getUsersList().subscribe((response) => {
            console.log('Risposta ricevuta');
            if (response != null) {
                this.userList=response;
                this.router.navigateByUrl('/homeAdmin');
                }
            }
        )};

}

