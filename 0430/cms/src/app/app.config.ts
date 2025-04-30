import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideStore } from '@ngrx/store';
import { contactsReducer } from '../store/store-reducer';

export const appConfig: ApplicationConfig = {
  providers: [
    provideStore({ contacts: contactsReducer }),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes)]
};
