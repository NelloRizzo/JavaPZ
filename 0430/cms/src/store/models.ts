export interface Contact {
    id: number;
    firstName: string;
    lastName: string;
    nickName?: string;
    addresses: Delivery[];
}

export interface Email {
    id: number;
    email: string;
}

export interface Phone {
    id: number;
    phoneNumber: string;
}

export type Delivery =
    Phone | Email;