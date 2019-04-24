# Java CheatSheet


## Java Math

```java
Math.abs(-2.3) // ans: 2.3 
Math.floor(2.3) // ans: 2.0
Math.ceil(2.3) // ans: 3.0
Math.pow(10,2) // ans: 100
Math.log10(100) // ans: 2
Math.log(8)/Math.log(2) // ans: 3
Math.floorMod(302,10) // ans: 2
```

## Java Conversions/Castings

```java
int x = (int)312.3; // double to int
double d = (double) 10; // int to double

Double d = 10.2; Integer i = d.intValue(); // Double to Integer
Integer i = 10; Double d = i.doubleValue(); // Integer to Double

String s = Integer.toString(100); // Integer to string
String s = Double.toString(100.1); // Double to string

Integer.parseInt("101"); // String to Integer
Double.parseDouble("101.1"); // String to Double
```

## Java BigInteger

```java
BigInteger a = new BigInteger("99999999");
BigInteger b = new BigInteger("9999999999");
a.add(b);
a.subtract(b);
a.multiply(b);
a.divide(b);
a.max(b); // ans: returns max value
a.min(b); // ans: returns min value
a.compareTo(b); // -1 if not equal, 0 if equal
a.mod(b);
a.pow(10); // if a=2 then ans: 1024
Math.log10(a.intValue()); 
a.intValue(); // conversion from BigInteger to Integer
a.doubleValue(); // convertion from BigInteger to Double
```