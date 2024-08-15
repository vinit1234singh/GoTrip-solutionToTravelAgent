import { Component} from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [HeaderComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  title = 'Dashboard';
  length!:any;
  issueRaised:any = 0;
  c:number = 0
firstName: any;
  constructor(private http:HttpClient){
    this.http.get('http://localhost:8092/user').subscribe((data:any)=>{
      console.log(data);
      this.length = data.length;
    }
  );
  this.http.get('http://localhost:8092/tickets/all').subscribe((issue:any)=>{
    console.log(issue);
    for(let i=0;i<issue.length;i++){
      if(issue[i].status !== "Resolved"){
        this.c = this.c + 1;
      }
    }
    this.issueRaised = this.c
  }
);
  }
  

}
