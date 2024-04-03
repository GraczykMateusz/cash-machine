import { Component } from '@angular/core';
import { NgOptimizedImage } from '@angular/common';
import { NgbDropdown, NgbDropdownItem, NgbDropdownMenu, NgbDropdownToggle } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-language',
  standalone: true,
  imports: [
    NgOptimizedImage,
    NgbDropdown,
    NgbDropdownItem,
    NgbDropdownMenu,
    NgbDropdownToggle
  ],
  templateUrl: './language.component.html',
  styleUrl: './language.component.scss'
})
export class LanguageComponent {
  
  currentLanguage = 'eng';
  
  changeLanguage(language: string) {
    this.currentLanguage = language;
  }
}
