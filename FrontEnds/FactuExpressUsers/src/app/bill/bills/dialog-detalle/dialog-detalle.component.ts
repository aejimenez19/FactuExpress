import { Component, Input } from '@angular/core';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import { DialogContentDetalleComponent } from './dialog-content-detalle/dialog-content-detalle.component';
import { bill } from '../../../shared/Models/model';

@Component({
  selector: 'app-dialog-detalle',
  standalone: true,
  imports: [MatButtonModule, MatDialogModule],
  templateUrl: './dialog-detalle.component.html',
  styleUrl: './dialog-detalle.component.css'
})
export class DialogDetalleComponent {
  constructor(public dialog: MatDialog) {}
  @Input() factura?:bill;

  openDialog() {
    const dialogRef = this.dialog.open(DialogContentDetalleComponent,{
      height: 'auto',
      width: '550px',
      data: this.factura
      
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
