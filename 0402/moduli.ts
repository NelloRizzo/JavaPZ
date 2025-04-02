export default class Contact {
    constructor(private name: string, private surname: string, private phone: string) { }
}

export const list: Contact[] = [
    new Contact("Paperino", "Paolino","1213456"),
    new Contact("Archimede", "Pitagorico", "4325531")
]