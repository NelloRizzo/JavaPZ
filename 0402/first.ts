console.log("Hello, World!")

const text: string = "Hello, World!"

console.log(text.toLowerCase())
console.log(text.toUpperCase())
console.log(text.slice(-5, -2))

enum ResponseEnum { SI = "si", NO = "no" }

let x: ResponseEnum = Math.random() > 1 ? ResponseEnum.SI : ResponseEnum.NO

if (x === ResponseEnum.NO)
    console.log("Ok")