import { Component } from '@angular/core';
import { HomeHeaderComponent } from "../home-header/home-header.component";
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [HomeHeaderComponent],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {
    constructor(private router:Router){}
    userLoginClick(){
      this.router.navigate(['/login'])
    }
    adminLoginClick(){
      this.router.navigate(['/adminLogin']);
    }
}
