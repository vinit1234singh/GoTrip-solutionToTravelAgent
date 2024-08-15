import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-tour-package-create',
  standalone: true,
  imports: [FormsModule,CommonModule,HeaderComponent],
  templateUrl: './tour-package-create.component.html',
  styleUrl: './tour-package-create.component.css'
})
export class TourPackageCreateComponent {
  constructor(private http:HttpClient){}
  package = {
    packageName: '',
    cost: 0,
    place: ''
  };
  message:string = "";
  isValid=false;
  messageOfPackage:string="";
  messageOfPlace:string="";
  onSubmit() {
    if(this.package.cost<=0){
      this.message = "The cost cannot be 0 or less than 0";
      return;
    }
    else{
      this.message = "";
    }
    if(this.package.packageName===''){
      this.messageOfPackage = "The package name cannot be empty"
      return;
    }
    
    else{
      this.messageOfPackage = "";
    }
    if(this.package.place===''){
      this.messageOfPlace="The Place cannot be empty"
      return;
    }
    
    else{
      this.messageOfPlace = "";
    }
    this.http.post("http://localhost:8092/tour",this.package).subscribe((response)=>{
      console.log(response);
      alert("Package created successfully")

    })
  }
  onCostChange(){
    if(this.package.cost<=0){
      this.isValid = true;
    }
    else{
      this.isValid = false;
    }
  }
}
