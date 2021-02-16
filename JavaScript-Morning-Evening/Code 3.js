var re = new RegExp("abb*c");

const findIndices = (str, char) =>
  str.split("").reduce((indices, letter, index) => {
    letter === char && indices.push(index);
    return indices;
  }, []);

var fun = (string) => {
  if (string.startsWith("lion") && string.endsWith("cat") && string.match(re)) {
    console.log(`${string} true`);
    console.log("Postions of a:", findIndices(string, "a"));
    console.log("Postions of b:", findIndices(string, "b"));
    console.log("Postions of c:", findIndices(string, "c"));
  } else console.log(`${string} false`);
  return "";
};

console.log(fun("lionnodeabbccat"));

console.log(fun("cat"));

console.log(fun("lion"));

console.log(fun("lioncat"));
