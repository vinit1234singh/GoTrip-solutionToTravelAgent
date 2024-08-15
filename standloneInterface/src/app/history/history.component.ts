import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { CommonModule } from '@angular/common';
import { Ticket } from '../models/ticket';
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-history',
  standalone: true,
  imports: [HeaderComponent,CommonModule],
  templateUrl: './history.component.html',
  styleUrl: './history.component.css'
})
export class HistoryComponent {

  constructor(private http:HttpClient,private fb:FormBuilder,private router:Router){}
  id:number;
  subject:string;
  description:string;
  createdDate:string;
  status:string;
  senderId:number = Number(localStorage.getItem('userId'));
  recieverId:number;
  ticket :Ticket[];
  historyticket:Ticket[];
  // ngOnInit(): void {
  //   this.http.get<Ticket[]>("http://localhost:8092/tickets/all").subscribe(
  //     (response=>{
  //       // this.ticket = response.filter(ticket => ticket.senderId === this.senderId);
  //       this.ticket = response;
  //       for(let i=0;i<this.ticket.length;i++){
  //         if(this.ticket[i].status == "Resolved"){  
  //           continue;
  //       }
  //       else{
  //         this.filteredticket.push(this.ticket[i]);
  //         console.log(this.filteredticket)
  //         }
  //       console.log(response);
  //     }
  //   })
  //   );}
  ngOnInit(): void {
    this.historyticket = []; // Initialize the array
    
    this.http.get<Ticket[]>("http://localhost:8092/tickets/all").subscribe(
      (response => {
        this.ticket = response;
        for (let i = 0; i < this.ticket.length; i++) {
          if (this.ticket[i].status == "Resolved") {
            this.historyticket.push(this.ticket[i]);
          } else {
            continue;
          }
        console.log(response);
      }
    }));
  }
    onButtonSubmit(ticketId:number,senderId:number){
      localStorage.setItem('ticketId',ticketId+"");
      localStorage.setItem('customerId',senderId+"");
      this.router.navigate(["/messages"]);
      console.log("Hello");
    }
}


