import { Component } from '@angular/core';
import { AccountComponent } from '../../../account/account.component';
import { NgbNav, NgbNavContent, NgbNavItem, NgbNavItemRole, NgbNavLinkBase, NgbNavLinkButton, NgbNavOutlet } from '@ng-bootstrap/ng-bootstrap';
import { HistoryComponent } from '../../../history/history.component';
import { ForexComponent } from '../../../forex/forex.component';
import { ContactsComponent } from '../../../contacts/contacts.component';

@Component({
  selector: 'app-nav-bar',
  standalone: true,
  imports: [
    AccountComponent,
    NgbNav,
    NgbNavContent,
    NgbNavItem,
    NgbNavItemRole,
    NgbNavLinkBase,
    NgbNavLinkButton,
    NgbNavOutlet,
    HistoryComponent,
    ForexComponent,
    ContactsComponent
  ],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.scss'
})
export class NavBarComponent {

}
