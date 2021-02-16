// Question 2 - Display usage of All Array Methods
var array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
// 1. concat()
array = array.concat(11);
console.log("1: " + array);

// 2. every()
const lessthan15 = (arrvalue) => arrvalue < 15;
console.log("2: " + array.every(lessthan15));

// 3. filter()
array = array.filter(lessthan15);
console.log("3: " + array);

// 4. forEach()
array.forEach((data) => console.log("4: " + data));

// 5. IndexOf()
console.log("5: " + array.indexOf(45));
console.log("5: " + array.indexOf(5));
console.log("5: " + array.indexOf(11));

// 6. join()
console.log("6: " + array.join());

// 7. lastIndexOf()
console.log("7: " + array.lastIndexOf(4));

// 8. map()
array.map((x) => x + 2);

// 9. pop()
console.log("9: " + array.pop());

// 10. push()
console.log("10: " + array.push(12));

// 11. reverse()
console.log("11: " + array.reverse());

// 12. shift()
console.log("12: " + array.shift());

// 13. slice()
console.log("13: " + array.slice(2, 6));

// 14. sort()
console.log("14: " + array.sort());

// 15. splice()
console.log("15: " + array.splice(3, 5));

// 16. toString()
console.log("16: " + array.toString());

// 17 unShift()
console.log("17: " + array.unshift());
