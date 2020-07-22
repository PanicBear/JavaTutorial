import java.lang.reflect.Method;

public class ExecuteMethod {

	public int add(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		try {
			Class cls = ExecuteMethod.class;
			int idx = cls.getDeclaredMethods().length;
			Class[] paramTypes = new Class[idx];
			paramTypes[0] = int.class;
			paramTypes[1] = int.class;
			
			Method targetMethod = cls.getDeclaredMethod("add", paramTypes);		// 특정 파라미터를 가진 메서드 객체 매핑 add(int.class, int.class)
			ExecuteMethod excuteMethod = new ExecuteMethod();
			Object[] argInts = new Object[idx];									// Integer 배열도 가능
			argInts[0] = 20200000;
			argInts[1] = 722;
			Object invokedResult = targetMethod.invoke(excuteMethod, argInts);	// invoke(메서드가 속한 클래스 객체, argument 배열)
			Integer invokedResultInt = (Integer)invokedResult;					// 이 부분 생략하고 위에서 바로 Integer로 다운캐스팅 해도 됨
			System.out.println(invokedResultInt.intValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
