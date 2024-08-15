import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  standalone: true,
  imports: [FormsModule,CommonModule,RouterLink],
  templateUrl: './admin-login.component.html',
  styleUrl: './admin-login.component.css'
})
export class AdminLoginComponent {
  loginobj: Login;

  constructor(private http: HttpClient, private router: Router) {
    this.loginobj = new Login();
    this.router = router;
  }

  checkemail: boolean = true;
  message: string = '';

  checkEmail() {
    const emailRegex: RegExp = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    this.checkemail = emailRegex.test(this.loginobj.EmailId);
    console.log(this.checkemail);
    
    if (!this.checkemail) {
      this.message = "Please enter a valid email address";
    } else {
      this.message = '';
    }
  }
  email = '';
  firstname!:string;
  password:string='';
  OnLogin() {
    this.loginobj.Password = this.password;
    this.loginobj.EmailId = this.email;
    console.log(this.loginobj.EmailId);
    
    if (this.loginobj.Password.length < 6) {
      this.message = "Password should be at least 6 characters long";
      alert(this.message);
      return;
    }
    if (!this.checkemail) {
      this.message = "Please enter a valid email address";
      alert(this.message);
      return;
    }
    
    this.http.get("http://localhost:8092/admin/" + this.loginobj.EmailId)
      .subscribe(
        (res: any) => {
          console.log(res);
          if (res && res.firstName && res.password || res.id) {
            // Assign fetched values to component properties
            this.firstname = res.firstName;
            this.password = res.password;
            localStorage.setItem('adminId',res.id);
            
            // Compare entered password with fetched password
            if (this.loginobj.Password === this.password) {
              localStorage.setItem('adminId',res['id']);
              localStorage.setItem('firstName',res['firstName']);
              console.log(res['firstName']);
              
              
              this.router.navigate(['/dashboard']);
            } else {
              alert("Incorrect Password");
            }
          } else {
            alert("User not found or incomplete response");
          }
        },
        (error) => {
          console.error('Error occurred:', error);
          alert("Error occurred while logging in");
        }
      );
  }

}

export class Login {
  EmailId: string;
  Password: string;

  constructor() {
    this.EmailId = "";
    this.Password = "";
  }
}
