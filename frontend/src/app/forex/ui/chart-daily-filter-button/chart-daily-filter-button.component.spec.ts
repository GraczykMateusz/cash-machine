import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChartDailyFilterButtonComponent } from './chart-daily-filter-button.component';

describe('ChartDailyFilterButtonComponent', () => {
  let component: ChartDailyFilterButtonComponent;
  let fixture: ComponentFixture<ChartDailyFilterButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChartDailyFilterButtonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChartDailyFilterButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
