import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-hamburger',
  standalone: true,
  imports: [],
  templateUrl: './hamburger.component.html',
  styleUrl: './hamburger.component.scss'
})
export class HamburgerComponent {
  
  @Input({required: true})
  checked!: boolean;
  
  @Output()
  onHamburgerChange = new EventEmitter<string>();
  
  sendEvent(): void {
    this.onHamburgerChange.emit();
  }
}
