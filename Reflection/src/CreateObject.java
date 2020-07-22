import java.lang.reflect.Constructor;

public class CreateObject {

	public CreateObject() {

	}

	public CreateObject(int a, int b) {
		System.out.println("a = " + a + ", b = " + b);
	}

	public static void main(String[] args) {
		try {
			Class cls = Class.forName("CreateObject");
			Class[] paramTypes = new Class[2];
			paramTypes[0] = int.class;
			paramTypes[1] = int.class;
			
			Constructor constructor = cls.getConstructor(paramTypes);	// 특정 파라미터를 가진 생성자 객체 매핑
			Object[] argList = new Object[2];
			argList[0] = 20200000;
			argList[1] = 722;
			Object instObj = constructor.newInstance(argList);			// 이 객체가 표현하는 생성자를 "호출"하여 신규 객체 생성
			// 결과 : a = 20200000, b = 722
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
