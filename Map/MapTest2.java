/*
 * Map����ӳ��һ�Զ��ϵ��
 * ����������԰�ѧ�ź�������װ�ɶ�������MapTest
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
		
		System.out.println();//�û��и���
		System.out.println();
		
		//����czbk���ϣ���ȡ���еĽ����Լ�
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
