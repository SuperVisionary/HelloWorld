/*
 * 程序运行时，会在内存中创建多个对象，然而程序结束后，这些对象便被当作垃圾回收了。
 * 如果希望永久保存这些对象，则可以将对象转为字节数据写入到硬盘上，这个过程称为对象序列化。
 * JDK提供了ObjectOutputStream(对象输出流)来实现对象的序列化。
 * 当对象进行序列化时，必须保证该对象实现了Serializable接口，否则程序会出现NotSerializableException异常。
 */
public class ObjectOutputStreamDemo {
	public static void main(String[] args) {
		
	}
}
