import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Ticket } from '../models/ticket';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserHeaderComponent } from '../user-header/user-header.component';
import { HeaderComponent } from "../header/header.component";
@Component({
  selector: 'app-get-ticket',
  standalone: true,
  imports: [CommonModule, FormsModule, UserHeaderComponent, HeaderComponent],
  templateUrl: './get-ticket.component.html',
  styleUrl: './get-ticket.component.css'
})
export class GetTicketComponent implements OnInit{
  ticketForm: FormGroup;
  // tickets: Ticket[]=[];
  constructor(private http:HttpClient,private fb:FormBuilder, private router:Router){}
    id:number;
    subject:string;
    description:string;
    createdDate:string;
    status:string;
    senderId:number = Number(localStorage.getItem('userId'));
    recieverId:number;
    ticket :Ticket[];
    ngOnInit(): void {
      this.http.get<Ticket[]>("http://localhost:8092/tickets/user/"+this.senderId).subscribe(
        (response=>{
          // this.ticket = response.filter(ticket => ticket.senderId === this.senderId);
          this.ticket = response;
          console.log(response);
          // this.router.navigate(['/userDashBoard'])


        })
      );}
}



