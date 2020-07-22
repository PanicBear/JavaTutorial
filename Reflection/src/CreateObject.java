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
			
			Constructor constructor = cls.getConstructor(paramTypes);	// Ư�� �Ķ���͸� ���� ������ ��ü ����
			Object[] argList = new Object[2];
			argList[0] = 20200000;
			argList[1] = 722;
			Object instObj = constructor.newInstance(argList);			// �� ��ü�� ǥ���ϴ� �����ڸ� "ȣ��"�Ͽ� �ű� ��ü ����
			// ��� : a = 20200000, b = 722
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
