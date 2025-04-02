class Person {
    private fullName: string

    public get theFullName(): string { return `${this.name} ${this.surname}` }

    public set theName(name: string) { this.name = name }

    constructor(private name: string, private surname: string) {
        this.fullName = `${name} ${surname}`
    }

    public saluta(): void {
        console.log(`Ciao a tutti, mi chiamo ${this.fullName}`)
    }
}

const p = new Person("Archimede", "Pitagorico")
p.saluta()

p.theName = "ARCHIMEDE"
console.log(p.theFullName)

interface CalculatorState {
    display: string
    accumulator: number
    operation: string
    mustClearDisplay?: boolean
}

const initialState: CalculatorState = {
    display: '0', accumulator: 0, operation: '+'
}

let v: string | number = 0
v = 'Paperino'

function sum<T extends string | number>(a: T, b: T): T {
    if (typeof a === 'string' || typeof b === 'string' || typeof a === 'number' || typeof b === 'number') {
        return (a.toString() + b.toString()) as T;
    }
    throw new Error('Invalid arguments: both arguments must be of the same type (string or number)');
}

console.log(sum(10, 20))

class Pair<F, S> {
    constructor(public first: F, public second: S) { }
}

var p1 = new Pair(20, 'Prova')
var p2 = new Pair(true, new Date())
console.log(typeof p1.first)
// p1.first = "Prova"
console.log(typeof p2.first)