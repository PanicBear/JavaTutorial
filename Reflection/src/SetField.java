import java.lang.reflect.Field;

public class SetField {
	
	public double d;

	public static void main(String[] args) {
		
		try {
			Class cls = SetField.class;
			Field field = cls.getField("d");		// Ư�� �ʵ� ����
			SetField setField = new SetField();
			
			field.setDouble(setField, 0.3);
			System.out.println(setField.d);
		} catch (Exception e) {
		}
	}

}
