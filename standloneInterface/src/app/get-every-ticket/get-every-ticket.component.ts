import { HttpClient, HttpParams} from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormsModule } from '@angular/forms';
import { Ticket } from '../models/ticket';
import { CommonModule } from '@angular/common';
import { Route, Router } from '@angular/router';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-get-every-ticket',
  standalone: true,
  imports: [CommonModule,FormsModule,HeaderComponent],
  templateUrl: './get-every-ticket.component.html',
  styleUrl: './get-every-ticket.component.css'
})
export class GetEveryTicketComponent {
  constructor(private http:HttpClient,private fb:FormBuilder,private router:Router){}
  id:number;
  subject:string;
  description:string;
  createdDate:string;
  status:string;
  senderId:number = Number(localStorage.getItem('userId'));
  recieverId:number;
  ticket :Ticket[];
  filteredticket:Ticket[];
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
    this.filteredticket = []; // Initialize the array
    
    this.http.get<Ticket[]>("http://localhost:8092/tickets/all").subscribe(
      (response => {
        this.ticket = response;
        for (let i = 0; i < this.ticket.length; i++) {
          if (this.ticket[i].status == "Resolved") {
            continue;
          } else {
            this.filteredticket.push(this.ticket[i]);
            console.log(this.filteredticket)
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
