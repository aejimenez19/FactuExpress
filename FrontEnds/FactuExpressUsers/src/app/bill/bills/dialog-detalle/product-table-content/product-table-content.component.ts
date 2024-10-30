import { Component, Input, OnInit } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { producto } from '../../../../shared/Models/model';
export interface PeriodicElement {
  id: number;
  Descripcion: string;
  Cantidad: number;
  Total: number;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {id: 1, Descripcion: 'Hydrogen', Cantidad: 1.0079, Total: 10000},
  {id: 2, Descripcion: 'Helium', Cantidad: 4.0026, Total: 275000},
  {id: 3, Descripcion: 'Lithium', Cantidad: 6.941, Total: 190500},
  {id: 4, Descripcion: 'Beryllium', Cantidad: 9.0122, Total: 20000},
  {id: 5, Descripcion: 'Boron', Cantidad: 10.811, Total: 45000},
];

@Component({
  selector: 'app-product-table-content',
  standalone: true,
  imports: [MatTableModule],
  templateUrl: './product-table-content.component.html',
  styleUrl: './product-table-content.component.css'
})
export class ProductTableContentComponent implements OnInit{
  displayedColumns: string[] = ['id', 'Descripcion', 'Cantidad', 'Total'];
  producto: producto[] = [];
  @Input() productos?: producto[];
  dataSource = this.producto;

  ngOnInit(): void {
    if (this.productos) {
      this.producto = this.productos
      this.dataSource = this.producto
    }
  }
}
