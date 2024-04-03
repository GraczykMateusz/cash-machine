import { Component } from '@angular/core';
import { NgbDropdown, NgbDropdownItem, NgbDropdownMenu, NgbDropdownToggle, NgbNavModule } from '@ng-bootstrap/ng-bootstrap';
import { NgOptimizedImage } from '@angular/common';
import { AccountComponent } from '../account/account.component';
import { LanguageComponent } from '../language/language.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    NgbNavModule,
    NgOptimizedImage,
    NgbDropdown,
    NgbDropdownMenu,
    NgbDropdownItem,
    NgbDropdownToggle,
    AccountComponent,
    LanguageComponent
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
  
  username: string = 'Mateusz';
  currentLanguage = 'eng';
  
  changeLanguage(language: string) {
    this.currentLanguage = language;
  }
}
