import {Component, OnInit} from '@angular/core';
import {Product} from "./entity/product";
import {HttpService} from "./service/http.service";
import {Romance} from "./entity/romance";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  protected readonly styleClick : string = 'md:dark:text-blue-500'
  protected tagA : string[]= ['home','about','services','pricing','contract']
  protected styles : string[]= ['','','','','']
  protected declare products : Product[]
  protected declare romances : Romance[]
  constructor(private httpService : HttpService) {
    this.httpService.getRomances().subscribe((res : any) =>{
      this.romances = res
      console.log(this.romances)
    })
  }

  ngOnInit(): void {
    this.products = []
    this.products[0] = new Product(1,'Apple MacBook Pro 17"','Silver','Laptop',29000.00)
    this.products[1] = new Product(2,'Microsoft Surface Pro','Silver','Laptop PC',39000.00)
    this.products[2] = new Product(3,'Magic Mouse 2','Black','Accessories',890.00)
  }
  protected setStyle(tag:string){
    if (tag===this.tagA[0]) {
      this.styles[0]=this.styleClick
      this.styles[1]=''
      this.styles[2]=''
      this.styles[3]=''
      this.styles[4]=''
    }
    else if (tag===this.tagA[1]) {
      this.styles[0]=''
      this.styles[1]=this.styleClick
      this.styles[2]=''
      this.styles[3]=''
      this.styles[4]=''
    }
    else if (tag===this.tagA[2]) {
      this.styles[0]=''
      this.styles[1]=''
      this.styles[2]=this.styleClick
      this.styles[3]=''
      this.styles[4]=''
    }
    else if (tag===this.tagA[3]) {
      this.styles[0]=''
      this.styles[1]=''
      this.styles[2]=''
      this.styles[3]=this.styleClick
      this.styles[4]=''
    }
    else if (tag===this.tagA[4]) {
      this.styles[0]=''
      this.styles[1]=''
      this.styles[2]=''
      this.styles[3]=''
      this.styles[4]=this.styleClick
    }
  }
}
