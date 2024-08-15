import { Component, inject, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { user } from '../models/users';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { UsersService } from '../service/users-service.service';

@Component({
  standalone:true,
  selector: 'app-users',
  imports:[FormsModule,CommonModule],
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UsersComponent {
  users: user;
  userName: string;
  age: number;
  address: string;
  email: string;
  mobileNo: number;
  password: string;
  confirmpassword:string;
  occupation: string;

  constructor(private http: HttpClient) { }
  userService = inject(UsersService);
  response:any;
  createUser(): void {
    this.users = new user();
    this.users.userName =  this.userName,
    this.users.age= this.age,
    this.users.address= this.address,
    this.users.email= this.email,
    this.users.mobileNo= this.mobileNo,
    this.users.password= this.password,
    
    this.users.occupation= this.occupation
    console.log(this.users);
    if(this.password!=this.confirmpassword){
      alert("password and confirm password should be same")
      
    }
    else{
      this.response = this.userService.userAddition(this.users); 
     console.log(this.response);
     
    }
    
  }

}