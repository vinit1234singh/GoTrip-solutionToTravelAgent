import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { message } from '../models/message';
import { HttpClient, HttpParams } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Ticket } from '../models/ticket';
import { HeaderComponent } from '../header/header.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-message',
  standalone: true,
  imports: [CommonModule, FormsModule,HeaderComponent],
  templateUrl: './message.component.html',
  styleUrl: './message.component.css'
})
export class MessageComponent {
    id !: Number;
    customerId : Number = Number(localStorage.getItem('customerId'));
    adminId : Number = Number(localStorage.getItem('adminId'));
    issueDate : String = new Date().toISOString();
    status !: string;
    priority !: string;
    message !: string;
    adminMessage !: message;

    constructor(private http : HttpClient, private router:Router){

    }
    onSubmit(){
      this.adminMessage = new message();
      this.adminMessage.id = this.id ;
      this.adminMessage.adminId = this.adminId;
      this.adminMessage.customerId = this.customerId;
      this.adminMessage.issueDate = this.issueDate;
      this.adminMessage.status = this.status;
      this.adminMessage.priority = this.priority;
      this.adminMessage.message = this.message;
      this.http.post("http://localhost:8092/api/messages",this.adminMessage).subscribe(
        Response => console.log(Response)
      );
      alert("The message is sent")
      const httpParams = new HttpParams().set('status',this.status);
      this.http.get<Ticket>("http://localhost:8092/tickets/update/"+localStorage.getItem('ticketId')+"/"+this.status).subscribe((response)=>{
        console.log("http://localhost:8092/tickets/update/"+localStorage.getItem('ticketId')+"/"+this.status);
        this.router.navigate(['/dashboard']) 
      });
      }

}
