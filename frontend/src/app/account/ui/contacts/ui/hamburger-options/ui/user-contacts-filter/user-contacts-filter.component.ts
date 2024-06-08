import { Component, inject, Signal } from '@angular/core';
import { UsersFilterService } from '../../data/users-filter.service';

@Component({
  selector: 'app-user-contacts-filter',
  standalone: true,
  imports: [],
  templateUrl: './user-contacts-filter.component.html',
  styleUrl: './user-contacts-filter.component.scss'
})
export class UserContactsFilterComponent {
  
  private readonly userFilter: UsersFilterService = inject(UsersFilterService);
  readonly filterValue: Signal<string> = this.userFilter.filterValue;
  
  filter(event: Event): void {
    const filterValue: string = (event.target as HTMLInputElement).value;
    this.userFilter.setValue(filterValue);
  }
}
