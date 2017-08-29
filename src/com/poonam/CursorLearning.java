package com.poonam;

import java.util.ArrayList;
import java.util.ListIterator;

public class CursorLearning {

	public static void main(String ...args)
	{
		ArrayList<String> al = new ArrayList<>();
		al.add("hello");
		al.add("Welcome");
		
		ListIterator<String> ltr = al.listIterator();
		while(ltr.hasNext())
			{ //System.out.println(ltr.next());
			String str =(String)ltr.next();
			System.out.println(str);
			if(str.equals("Welcome"))
			ltr.add("Hi");
			 if(str.equals("hello")){ltr.set("World");}
         		 
			}
		System.out.println(al);
		
	}
	
}
