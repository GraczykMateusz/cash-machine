import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';

enum Error {
  VERIFY_EMAIL,
  INVALID_EMAIL_OR_PASSWORD,
  SOMETHING_WENT_WRONG,
  TOO_MANY_REQUESTS,
}

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  
  loginGroup = new FormGroup({
    login: new FormControl<string | null>(null, [Validators.required, Validators.email]),
    password: new FormControl<string | null>(null, [Validators.required, Validators.minLength(6)])
  });
  
  protected readonly Error = Error;
  protected error: Error | null = null;
  
  ngOnInit(): void {
    this.loginGroup.valueChanges
      .pipe(takeUntilDestroyed())
      .subscribe(() => this.resetError());
  }
  
  signIn(): void {
    if (this.loginGroup.invalid) {
      this.error = Error.INVALID_EMAIL_OR_PASSWORD;
      return;
    }
    const login = this.loginGroup.value.login!;
    const password = this.loginGroup.value.password!;
  }
  
  resetError(): void {
    this.error = null;
  }
}
