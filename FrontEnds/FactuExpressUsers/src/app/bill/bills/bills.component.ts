import { Component, OnInit } from '@angular/core';
import { NavBarComponent } from '../../shared/components/nav-bar/nav-bar.component';
import {MatExpansionModule} from '@angular/material/expansion'; 
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import { ListMonYearComponent } from './list-mon-year/list-mon-year.component';
import { DialogDetalleComponent } from './dialog-detalle/dialog-detalle.component';
import { ServiceService } from '../../shared/service/service.service';
import { comercio } from '../../shared/Models/model';

@Component({
  selector: 'app-bills',
  standalone: true,
  imports: [NavBarComponent, MatExpansionModule,MatListModule, MatDividerModule, ListMonYearComponent, DialogDetalleComponent],
  templateUrl: './bills.component.html',
  styleUrl: './bills.component.css'
})
export class BillsComponent implements OnInit{
  panelOpenState = false;
  dates: string = '';
  fecha?: string;
  constructor(private service:ServiceService) {}
  comercios:comercio[] = [];
  ngOnInit(): void {
    const fechaActual = new Date();
    const mesActual = fechaActual.getMonth() + 1;
    const yearActual = fechaActual.getFullYear();
    if (mesActual <= 9) {
      this.fecha = `${yearActual}-0${mesActual}`;
    } else {
      this.fecha = `${yearActual}-${mesActual}`;
    }
    this.obtenerFacturas();
  }


  obtenerFacturas() {
    this.service.getFacturas(localStorage.getItem("Id"), this.fecha).subscribe((response => {
      this.comercios = response;
      console.log(response)
    }))
  }


  recibirDatoDelHijo(dato: string) {
    this.fecha = dato;
    this.obtenerFacturas();
  }
}
