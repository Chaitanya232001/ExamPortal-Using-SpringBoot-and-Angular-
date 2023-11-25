import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SigninService {
  private baseUrl = "http://localhost:2001/ExamServer";

  constructor(private http: HttpClient) { }

  signIn(username: string, password: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/signin`, { username, password });
  }

  getCurrentUser() {
    return this.http.get(`${this.baseUrl}/current-user`);
  }


  public loginUser(loginData: any) {
    // You may need to adjust the API endpoint and request method based on your server implementation
    return this.http.post(`${this.baseUrl}/login`, loginData);
  }

  // isLogin: user is logged in or not
  public isLoggedIn() {
    return localStorage.getItem('user') !== null;
  }

  // logout: remove user details from local storage
  public logout() {
    localStorage.removeItem('user');
    return true;
  }

  // Set user details
  public setUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  // Get user
  public getUser() {
    let userStr = localStorage.getItem('user');
    if (userStr !== null) {
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

  // Get UserRole
  public getUserRole() {
    let user = this.getUser();
    return user.authorities[0].authority;
  }
}
//
