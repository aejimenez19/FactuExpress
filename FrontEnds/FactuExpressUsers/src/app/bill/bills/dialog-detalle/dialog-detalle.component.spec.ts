import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogDetalleComponent } from './dialog-detalle.component';

describe('DialogDetalleComponent', () => {
  let component: DialogDetalleComponent;
  let fixture: ComponentFixture<DialogDetalleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DialogDetalleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DialogDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
