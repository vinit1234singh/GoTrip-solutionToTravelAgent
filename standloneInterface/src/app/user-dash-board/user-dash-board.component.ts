import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { GetMessageComponent } from '../get-message/get-message.component';
import { TicketComponent } from '../ticket/ticket.component';
import { GetTicketComponent } from '../get-ticket/get-ticket.component';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { user } from '../models/users';
import { UserHeaderComponent } from '../user-header/user-header.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-dash-board',
  standalone: true,
  imports: [GetMessageComponent,TicketComponent,GetTicketComponent,RouterModule,CommonModule,UserHeaderComponent,FormsModule],
  templateUrl: './user-dash-board.component.html',
  styleUrl: './user-dash-board.component.css'
})
export class UserDashBoardComponent implements OnInit{
  products = [
    "Kolkata tour package",
    "Mumbai tour package",
    "Tamil Nadu tour package",
    "USA tour package"
  ];
today = new Date();
  onSubmit(){
    this.http.get("http://localhost:8092/user/increment/"+localStorage.getItem('userId')).subscribe(
      (response)=>{
        alert("Are Sure want to Buy this Package")  
        console.log(response);
        
      }
    );
  }
    constructor(private router:Router,private http:HttpClient){}
    isValid:boolean = Boolean(localStorage.getItem("isValid"))
    package:any;
    userName:any;
    ngOnInit():void{
        this.http.get("http://localhost:8092/tour").subscribe((response)=>{
          this.package = response;
          console.log(this.package);
        })
        this.http.get("http://localhost:8092/user/"+localStorage.getItem('userId')).subscribe((res:any)=>{
          console.log(res);
          this.userName = res.userName;

        })
    }
    onSubmitLog(){
      localStorage.removeItem('userId');
    }
    date:Date=null;
     pack :any = {
      "userId":null,
      "packageId":null,
      "packageName":null,
      "travellingDate":null
     };
    onProductBy(product:any){
      const pack = {
        "userId":localStorage.getItem('userId'),
        "packageId":product.packageId,
        "packageName":product.packageName,
        "travellingDate":this.date
      }
      if(this.date==null){
        alert("Date is not selected")
        this.openPopup()
      }
      else{
      this.http.post("http://localhost:8092/user_package",pack).subscribe((response)=>{
        console.log(response);
        alert("The package is added successfully")
      })
    }
      this.date = null
      this.closePopup()
    }
    showPopup = false;
    openPopup() {
      this.showPopup = true;
    }
  
    closePopup() {
      this.showPopup = false;
    }
    onSubmitDate(){
      this.pack['travellingDate'] = this.date;
      this.showPopup = false;
    }
}

