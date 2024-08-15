import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormsModule, NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  firstname!:string;
  lastname!:string;
  email!:string;
  password!:string;
  confirmPassword!:string;
  phoneNumber!:string;
  constructor(private fb: FormBuilder, private http: HttpClient,private router:Router) {
    
  }
  
  signProfile(form: NgForm) {
    console.log(form);
    
    if (form.valid) {
      const formData = form.value;
      console.log(formData);
   
      this.http.post('http://localhost:8092/admin/create', formData)
        .subscribe(response => {
          console.log(response);
          alert("Sign Up Success Kindly Login using the Email and Password!");
          this.router.navigate(['/adminLogin']);
        }, error => {
          alert("There is an error occured");
          
          // console.error(error);
        });
    }
  }
}
