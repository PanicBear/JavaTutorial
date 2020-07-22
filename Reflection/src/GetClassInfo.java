import java.lang.reflect.Method;

public class GetClassInfo {

	public static void main(String[] args) {

		try {
			Class c1 = Class.forName("java.lang.String");
			Method[] methods =  c1.getDeclaredMethods();
			System.out.println("Class c1");
			System.out.println(c1);									// Ŭ���� ���� : class java.lang.String
			System.out.println(methods.length);						// �޼��� ���� : 101
			System.out.println(c1.isInstance(new String()));		// �޼��� ���� : true
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Class c2 = int.class;
			Method[] methods =  c2.getDeclaredMethods();
			System.out.println("Class c2");
			System.out.println(c2);									// Ŭ���� ���� : int
			System.out.println(methods.length);						// �޼��� ���� : 0
			System.out.println(c2.isInstance(new Integer(722)));	// �޼��� ���� : false
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Class c3 = Integer.class;
			Method[] methods =  c3.getDeclaredMethods();
			System.out.println("Class c3");
			System.out.println(c3);									// Ŭ���� ���� : class java.lang.Integer
			System.out.println(methods.length);						// �޼��� ���� : 60
			System.out.println(c3.isInstance(new Integer(722)));	// �޼��� ���� : true
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// use TYPE with Wrapper class
		try {
			Class c4 = Integer.TYPE;
			Method[] methods =  c4.getDeclaredMethods();
			System.out.println("Class c4");
			System.out.println(c4);									// Ŭ���� ���� : int
			System.out.println(methods.length);						// �޼��� ���� : 0
			System.out.println(c4.isInstance(new Integer(722)));	// �޼��� ���� : false
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
