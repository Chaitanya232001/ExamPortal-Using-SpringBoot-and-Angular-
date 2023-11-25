import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from './pages/registration/registration.component';
import { SignInComponent } from './pages/sign-in/sign-in.component';
import { HomeComponent } from './pages/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { FooterComponent } from './components/footer/footer.component';
import { UpdatepasswordComponent } from './pages/updatepassword/updatepassword.component';
import { AllusersComponent } from './pages/allusers/allusers.component';

const routes: Routes = [
  
  {
    path: '',
    component:HomeComponent,
  },
  {
    path:'navbar',
    component:NavbarComponent
  },
  {
    path: 'registration',
    component: RegistrationComponent,
  },
 {
  path:'sign-in',
  component:SignInComponent,
},
{
  path:'allusers',
  component:AllusersComponent
},
{
  path:'dashboard',
  component:DashboardComponent
},
{
  path:'updatepassword',
  component:UpdatepasswordComponent
},
{
  path:'footer',
  component:FooterComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
