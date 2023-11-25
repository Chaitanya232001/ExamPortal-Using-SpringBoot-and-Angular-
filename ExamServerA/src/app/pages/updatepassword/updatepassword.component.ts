import { Component } from '@angular/core';
import { RegistrationsService } from '../../services/registrations.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-updatepassword',
  templateUrl: './updatepassword.component.html',
  styleUrl: './updatepassword.component.css'
})
export class UpdatepasswordComponent {
  password = {
    username: '',
    password: '',
    newPassword: ''
  };
  constructor(public registrations: RegistrationsService,  router: Router){}
  formSubmit() {
    //this.router.navigate(['/sign-in']);
    if (this.validateForm()) {
      this.registrations.updatePassword(this.password).subscribe((response: any) => {
        console.log(response);
      });
    }
  }

  private validateForm(): boolean {
    if (!this.password.newPassword) {
      return false;
    }

    return true;
  }
}
