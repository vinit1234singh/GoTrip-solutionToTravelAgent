import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { user } from '../models/users';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-filter',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './filter.component.html',
  styleUrl: './filter.component.css'
})
export class FilterComponent {
  filter: number = 0;
  users!:any;
  constructor(private http: HttpClient) {}
  showList:user[]=[];
  isEmpty:boolean = true;
  c:number = 0;
  onsubmit() {
    this.c = 0;
    this.http.get<user[]>("http://localhost:8092/user").subscribe(
    (res: user[]) => {
      console.log(res);
      for(let i=0;i<res.length;i++){
        if(res[i].userId == this.filter)
          {
            this.c = this.c+1;
            this.showList.push(res[i]);
            this.isEmpty = false;
          }
      }
      if(this.c ==0){
        this.isEmpty = true;
        this.showList = [];
        alert("No user found");
      }
        this.isEmpty = false;
        
      }

      
  );
 
}


}

