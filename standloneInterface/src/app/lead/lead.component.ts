import { Component, OnInit } from '@angular/core';
import { Lead } from '../models/lead';
import { user } from '../models/users';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-lead',
  standalone: true,
  imports: [FormsModule,CommonModule,HeaderComponent],
  templateUrl: './lead.component.html',
  styleUrl: './lead.component.css'
})
export class LeadComponent implements OnInit{
    constructor(private http:HttpClient){}
    lead:Lead[]=[];
    users:user[]=[];
    combo:{}[]=[];
    ngOnInit(): void {
      this.http.get<user[]>("http://localhost:8092/user").subscribe(
        (response=>{
          this.users = response;
          // console.log(this.users);
          // console.log(this.users[0]);
          for(let i=0;i<this.users.length;i++){
            
            const obj = {'user':this.users[i],'lead':i};
            this.combo.sort((a,b)=>a['lead']-b['lead'])
            // console.log(obj.lead+"Hello");
            this.http.get<Lead>("http://localhost:8092/user_package"+this.users[i].userId).subscribe((response)=>{
              if(response!==null){
                this.lead.push(response);
              }

            })
          }
        })
      );
     
    }
    
}
