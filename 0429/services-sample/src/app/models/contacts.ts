export interface Contact {
    id: number;
    firstName: string;
    lastName: string;
    deliveries: Delivery[];
}

export interface Phone {
    id: number;
    phoneNumber: string;
}
export interface Email {
    id: number;
    emailAddress: string;
}
export type Delivery = Phone | Email

