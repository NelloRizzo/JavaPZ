"use strict";
console.log("Hello, World!");
const text = "Hello, World!";
console.log(text.toLowerCase());
console.log(text.toUpperCase());
console.log(text.slice(-5, -2));
var ResponseEnum;
(function (ResponseEnum) {
    ResponseEnum["SI"] = "si";
    ResponseEnum["NO"] = "no";
})(ResponseEnum || (ResponseEnum = {}));
let x = Math.random() > 1 ? ResponseEnum.SI : ResponseEnum.NO;
if (x === ResponseEnum.NO)
    console.log("Ok");
