import { createReducer, on } from "@ngrx/store";
import { initialState } from "./application-state";
import { addContact, deleteContact, updateContact } from "./state-actions";

export const contactsReducer = createReducer(
    initialState,
    on(addContact, (s, { contact }) => {
        // cerca l'id più grande
        const newId = Math.max(...s.contacts.map(c => c.id))
        return ({
            ...s, // tutto lo stato precedente
            contacts: // modifica i contatti
                [...s.contacts, // prendendo tutti i contatti precedenti 
                {
                    ...contact, // aggiunge i dati del nuovo contatto 
                    id: newId + 1 // e ne imposta l'id 
                }]
        })
    }),
    on(deleteContact, (s, { id }) =>
        // elimina tutti i contatti con l'id passato
        ({ ...s, contacts: s.contacts.filter(c => c.id !== id) })),
    on(updateContact, (s, { id, contact }) =>
    ({
        ...s, contacts: s.contacts.map(c => { // prende i contatti precedenti 
            if (c.id === id) // se trova l'id
                return { ...c, ...contact, id: id } // rimpiazza i dati
            else
                return c // altrimenti non fa nulla
        })
    }))
)