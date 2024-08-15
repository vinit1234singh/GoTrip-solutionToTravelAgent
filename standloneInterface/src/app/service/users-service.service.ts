import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { user } from '../models/users';
import { catchError, Observable, tap } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
    constructor(private http:HttpClient){}
    router:Router = inject(Router);
    public userAddition(users:user){
       this.http.post('http://localhost:8092/user', users).subscribe((response=>{
        console.log(response);
        if(response!==null){
          localStorage.setItem('userId',response['userId'])
          alert("User Created Successfully");
          this.router.navigate(['/login'])
        }
        else{
          alert("The user is not created due to unique constraint of user name");
        }
       }),(error) => {
        if (error.status == 500) {
          alert("Email is already used")
        } else {
          alert("Internal server error")
        }
      });
    }
    public userDeletion(id:number){
        this.http.delete('http://localhost:8092/user/'+id).subscribe(
          (response)=>{
            console.log(response);       
          }
        )
    }
    public userLogin(users:user){
      this.http.post("http://localhost:8092/user/login",users).subscribe((response)=>{
        // localStorage.setItem('isValid',response+"");
        if(response!==null){
          localStorage.setItem('userId',response['userId'])
          console.log(response['userId']);
          
          this.router.navigate(["/userDashBoard"])
        }
        else{
          // this.router.navigate(["/error"])
          alert("Invalid Credentials")
        }
      });
    }

}