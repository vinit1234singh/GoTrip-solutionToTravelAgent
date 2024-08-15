import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserHeaderComponent } from '../user-header/user-header.component';
import { FormsModule } from '@angular/forms';
import { CommonModule, NgFor } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-buy-package',
  standalone: true,
  imports: [UserHeaderComponent,FormsModule,CommonModule,NgFor],
  templateUrl: './user-buy-package.component.html',
  styleUrl: './user-buy-package.component.css'
})
export class UserBuyPackageComponent implements OnInit{
  constructor(private http:HttpClient,private router:Router){}
  packages:any;
  ngOnInit(): void {
    this.http.get("http://localhost:8092/user_package/"+localStorage.getItem('userId')).subscribe((response)=>{
      console.log(response);
      this.packages = response;
    })
  }
  onDelete(id){
    alert("Are you sure to delete this package")
      this.http.delete("http://localhost:8092/user_package/"+id).subscribe((response)=>{
        console.log(response);
        this.router.navigate(['/userDashBoard'])
      })
  }
}
