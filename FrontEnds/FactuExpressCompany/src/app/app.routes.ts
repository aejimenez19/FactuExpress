import { Routes } from '@angular/router';
import { LandingPageComponent } from './landing-page/landing-page.component';

import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { ProductTableComponent } from './product-table/product-table.component';

export const routes: Routes = [
  { path: '', component: LandingPageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'product-table', component: ProductTableComponent },
  { path: '**', redirectTo: '' }
];
