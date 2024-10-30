import { Component, OnInit, ViewEncapsulation, EventEmitter, Output } from '@angular/core';
import {FormControl, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {provideMomentDateAdapter} from '@angular/material-moment-adapter';
import {MatDatepicker, MatDatepickerModule} from '@angular/material/datepicker';
import * as _moment from 'moment';
import {default as _rollupMoment, Moment} from 'moment';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';

const moment = _rollupMoment || _moment;

export const MY_FORMATS = {
  parse: {
    dateInput: 'MM/YYYY',
  },
  display: {
    dateInput: 'MM/YYYY',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};

@Component({
  selector: 'app-list-mon-year',
  standalone: true,
  imports: [ MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    FormsModule,
    ReactiveFormsModule],
    providers: [
      provideMomentDateAdapter(MY_FORMATS),
    ],
  encapsulation: ViewEncapsulation.None,
  templateUrl: './list-mon-year.component.html',
  styleUrl: './list-mon-year.component.css'
})
export class ListMonYearComponent implements OnInit {
  @Output() dates = new EventEmitter<string>();
  date = new FormControl(moment());
  fecha?: string;
  mes?: any;
  year?: any;
  
  ngOnInit(): void {
    // Obtener la fecha inicial
    
  }

  setMonthAndYear(normalizedMonthAndYear: Moment, datepicker: MatDatepicker<Moment>) {
    const ctrlValue = this.date.value ?? moment();
    ctrlValue.month(normalizedMonthAndYear.month());
    ctrlValue.year(normalizedMonthAndYear.year());
    this.date.setValue(ctrlValue);
    this.mes = normalizedMonthAndYear.month() + 1;
    this.year = normalizedMonthAndYear.year();
    if (this.mes <= 9) {
      this.fecha = `${this.year}-0${this.mes}`;
    } else {
      this.fecha = `${this.year}-${this.mes}`;
    }
    this.dates.emit(this.fecha)
    datepicker.close();
  }
}

