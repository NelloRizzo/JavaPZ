import { Routes } from '@angular/router';
import { Component1Component } from './component1/component1.component';
import { Component2Component } from './component2/component2.component';
import { Component3Component } from './component3/component3.component';

export const routes: Routes = [
    { path: 'comp1', component: Component1Component },
    { path: 'comp2', component: Component2Component },
    { path: 'comp3/:id', component: Component3Component },
    { path: '', redirectTo: '/comp1', pathMatch: 'full' },
];
