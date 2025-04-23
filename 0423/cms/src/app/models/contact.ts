export interface Contact {
    firstName: string;
    lastName: string;
    email: string;
    phone: string;
    id?: number;
}
export const emptyContact: Contact = {
    firstName: '',
    lastName: '',
    email: '',
    phone: ''
}
export const contactsList: Contact[] =
    [
        {
            id: 1,
            firstName: 'John',
            lastName: 'Doe',
            email: 'john.doe@email.com',
            phone: '123-456-7890'
        },
        {
            id: 2,
            firstName: 'Jane',
            lastName: 'Smith',
            email: 'jane.smith@email.com',
            phone: '098-765-4321'
        }
    ]