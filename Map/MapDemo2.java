/*
 * Map����ȡ��ԭ��ͨ��ת����Set���ϣ���ͨ��������ȡ����
 * map���ϵĵ�һ��ȡ����ʽ��
 * 1��keySet����map�����еļ����뵽Set���ϡ���ΪSet�߱���������
 * ���Կ��Ե�����ʽȡ�����еļ����ٸ���get��������ȡÿ������Ӧ��ֵ��
 * ���õ���������Map�����м�ֵ�ԡ�
 */
import java.util.*;
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("01","huang");
		map.put("02", "zhang");
		map.put("03", "li");
		Set<String> set = map.keySet();//��ȡ���ļ���
		Iterator<String> it = set.iterator();//�������ļ���
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);//��ȡÿ������Ӧ��ֵ
			System.out.println(key+":"+value);
		}
		Collection<String> coll = map.values(); 
		System.out.println(coll);//ֻ��ӡset���ϵ�ֵ
	}
}
