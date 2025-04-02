"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.list = void 0;
class Contact {
    constructor(name, surname, phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }
}
exports.default = Contact;
exports.list = [
    new Contact("Paperino", "Paolino", "1213456"),
    new Contact("Archimede", "Pitagorico", "4325531")
];
