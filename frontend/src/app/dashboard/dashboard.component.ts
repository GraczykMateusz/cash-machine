import { Component } from '@angular/core';
import { WelcomeBarComponent } from './ui/welcome-bar/welcome-bar.component';
import { NavBarComponent } from './ui/nav-bar/nav-bar.component';
import { LanguageComponent } from '../language/language.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    WelcomeBarComponent,
    NavBarComponent,
    LanguageComponent
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

}
