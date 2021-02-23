package assignment;
import java.io.*;
import java.util.*;  

public class question4 {
	public static void main(String args[]) {
		TreeMap <String,String> tree_map = new TreeMap <String,String> ();
		tree_map.put("RED", "#FF0000");
		tree_map.put("BLUE", "#0000FF");
		tree_map.put("GREEN", "#008000");
		tree_map.put("YELLOW", "#FFFF00");
		System.out.println("Orginal TreeMap content: " + tree_map);
		System.out.println("Reverse order view of the keys: " +
		tree_map.descendingKeySet());
		}
}
