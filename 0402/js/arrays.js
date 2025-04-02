"use strict";
{
    const numbers = [123, 543, 345, 347, 154, 34];
    numbers.push(132, 654, 4756, 84);
    console.log(numbers.pop());
    console.log(numbers.pop());
    console.log(numbers.pop());
    console.log(numbers.pop());
    console.log(numbers[0], numbers[2]);
    numbers.unshift(12, 324, 2536, 2413);
    console.log(numbers.shift());
    console.log(numbers.shift());
    console.log(numbers.shift());
    console.log(numbers.shift());
    const [first, second, ...others] = numbers;
    console.log("First", first, "Second", second, "Others", others);
    let x = 1;
    let y = 2;
    [x, y] = [y, x];
    console.log(x, y);
}
