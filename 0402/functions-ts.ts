function add(x: number, y: number, z?: number): number {
    return x + y + (z ?? 0)
}
function mul(x: number, y: number, z?: number): number {
    return x * y * (z ?? 1)
}
function mul2(x: number, y: number, z: number = 3): number {
    return x * y * z
}

console.log(add(1, 2))
console.log(add(1, 2, 3))
console.log(mul(2, 2, 3))
console.log(mul(2, 2))
console.log(mul2(2, 2))

type BynaryFunc = (a: number, b: number) => number

function useFunc(x: number, y: number, func: BynaryFunc): number {
    return func(x, y)
}

console.log(useFunc(1, 2, (x: number, y: number) => x + y))
console.log(useFunc(1, 2, (x: number, y: number) => x * y))
console.log(useFunc(1, 2, (x: number, y: number) => x / y))