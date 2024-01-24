import { Routes } from '@angular/router';

import { HomeComponent } from './pages/home/home.component';
import { ReportsComponent } from './pages/reports/reports.component';
import { CrudComponent } from './pages/crud/crud.component';
export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'report',
        component: ReportsComponent
    },
    {
        path: 'crud',
        component: CrudComponent
    }
];
