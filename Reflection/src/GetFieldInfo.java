import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GetFieldInfo {

	private double mDouble;
	public static final int mInt = 722;
	String mString = "testing";

	public static void main(String[] args) {
		try {
			Class cls = GetFieldInfo.class;
			Field[] fields = cls.getDeclaredFields(); // getFields의 경우 public만
			for (Field field : fields) {
				System.out.println("name = " + field.getName());
				System.out.println("decl class = " + field.getDeclaringClass());
				System.out.println("type = " + field.getType());
				int mod = field.getModifiers();
				System.out.println("modifiers = " + Modifier.toString(mod));
				System.out.println("-----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
