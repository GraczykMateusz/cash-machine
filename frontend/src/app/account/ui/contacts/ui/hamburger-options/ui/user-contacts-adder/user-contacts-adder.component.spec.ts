import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserContactsAdderComponent } from './user-contacts-adder.component';

describe('UserContactsAdderComponent', () => {
  let component: UserContactsAdderComponent;
  let fixture: ComponentFixture<UserContactsAdderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserContactsAdderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserContactsAdderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
