import java.lang.reflect.Constructor;

public class GetConstructorInfo {

	public GetConstructorInfo() {
	}

	protected GetConstructorInfo(int i, double d) {
	}

	public static void main(String[] args) {
		try {
			Class cls = Class.forName("GetConstructorInfo");

			Constructor[] constructors = cls.getDeclaredConstructors();
			for (int i = 0; i < constructors.length; i++) {
				Constructor ct = constructors[i];
				System.out.println("name = " + ct.getName());

				System.out.println("decl class = " + ct.getDeclaringClass());
				Class clsParams[] = ct.getParameterTypes();

				for (int j = 0; j < clsParams.length; j++) {
					System.out.println("param #" + j + " " + clsParams[j]);
				}
				Class clsExcep[] = ct.getExceptionTypes();

				for (int j = 0; j < clsExcep.length; j++) {
					System.out.println("exc #" + j + " " + clsExcep[j]);
				}
				System.out.println("-----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
