import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChartFilterSwitchButtonComponent } from './chart-filter-switch-button.component';

describe('ChartFilterSwitchButtonComponent', () => {
  let component: ChartFilterSwitchButtonComponent;
  let fixture: ComponentFixture<ChartFilterSwitchButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChartFilterSwitchButtonComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ChartFilterSwitchButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
