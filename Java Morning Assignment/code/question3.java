package assignment;
import java.io.*;
import java.util.*;

public class question3{ 
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.println("Enterstring: ");
		String oriString=inp.nextLine();
		System.out.println("Enter to be replaced word: ");
		String regEx=inp.nextLine();
		System.out.println("Enter the regex to be replaced with: ");
		String replacedWord=inp.nextLine();
		String replacedString=oriString.replaceAll(regEx, replacedWord);
		System.out.println("Original String: "+oriString);
		System.out.println("New String: "+replacedString);
		}

	 
}