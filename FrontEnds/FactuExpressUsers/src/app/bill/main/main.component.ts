import { AfterContentInit, Component, OnInit } from '@angular/core';
import { NavBarComponent } from '../../shared/components/nav-bar/nav-bar.component';
import { RouterModule } from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import { DialogComponent } from './dialog/dialog.component';
import { MatFormField, MatFormFieldControl } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { MatInput } from '@angular/material/input';
import { ServiceService } from '../../shared/service/service.service';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [NavBarComponent, RouterModule, MatFormField, FormsModule, MatInput],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent implements AfterContentInit{
  show:any = true
  constructor(public dialog: MatDialog,private service:ServiceService ) {}
  ahorro:number = 0


  ngAfterContentInit(): void {
  const email = localStorage.getItem("Email");

  this.service.getUserForEmail(email).subscribe({
    next: (response: any) => {
      if (response) {
        this.handleUserResponse(response);
      } else {
        this.openDialog();
      }
    },
    error: (err) => {
      if(err.status === 404){
        this.openDialog(); // Manejar errores también aquí si es necesario
      }
    }
  });
}

private handleUserResponse(response: any): void {
  localStorage.setItem("Id", response.id);
 /* this.service.getAhorro(response.id).subscribe({
    next: (ahorroResponse: any) => {
      this.ahorro = ahorroResponse;
      //console.log(this.ahorro);
      // Puedes agregar lógica adicional para manejar el ahorro aquí
    },
    error: () => {
      // Manejar errores en la solicitud de ahorro si es necesario
      this.openDialog(); 
    }
  });*/
}

private openDialog(): void {
  this.show = true;
  this.dialog.open(DialogComponent, {
    height: '400px',
    width: '850px',
    disableClose: true
  });
}

}
