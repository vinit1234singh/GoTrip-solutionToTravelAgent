import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { UsersService } from '../service/users-service.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-deletion',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './user-deletion.component.html',
  styleUrl: './user-deletion.component.css'
})
export class UserDeletionComponent {
  userId:number;
  constructor(private http:HttpClient){
  }
  service:UsersService = inject(UsersService);
  public onSubmit(){
    this.service.userDeletion(this.userId);
  }
}
