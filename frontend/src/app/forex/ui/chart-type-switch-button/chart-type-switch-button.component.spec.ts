import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChartTypeSwitchButtonComponent } from './chart-type-switch-button.component';

describe('ChartTypeSwitchButtonComponent', () => {
  let component: ChartTypeSwitchButtonComponent;
  let fixture: ComponentFixture<ChartTypeSwitchButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChartTypeSwitchButtonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChartTypeSwitchButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
