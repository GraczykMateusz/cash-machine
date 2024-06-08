import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserContactsFilterComponent } from './user-contacts-filter.component';

describe('UserContactsFilterComponent', () => {
  let component: UserContactsFilterComponent;
  let fixture: ComponentFixture<UserContactsFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserContactsFilterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UserContactsFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
