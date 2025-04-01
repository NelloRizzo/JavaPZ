console.log("Ciao", "a", "tutti")

var n = 1
console.log(n)
n = "Prova"
console.log(n)

n = [1, 2, 3, 4, 5]
console.log(n)

Array.from(n).filter(n => n % 2 == 0).forEach(x => console.log(x))


function sampleFunction(n) {
    const f = function (x) { return x + 1 }

    function inner(x) {
        return x * 2
    }

    return f(n) + inner(n);
}
console.log(sampleFunction(2))

const myObj = {
    nome: "Nello", cognome: "Rizzo"
}

console.log(myObj)

function person(name, surname) {
    const print = () => console.log(name, surname)

    return {
        name: name, surname: surname, print: print
    }
}

const p = person("Nello", "Rizzo")
p.print()