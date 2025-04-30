import { createAction, props } from '@ngrx/store'
import { Contact } from './models'

export const addContact =
    createAction('[Contacts] Create', props<{ contact: Contact }>())
export const deleteContact =
    createAction('[Contacts] Delete', props<{ id: number }>())
export const updateContact =
    createAction('[Contacts] Update', props<{ id: number, contact: Contact }>())