import { createFeatureSelector, createSelector } from "@ngrx/store";
import { ApplicationState } from "./application-state";

const contactsFeature = createFeatureSelector<ApplicationState>('contacts')

export const contactsSelector = createSelector(contactsFeature,
    (s: ApplicationState) => s.contacts)
