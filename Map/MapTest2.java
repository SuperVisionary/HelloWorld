/*
 * Map集合映射一对多关系。
 * 这个案例可以把学号和姓名封装成对象，类似MapTest
 */
import java.util.*;
public class MapTest2 {
	public static void main(String[] args) {
		HashMap<String,HashMap<String,String>> czbk = new HashMap<String,HashMap<String,String>>();
		
		HashMap<String,String> yure = new HashMap<String,String>();
		
		HashMap<String,String> jiuye = new HashMap<String,String>();
		
		czbk.put("yureban",yure);
		czbk.put("jiuyeban", jiuye);
		
		yure.put("01","zhangsan");
		yure.put("02","lisi");
		
		jiuye.put("01","wangwu");
		jiuye.put("02","zhaoliu");
		
		getStudentInfo(yure);
		getStudentInfo(jiuye);
		
		System.out.println();//用换行隔开
		System.out.println();
		
		//遍历czbk集合，获取所有的教室以及
		Set<String> set = czbk.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String roomName = it.next();
			HashMap<String,String> room = czbk.get(roomName);
			
			System.out.println(roomName);
			getStudentInfo(room);
		}
	}
	public static void getStudentInfo(HashMap<String,String> roomMap) {
		Iterator<String> it = roomMap.keySet().iterator();
		while(it.hasNext()) {
			String id = it.next();
			String name = roomMap.get(id);
			System.out.println(id+":"+name);
		}
	}
}
