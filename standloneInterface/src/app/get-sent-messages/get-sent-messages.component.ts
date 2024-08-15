import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { message } from '../models/message';
import { HeaderComponent } from '../header/header.component';
import { AppComponent } from "../app.component";

@Component({
  selector: 'app-get-sent-messages',
  standalone: true,
  imports: [CommonModule, HeaderComponent, AppComponent],
  templateUrl: './get-sent-messages.component.html',
  styleUrl: './get-sent-messages.component.css'
})
export class GetSentMessagesComponent implements OnInit{
  constructor(private http:HttpClient){
    
  }
  // admnId : Number = 1;

  id !: Number;
  customerId !: Number;
  adminId !: Number;
  issueDate !: string;
  status !: string;
  priority !: string;
  message !: string;
  adminMessage !: message[];

  ngOnInit(): void {
    this.http.get<message[]>("http://localhost:8092/api/messages/admin/"+localStorage.getItem('adminId')).subscribe(
      (response=>{
        this.adminMessage = response;
        // this.adminMessage = this.adminMessage.filter((res) => {
        //   return res.adminId === Number(localStorage.getItem('adminId'));
        // })
        console.log(localStorage.getItem('adminId'));
      })
    );
  }

}
