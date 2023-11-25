import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  constructor(private  router: Router){}
  logout() {
    // this.authservice.logout();
    // this.authservice.navigate(['/sign-in']);
  }

  deleteAccount() {
    // this.authservice.deleteAccount();
    // this.authservice.navigate(['/sign-in']);
  }
}
