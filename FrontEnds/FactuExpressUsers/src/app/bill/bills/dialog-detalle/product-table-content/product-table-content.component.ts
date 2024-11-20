import { Component, Input, OnInit } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { producto } from '../../../../shared/Models/model';
import { ServiceService } from '../../../../shared/service/service.service';

@Component({
  selector: 'app-product-table-content',
  standalone: true,
  imports: [MatTableModule],
  templateUrl: './product-table-content.component.html',
  styleUrl: './product-table-content.component.css'
})
export class ProductTableContentComponent implements OnInit{
  @Input() id: any;
  items:any;
  constructor(private service:ServiceService){}

  ngOnInit(): void {
    this.service.getItemsWhitIdBill(this.id).subscribe((response => {
      this.items = response;
      console.log(this.items)
    }))
  }
}
