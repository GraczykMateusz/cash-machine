import { ApplicationConfig, LOCALE_ID } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './routing/app.routes';
import { provideHttpClient } from '@angular/common/http';

import '@angular/common/locales/global/pl';
import { provideCharts, withDefaultRegisterables } from 'ng2-charts';
import { provideAnimations } from '@angular/platform-browser/animations';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideCharts(withDefaultRegisterables()),
    provideAnimations(),
    provideHttpClient(),
    {
      provide: LOCALE_ID,
      useValue: 'pl-PL'
    }]
};
