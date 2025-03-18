import { Component } from '@angular/core';
import { UserContactsFilterComponent } from './ui/user-contacts-filter/user-contacts-filter.component';
import { UserContactsAdderComponent } from './ui/user-contacts-adder/user-contacts-adder.component';

@Component({
  selector: 'app-hamburger-options',
  imports: [
    UserContactsFilterComponent,
    UserContactsAdderComponent
  ],
  templateUrl: './hamburger-options.component.html',
  styleUrl: './hamburger-options.component.scss'
})
export class HamburgerOptionsComponent {

}
