import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CopCurrencyPipe } from '../cop-currency.pipe';
import { ServiceService } from '../service.service';

interface Product {
  code_reference: string;
  name: string;
  quantity: number;
  discount: number;
  discount_rate: number;
  price: number;
  tax_rate: string;
}

interface Invoice {
  reference_code: string;
  payment_method_code: number;
  customer_identification: string;
  companyId: number;
  items: Product[];
}

@Component({
  selector: 'app-product-table',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, CopCurrencyPipe],
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.css']
})
export class ProductTableComponent {
  @Input() invoiceRef: string = '';
  @Input() clientId: string = '';
  @Input() paymentType: string = '';

  productForm: FormGroup;
  invoice: Invoice;
  sendingInvoice = false;

  constructor(private fb: FormBuilder, private serviceService: ServiceService) {
    this.productForm = this.fb.group({
      code_reference: ['', [Validators.required, Validators.pattern(/^[a-zA-Z0-9]+$/)]],
      name: ['', [Validators.required, Validators.minLength(3)]],
      quantity: [1, [Validators.required, Validators.min(1)]],
      discount: [0, [Validators.required, Validators.min(0)]],
      discount_rate: [0, [Validators.required, Validators.min(0), Validators.max(100)]],
      price: [0, [Validators.required, Validators.min(0)]],
      tax_rate: ['19.00', [Validators.required, Validators.pattern(/^\d+(\.\d{1,2})?$/)]]
    });

    this.invoice = {
      reference_code: this.invoiceRef,
      payment_method_code: 1,
      customer_identification: this.clientId,
      companyId: 0,
      items: []
    };
  }

  onSubmit() {
    if (this.productForm.valid) {
      const newProduct = this.productForm.value;
      this.invoice.items.push(newProduct);
      console.log(JSON.stringify(this.invoice, null, 2));
      this.productForm.reset({
        quantity: 1,
        discount: 0,
        discount_rate: 0,
        price: 0,
        tax_rate: '19.00'
      });
    }
  }

  enviarInvoice() {
    this.sendingInvoice = true;
    this.invoice.customer_identification=this.clientId
    this.invoice.reference_code=this.invoiceRef
    this.invoice.companyId = Number(localStorage.getItem('id'));
    console.log(this.invoice)
    this.serviceService.enviardInvoice(this.invoice).subscribe(
      (response) => {
        console.log('Invoice sent successfully', response);
        this.sendingInvoice = false;
        alert('Factura enviada exitosamente');
        this.invoice.items = [];
      },
      (error) => {
        console.error('Error sending invoice', error);
        this.sendingInvoice = false;

        alert('Error al enviar la factura. Por favor, intente nuevamente.');
      }
    );
  }

  get code_reference() { return this.productForm.get('code_reference'); }
  get name() { return this.productForm.get('name'); }
  get quantity() { return this.productForm.get('quantity'); }
  get discount() { return this.productForm.get('discount'); }
  get discount_rate() { return this.productForm.get('discount_rate'); }
  get price() { return this.productForm.get('price'); }
  get tax_rate() { return this.productForm.get('tax_rate'); }
}
