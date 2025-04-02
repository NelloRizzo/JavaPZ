"use strict";
function add(x, y, z) {
    return x + y + (z !== null && z !== void 0 ? z : 0);
}
function mul(x, y, z) {
    return x * y * (z !== null && z !== void 0 ? z : 1);
}
function mul2(x, y, z = 3) {
    return x * y * z;
}
console.log(add(1, 2));
console.log(add(1, 2, 3));
console.log(mul(2, 2, 3));
console.log(mul(2, 2));
console.log(mul2(2, 2));
function useFunc(x, y, func) {
    return func(x, y);
}
console.log(useFunc(1, 2, (x, y) => x + y));
console.log(useFunc(1, 2, (x, y) => x * y));
console.log(useFunc(1, 2, (x, y) => x / y));
