import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-user-header',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './user-header.component.html',
  styleUrl: './user-header.component.css'
})
export class UserHeaderComponent {
  onSubmitLog(){
    localStorage.removeItem('customerId');
  }
  constructor(private router:Router,private http:HttpClient){}
  userName:any;
  ngOnInit():void{
    this.http.get("http://localhost:8092/user/"+localStorage.getItem('userId')).subscribe((res:any)=>{
      console.log(res);
      this.userName = res.userName;

    })
}
}
