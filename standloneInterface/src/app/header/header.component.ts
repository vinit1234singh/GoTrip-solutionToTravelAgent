import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { last } from 'rxjs';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterOutlet,RouterLink,CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {
  firstName:any
  constructor(private router:Router, http: HttpClient){}
  Navigation = [
    {label:'Dashboard', href: "/dashboard"},
    {label:'Add Package',href:"/createPackage"},
    {label:'Show Package',href:'/listPackage'},
    {label:"Lead Management",href:'/lead'},
    {label:'Inbox',href:'/adminInbox'},
    {label:'Outbox',href:'/adminOutbox'},
    {label:'History',href:'/history'},
    
  ];
  onSubmit(){
      localStorage.removeItem('adminId');
      this.router.navigate(['/adminLogin'])
  }
  ngOnInit(){
    this.firstName = localStorage.getItem('firstName');
  }
  
  
}
