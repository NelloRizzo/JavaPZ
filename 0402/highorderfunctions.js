function highOrder(n, f) {
    return f(n)
}

const double = function (n) { return n * 2 }
const square = function (n) { return n * n }
const inverse = (n) => { return 1 / n }
console.log(highOrder(3, double))
console.log(highOrder(3, square))
console.log(highOrder(3, inverse))
console.log(highOrder(3, (a) => 1 / a))

let operand = 10
console.log(highOrder(3, (a) => a * operand))