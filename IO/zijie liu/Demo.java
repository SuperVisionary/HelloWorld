import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * 装饰设计模式。
 */
public class Demo {
	public static void main(String[] args) {
		Car benz = new Car("Benz");
		System.out.println("----包装前----");
		benz.show();
		RadarCar baoma = new RadarCar(benz);
		System.out.println("----包装后----");
		baoma.show();
	}
}
class Car{
	private String carName;
	public Car(String carName) {
		this.carName = carName;
	}
	public void show() {
		System.out.println("我是："+carName+"具备基本功能");
	}
}
//定义一个RadarCar类对Car类包装
class RadarCar{
	public Car myCar;
	public RadarCar(Car myCar) {
		this.myCar = myCar;
	}
	public void show() {
		myCar.show();
		System.out.println("具备倒车雷达功能");
	}
}

