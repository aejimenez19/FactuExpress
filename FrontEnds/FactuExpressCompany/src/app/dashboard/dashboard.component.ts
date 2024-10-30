import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ProductTableComponent } from '../product-table/product-table.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, NgModel } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [RouterLink, ProductTableComponent, HttpClientModule, FormsModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
    invoiceRef: string = '';
    clientId: string = '';
    paymentType: string = '';
  

}
