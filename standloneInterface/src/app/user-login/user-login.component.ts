import { Component, inject } from '@angular/core';
import { UsersService } from '../service/users-service.service';
import { user } from '../models/users';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './user-login.component.html',
  styleUrl: './user-login.component.css'
})
export class UserLoginComponent {
    constructor(private service:UsersService){
    }
    
    router : Router = inject(Router);
    userName:string;
    password:string;
    users:user;
    isValid:boolean;
    onSubmit(){
      this.users = new user();
      this.users.userName = this.userName;
      this.users.password = this.password;
      this.service.userLogin(this.users);
    }
    onSignupSubmit(){
      this.router.navigate(['/register'])
    }
}
