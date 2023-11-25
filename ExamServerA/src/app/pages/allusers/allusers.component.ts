
import { Component, OnInit } from '@angular/core';
import { RegistrationsService } from '../../services/registrations.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-allusers',
  templateUrl: './allusers.component.html',
  styleUrls: ['./allusers.component.css']
})
export class AllusersComponent implements OnInit {
  registrations: any[] = [];

  constructor(
    public registrationsService: RegistrationsService,
    private router: Router
  ) {}

  ngOnInit() {
    this.formSubmit();
  }
  formSubmit() {
    this.registrationsService.allUsers().subscribe((data: any) => {
      console.log(data); // Log the response data
      this.registrations = data;
    });
  }
}
