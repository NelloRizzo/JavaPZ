import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideStore } from '@ngrx/store';

import counterReducer from '../store/app-state-reducer';

export const appConfig: ApplicationConfig = {
  providers: [
    provideStore({ counter: counterReducer }),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes)]
};
