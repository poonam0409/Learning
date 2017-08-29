package com.poonam;

import java.util.HashMap;

class ImmutableCheck {

	public ImmutableCheck(int i, String str, HashMap map) {
		super();
		this.i = i;
		this.str = str;
		this.map = (HashMap<String, String>) map.clone();
	}

	private final int i;
	private final String str;
	private final HashMap<String, String> map;

	public final int getI() {
		return i;
	}

	public final String getStr() {
		return str;
	}

	public final HashMap<String, String> getMap() {
		return (HashMap<String, String>) map.clone();
	}
}

class ImmutableCheckSub extends ImmutableCheck {

	public ImmutableCheckSub(int i, String str, HashMap map) {
		super(i, str, map);

	}

}

public class Immutable {
	public static void main(String... args)

	{
		HashMap<String, String> map = new HashMap<>();
		map.put("Poonam", "Hello");
		map.put("Amrita", "World");
		ImmutableCheck im = new ImmutableCheck(5, "Poonam", map);
		im.getI();
		im.getMap().put("New Name", "Welcome");
		im.getMap().clear();
map.put("Vijay", "Rahne do");
		System.out.println(im.getMap());
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("see", "changed ");
		map2.put("there i have ", "changed");
		ImmutableCheckSub ics = new ImmutableCheckSub(8, "see i have changed ", map2);
		ics.getMap().put("add", "this");
		System.out.println(ics.getMap());
		System.out.println("Äfter subclass" + im.getMap());

	}

}
