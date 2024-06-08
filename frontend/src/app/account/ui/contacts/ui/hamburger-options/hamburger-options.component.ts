import { Component, inject, Signal } from '@angular/core';
import { UsersFilterService } from './data/users-filter.service';
import { UserContactsFilterComponent } from './ui/user-contacts-filter/user-contacts-filter.component';
import { UserContactsAdderComponent } from './ui/user-contacts-adder/user-contacts-adder.component';

@Component({
  selector: 'app-hamburger-options',
  standalone: true,
  imports: [
    UserContactsFilterComponent,
    UserContactsAdderComponent
  ],
  templateUrl: './hamburger-options.component.html',
  styleUrl: './hamburger-options.component.scss'
})
export class HamburgerOptionsComponent {

}
