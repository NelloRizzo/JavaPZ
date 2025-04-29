export interface Contact {
    firstName: string;
    lastName: string;
    addresses: Address[]
}
export interface Email {
    email: string;
}
export interface Phone {
    phone: string;
}
export type Address = Email | Phone;

export const initialContacts: Contact[] = [
    {
        firstName: 'John',
        lastName: 'Doe',
        addresses: [
            { email: 'j.doe@email.com' },
            { phone: '123-456-7890' },
            { email: 'john.doe@me.com' },
        ]
    },
    {
        firstName: 'Ellen',
        lastName: 'Sue',
        addresses: [
            { email: 'e.sue@email.com' },
            { phone: '123-654-7890' },
            { email: 'ellen.sue@me.com' },
        ]
    },]