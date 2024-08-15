import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-admin-list-packages',
  standalone: true,
  imports: [FormsModule,CommonModule,HeaderComponent],
  templateUrl: './admin-list-packages.component.html',
  styleUrl: './admin-list-packages.component.css'
})
export class AdminListPackagesComponent implements OnInit{
    deletePackage(product: any) {
      alert("Do you want to delete the package");
      this.http.delete("http://localhost:8092/tour/"+product.id).subscribe((response)=>{
        this.packages = response
      })
    }
    constructor(private http:HttpClient){}
    packages:any;
  ngOnInit(): void {
    this.http.get("http://localhost:8092/tour").subscribe((response)=>{
      this.packages = response
    })
  }

}
