import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrationsService {
  

  constructor(public http: HttpClient) {}
  private baseUrl ="http://localhost:2001/ExamServer";
  private baseUrl1= "http://localhost:2001/ExamServer/allUsers";

  addUser(registration: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/Registration`, registration);
  }

  // allUsers(): Observable<any> {
  //   return this.http.get<any[]>(`${this.baseUrl}/allUsers`);
  // }

  allUsers(){
    return this.http.get(this.baseUrl1);
  }

  // deleteRegistrationById(id: number): Observable<void> {
  //   return this.http.delete<void>(`${this.baseUrl}/deleteRegistration/${id}`);
  // }
  deleteUser(id: number): Observable<Object>{
    return this.http.delete(`${this.baseUrl}/register/${id}`);
  }
  updatePassword(password: { username: string ; password: string; newPassword: string; }) {
    const url = `${this.baseUrl}/ForgotPassword`;
    return this.http.post(url, password);
  }
}
