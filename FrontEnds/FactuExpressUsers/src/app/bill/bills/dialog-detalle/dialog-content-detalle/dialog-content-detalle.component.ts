import { Component, Input, Inject, OnInit  } from '@angular/core';
import {MatDialog, MatDialogModule, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import { ProductTableContentComponent } from '../product-table-content/product-table-content.component';
import { bill, comercio } from '../../../../shared/Models/model';
import { ServiceService } from '../../../../shared/service/service.service';

@Component({
  selector: 'app-dialog-content-detalle',
  standalone: true,
  imports: [MatDialogModule, MatButtonModule, ProductTableContentComponent],
  templateUrl: './dialog-content-detalle.component.html',
  styleUrl: './dialog-content-detalle.component.css'
})
export class DialogContentDetalleComponent implements OnInit {
  factura?: any;
  constructor(@Inject(MAT_DIALOG_DATA) public data: { factura: bill | undefined}, private service:ServiceService) {
    this.factura = this.data;
  }
  comercio:any;
  items:any;

  ngOnInit(): void {
    this.service.getCompanyWhitIdBill(this.factura.id).subscribe((response => {
      this.comercio = response;
    }))

    
  }

}
