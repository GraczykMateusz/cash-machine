import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HamburgerOptionsComponent } from './hamburger-options.component';

describe('HamburgerOptionsComponent', () => {
  let component: HamburgerOptionsComponent;
  let fixture: ComponentFixture<HamburgerOptionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HamburgerOptionsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HamburgerOptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
