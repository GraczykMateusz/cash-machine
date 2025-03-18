import { Component } from '@angular/core';

@Component({
  selector: 'app-welcome-bar',
  imports: [],
  templateUrl: './welcome-bar.component.html',
  styleUrl: './welcome-bar.component.scss'
})
export class WelcomeBarComponent {

  username: string = 'Mateusz';
}
