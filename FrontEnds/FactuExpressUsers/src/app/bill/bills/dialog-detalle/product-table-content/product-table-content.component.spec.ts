import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductTableContentComponent } from './product-table-content.component';

describe('ProductTableContentComponent', () => {
  let component: ProductTableContentComponent;
  let fixture: ComponentFixture<ProductTableContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductTableContentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProductTableContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
