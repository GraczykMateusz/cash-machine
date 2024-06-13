import { Routes } from '@angular/router';
import { Pages } from './pages';

export const routes: Routes = [
  {
    path: Pages.WELCOME_PAGE,
    loadComponent: () => import('../login/login.component').then(value => value.LoginComponent)
  },
  {
    path: Pages.DASHBOARD,
    loadComponent: () => import('../dashboard/dashboard.component').then(value => value.DashboardComponent)
  },
  {
    path: '',
    redirectTo: Pages.WELCOME_PAGE, pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: Pages.WELCOME_PAGE, pathMatch: 'full'
  }
];
