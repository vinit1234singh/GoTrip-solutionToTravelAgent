import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-home-header',
  standalone: true,
  imports: [CommonModule,RouterLink,RouterOutlet],
  templateUrl: './home-header.component.html',
  styleUrl: './home-header.component.css'
})
export class HomeHeaderComponent {
  Navigation = [
    {label:'About Services', href: "/aboutservices"},
    {label:'Admin Login', href:'/adminLogin'},
    {label: 'User Login', href:'/login'},
    
  ];

}
