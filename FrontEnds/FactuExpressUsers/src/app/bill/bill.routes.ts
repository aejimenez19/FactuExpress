import { Routes } from '@angular/router';
import { MainComponent } from './main/main.component';
import { ProfileComponent } from './profile/profile.component';
import { BillsComponent } from './bills/bills.component';
import { AftermainComponent } from './aftermain/aftermain.component';

export const BILLS_ROUTES: Routes = [
    { path: '', component: AftermainComponent},
    { path: 'main', component: MainComponent},
    { path: 'profile', component: ProfileComponent},
    { path: 'bills', component: BillsComponent}
];