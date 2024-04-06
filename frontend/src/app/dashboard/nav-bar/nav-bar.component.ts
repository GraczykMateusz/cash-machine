import { Component } from '@angular/core';
import { AccountComponent } from '../../account/account.component';
import { NgbNav, NgbNavContent, NgbNavItem, NgbNavItemRole, NgbNavLinkBase, NgbNavLinkButton, NgbNavOutlet } from '@ng-bootstrap/ng-bootstrap';

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
    NgbNavOutlet
  ],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.scss'
})
export class NavBarComponent {

}
