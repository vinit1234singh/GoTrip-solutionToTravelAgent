import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterOutlet } from '@angular/router';
import { UsersComponent } from "./user/user.component";
import { TicketComponent } from './ticket/ticket.component';
import { GetTicketComponent } from './get-ticket/get-ticket.component';
import { MessageComponent } from './message/message.component';
import { GetMessageComponent } from "./get-message/get-message.component";
import { GetSentMessagesComponent } from "./get-sent-messages/get-sent-messages.component";
import { SignupComponent } from './signup/signup.component';
import { DashboardComponent } from './dashboard/dashboard.component'; 
import { HeaderComponent } from './header/header.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { FilterComponent } from './filter/filter.component';
import { HistoryComponent } from './history/history.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, UsersComponent, TicketComponent, GetTicketComponent, MessageComponent, GetMessageComponent, GetSentMessagesComponent,SignupComponent,DashboardComponent,HeaderComponent,UpdateProfileComponent,AdminLoginComponent,FilterComponent, HistoryComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Go Trip';

  data:string[] = ["DashBoard", "Users", "Settings", "Logout"]

}
