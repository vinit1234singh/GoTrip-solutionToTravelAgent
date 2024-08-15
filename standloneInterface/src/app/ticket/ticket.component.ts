import { Component, OnInit } from '@angular/core';
import { tick } from '@angular/core/testing';
import { FormBuilder, FormGroup, FormsModule } from '@angular/forms';
import { Ticket } from '../models/ticket';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, tap } from 'rxjs';
import { errorContext } from 'rxjs/internal/util/errorContext';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { UserHeaderComponent } from '../user-header/user-header.component';
@Component({
  selector: 'app-ticket',
  standalone: true,
  imports: [FormsModule, CommonModule,UserHeaderComponent],
  templateUrl: './ticket.component.html',
  styleUrl: './ticket.component.css'
})
export class TicketComponent implements OnInit {
    ticketForm: FormGroup;
  
    
  
    constructor(private http:HttpClient, private router:Router) {
    }
    subject:string;
    description:string;
    createdDate:string = new Date().toISOString();
    status:string;
    senderId:number = Number(localStorage.getItem('userId'));
    recieverId:number;
    ticket: Ticket;
    products:any;
    ngOnInit(): void {
      this.http.get("http://localhost:8092/user_package/"+localStorage.getItem('userId')).subscribe((response)=>{
        console.log(response);
        this.products = response;
      })
    }

    onSubmit(): void {
      this.ticket = new Ticket();
      this.ticket.subject = this.subject;
      this.ticket.description = this.description;
      this.ticket.createdDate = this.createdDate;
      this.ticket.status = this.status;
      this.ticket.senderId = this.senderId;
      this.ticket.recieverId = this.recieverId;
      
      this.http.post("http://localhost:8092/tickets/create",this.ticket).subscribe(
        (response=>{
          console.log(response);
          alert("ticket Raised Success")
          this.router.navigate(['/userDashBoard'])          
        })
      );
    }
    
  }

