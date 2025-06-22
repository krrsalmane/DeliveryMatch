import { Routes } from '@angular/router';
import { Createannonce } from './components/createannonce/createannonce';
import { Registerprofile } from './components/registerprofile/registerprofile';

export const routes: Routes = [
  { path: 'create', component: Createannonce },
  { path: 'register', component: Registerprofile },
  { path: '', redirectTo: '/create', pathMatch: 'full' }, 
  { path: '**', redirectTo: '/create' } 
];