import { Contact } from "./models";

export interface ApplicationState {
    contacts: Contact[];
}

export const initialState: ApplicationState = {
    contacts: [
        {
            id: 1,
            firstName: 'Archimede',
            lastName: 'Pitagorico',
            addresses: []
        }
    ]
}