import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMonYearComponent } from './list-mon-year.component';

describe('ListMonYearComponent', () => {
  let component: ListMonYearComponent;
  let fixture: ComponentFixture<ListMonYearComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListMonYearComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListMonYearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
