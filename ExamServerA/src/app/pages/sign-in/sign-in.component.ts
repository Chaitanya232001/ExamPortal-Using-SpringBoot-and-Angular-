import { Component } from '@angular/core';
import { SigninService } from '../../services/signin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css'],
})
export class SignInComponent {
  Registration = {
    username: '',
    password: '',
  };

  constructor(private signin: SigninService, private router: Router) {}

  formSubmit() {
    this.router.navigate(['/dashboard']);
    if (
      this.Registration.username.trim() === '' ||
      this.Registration.password.trim() === ''
    ) {
      alert('Username and Password are required!');
      return;
    }

    this.signin
      .signIn(this.Registration.username, this.Registration.password)
      .subscribe((data: any) => {
        console.log('success');
        console.log(data);

        // Login
        this.signin.getCurrentUser().subscribe(
          (user: any) => {
            this.signin.setUser(user);
            console.log(user);
           
          },
          (error: any) => {
            console.error('Error logging in:', error);
          }
        );
      });
  }
}
