import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AftermainComponent } from './aftermain.component';

describe('AftermainComponent', () => {
  let component: AftermainComponent;
  let fixture: ComponentFixture<AftermainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AftermainComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AftermainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
