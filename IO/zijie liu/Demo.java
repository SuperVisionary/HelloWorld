import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * װ�����ģʽ��
 */
public class Demo {
	public static void main(String[] args) {
		Car benz = new Car("Benz");
		System.out.println("----��װǰ----");
		benz.show();
		RadarCar baoma = new RadarCar(benz);
		System.out.println("----��װ��----");
		baoma.show();
	}
}
class Car{
	private String carName;
	public Car(String carName) {
		this.carName = carName;
	}
	public void show() {
		System.out.println("���ǣ�"+carName+"�߱���������");
	}
}
//����һ��RadarCar���Car���װ
class RadarCar{
	public Car myCar;
	public RadarCar(Car myCar) {
		this.myCar = myCar;
	}
	public void show() {
		myCar.show();
		System.out.println("�߱������״﹦��");
	}
}

