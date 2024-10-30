import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogContentDetalleComponent } from './dialog-content-detalle.component';

describe('DialogContentDetalleComponent', () => {
  let component: DialogContentDetalleComponent;
  let fixture: ComponentFixture<DialogContentDetalleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DialogContentDetalleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DialogContentDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
