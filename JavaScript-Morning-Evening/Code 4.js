var fun = (array) => {
  console.log(`Inital  Array: `, array);
  console.log(`Sorted  Array: `, array.sort());
  console.log(
    `X by 10 Array: `,
    array.map((data) => data * 10)
  );
  console.log(
    `Divisble by 3 Array: `,
    array.filter((data) => !(data % 3))
  );
  return "";
};

console.log(fun([9, 8, 7, 6, 5, 4, 3, 2, 1]));
