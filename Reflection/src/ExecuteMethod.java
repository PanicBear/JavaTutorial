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
			
			Method targetMethod = cls.getDeclaredMethod("add", paramTypes);		// Ư�� �Ķ���͸� ���� �޼��� ��ü ���� add(int.class, int.class)
			ExecuteMethod excuteMethod = new ExecuteMethod();
			Object[] argInts = new Object[idx];									// Integer �迭�� ����
			argInts[0] = 20200000;
			argInts[1] = 722;
			Object invokedResult = targetMethod.invoke(excuteMethod, argInts);	// invoke(�޼��尡 ���� Ŭ���� ��ü, argument �迭)
			Integer invokedResultInt = (Integer)invokedResult;					// �� �κ� �����ϰ� ������ �ٷ� Integer�� �ٿ�ĳ���� �ص� ��
			System.out.println(invokedResultInt.intValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
