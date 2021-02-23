package assignment;
import java.util.*;
import java.util.Map.Entry;
class ExceptPrimeNumber extends Exception{
}
public class question5 {
public static boolean checkPrimeNumber(int n) {
if(n<=1)
return false;
if(n<=3)
return true;
if(n%2==0||n%3==0)
return false;
for(int i=5;i*i<=n;i=i+6)
if(n%i==0 || n%(i+2)==0)
return false;
return true;
}
public static void main(String[] args) {
int count=1;
while(count<=100) {
try {
if(checkPrimeNumber(count))
throw new ExceptPrimeNumber();
}
catch(ExceptPrimeNumber e) {
System.out.println(count+" is Prime.");
}
finally {
count++;
}
}
}
}