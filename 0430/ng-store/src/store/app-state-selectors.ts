import { createFeatureSelector, createSelector } from "@ngrx/store";
import { ApplicationState } from "./app-state";

export const selectCounterFeature = createFeatureSelector<ApplicationState>('counter');

export const selectCounter = createSelector(
    selectCounterFeature,
    (state) => state.counterValue
  );