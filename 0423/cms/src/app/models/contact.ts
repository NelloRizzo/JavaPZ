export interface Contact {
    firstName: string;
    lastName: string;
    email: string;
    phone: string;
}

export const contactsList: Contact[] =
    [
        {
            firstName: 'John',
            lastName: 'Doe',
            email: 'john.doe@email.com',
            phone: '123-456-7890'
        },
        {
            firstName: 'Jane',
            lastName: 'Smith',
            email: 'jane.smith@email.com',
            phone: '098-765-4321'
        }
    ]