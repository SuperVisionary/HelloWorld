import java.util.*;
public class MapDemo {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("01","huang");
		map.put("02", "zhang");
		
		System.out.println(map.get("01"));
		System.out.println(map.get("02"));
	}
}
