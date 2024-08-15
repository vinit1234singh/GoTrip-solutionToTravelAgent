import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { message } from '../models/message';
import { HttpClient } from '@angular/common/http';
import { UserHeaderComponent } from '../user-header/user-header.component';

@Component({
  selector: 'app-get-message',
  standalone: true,
  imports: [CommonModule,UserHeaderComponent],
  templateUrl: './get-message.component.html',
  styleUrl: './get-message.component.css'
})
export class GetMessageComponent implements OnInit {
  messageForm: FormGroup;

  constructor(private http: HttpClient) {
  }

  custId: Number = Number(localStorage.getItem("userId"));

  id !: Number;
  adminId !: Number;
  issueDate !: string;
  status !: string;
  priority !: string;
  message !: string;
  adminMessage !: message[];
  ngOnInit(): void {
    this.http.get<message[]>("http://localhost:8092/api/messages/cust/" + this.custId).subscribe(
      (response => {
        this.adminMessage = response;
        console.log(response);
      })
    );
  }
}
