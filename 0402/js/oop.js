"use strict";
class Person {
    get theFullName() { return `${this.name} ${this.surname}`; }
    set theName(name) { this.name = name; }
    constructor(name, surname) {
        this.name = name;
        this.surname = surname;
        this.fullName = `${name} ${surname}`;
    }
    saluta() {
        console.log(`Ciao a tutti, mi chiamo ${this.fullName}`);
    }
}
const p = new Person("Archimede", "Pitagorico");
p.saluta();
p.theName = "ARCHIMEDE";
console.log(p.theFullName);
const initialState = {
    display: '0', accumulator: 0, operation: '+'
};
let v = 0;
v = 'Paperino';
function sum(a, b) {
    if (typeof a === 'string' || typeof b === 'string' || typeof a === 'number' || typeof b === 'number') {
        return (a.toString() + b.toString());
    }
    throw new Error('Invalid arguments: both arguments must be of the same type (string or number)');
}
console.log(sum(10, 20));
class Pair {
    constructor(first, second) {
        this.first = first;
        this.second = second;
    }
}
var p1 = new Pair(20, 'Prova');
var p2 = new Pair(true, new Date());
console.log(typeof p1.first);
// p1.first = "Prova"
console.log(typeof p2.first);
