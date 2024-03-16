import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { take } from 'rxjs';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'cash-machine';
  
  private readonly http = inject(HttpClient);
  
  r: any;
  
  test() {
    this.http.get("/api/test").pipe(take(1)).subscribe(r => this.r = r)
  }
}
