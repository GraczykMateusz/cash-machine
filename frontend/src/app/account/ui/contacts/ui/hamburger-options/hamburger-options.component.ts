import { Component, inject, Signal } from '@angular/core';
import { UsersFilterService } from './data/users-filter.service';

@Component({
  selector: 'app-hamburger-options',
  standalone: true,
  imports: [],
  templateUrl: './hamburger-options.component.html',
  styleUrl: './hamburger-options.component.scss'
})
export class HamburgerOptionsComponent {
  
  private readonly userFilter: UsersFilterService = inject(UsersFilterService);
  readonly filterValue: Signal<string> = this.userFilter.filterValue;
  
  filter(event: Event): void {
    const filterValue: string = (event.target as HTMLInputElement).value;
    this.userFilter.setValue(filterValue);
  }
  
  addNewContact() {
  
  }
}
