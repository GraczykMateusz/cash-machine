import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChartTenMinutesFilterButtonComponent } from './chart-ten-minutes-filter-button.component';

describe('ChartTenMinutesFilterButtonComponent', () => {
  let component: ChartTenMinutesFilterButtonComponent;
  let fixture: ComponentFixture<ChartTenMinutesFilterButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChartTenMinutesFilterButtonComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ChartTenMinutesFilterButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
