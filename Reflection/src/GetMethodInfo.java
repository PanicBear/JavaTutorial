import java.lang.reflect.Method;

public class GetMethodInfo {
	private int function(Object p, int x) throws NullPointerException {
		if (p == null) {
			throw new NullPointerException();
		}
		return x;
	}

	public static void main(String[] args) {
		try {
			Class cls = Class.forName("GetMethodInfo");
			Method methlist[] = cls.getDeclaredMethods();		// getMethods의 경우 상속된 메서드 반환
			for (int i = 0; i < methlist.length; i++) {
				Method method = methlist[i];
				System.out.println("name  = " + method.getName());
				System.out.println("decl class = " + method.getDeclaringClass());

				Class clsParams[] = method.getParameterTypes();
				for (int j = 0; j < clsParams.length; j++) {
					System.out.println(" param #" + j + " " + clsParams[j]);
				}

				Class clsExcept[] = method.getExceptionTypes();
				for (int j = 0; j < clsExcept.length; j++) {
					System.out.println("exc #" + j + " " + clsExcept[j]);
				}

				System.out.println("return type = " + method.getReturnType());
				System.out.println("-----");
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
