import { ApplicationConfig, LOCALE_ID } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './routing/app.routes';
import { provideHttpClient } from '@angular/common/http';

import '@angular/common/locales/global/pl';
import { provideCharts, withDefaultRegisterables } from 'ng2-charts';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideCharts(withDefaultRegisterables()),
    provideHttpClient(),
    {
      provide: LOCALE_ID,
      useValue: 'pl-PL'
    }]
};
