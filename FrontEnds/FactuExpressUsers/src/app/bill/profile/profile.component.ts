import { Component, OnInit } from '@angular/core';
import { NavBarComponent } from '../../shared/components/nav-bar/nav-bar.component';
import {MatIconModule} from '@angular/material/icon';
import { ServiceService } from '../../shared/service/service.service';


@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [NavBarComponent, MatIconModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{
  constructor(private service:ServiceService) {}
  info:any;
  numfac:any;
  ahorro:any;
  ngOnInit(): void {
    this.service.getInfoUser(localStorage.getItem("Id"))
    .subscribe((response: any) => {
      this.info = response;
    })

    this.service.getNumeroFacturas(localStorage.getItem("Id"))
    .subscribe((response: any) => {
      this.numfac = response.length;
      console.log(response)
    })

    this.service.getAhorro(localStorage.getItem("Id"))
    .subscribe((response: any) => {
      this.ahorro = response;
      console.log(response)
    })

  }
}
