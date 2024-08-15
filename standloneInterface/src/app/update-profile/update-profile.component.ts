import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-update-profile',
  standalone: true,
  imports: [HeaderComponent,CommonModule,FormsModule],
  templateUrl: './update-profile.component.html',
  styleUrl: './update-profile.component.css'
})
export class UpdateProfileComponent {
  id!:string;
  firstname!:string;
  lastname!:string;
  email!:string;
  phonenumber!:string;

  disbale:boolean = true;
  emailval:string = this.email;
  
  constructor(private http: HttpClient) {
    this.http.get('http://localhost:8092/admin/update/'+this.emailval).subscribe((data:any) => {
      this.id = data.id;

    }
    );

   }
  updateProfile(form: any) {
    const formData = {
      id: 81,
      firstName: form.value.firstname,
      lastName: form.value.lastname,
      email: "vks@gmail.com",
      phoneNumber: form.value.phonenumber
    };

    console.log(formData);
    
    //return;
    this.http.put('http://localhost:8092/admin/update', formData)
      .subscribe(response => {
        console.log(response);
        // handle success response
        alert("Data updated");
      }, error => {
        console.error(error);
        // handle error response
      });
    }

}
