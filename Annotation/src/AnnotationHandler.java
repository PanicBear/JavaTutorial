import java.lang.reflect.Field;
import java.util.Optional;

public class AnnotationHandler {

	private <T> T checkAnnotation4Insert(T targetObj, Field[] fields, Class annotationObj) {
		Field field;
		if (annotationObj.getName() == "InsertIntData" || annotationObj.getName().equals("InsertIntData")) {
			for (int i = 0; i < fields.length; i++) {
				field = fields[i];
				InsertIntData annotation = (InsertIntData) field.getAnnotation(annotationObj);
				if (annotation != null && field.getType() == int.class) {
					field.setAccessible(true);
					try {
						field.set(targetObj, annotation.data());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		} else if (annotationObj.getName() == "InsertStringData"
				|| annotationObj.getName().equals("InsertStringData")) {
			for (int i = 0; i < fields.length; i++) {
				field = fields[i];
				InsertStringData annotation = field.getAnnotation(InsertStringData.class);
				if (annotation != null && field.getType() == String.class) {
					field.setAccessible(true);
					try {
						field.set(targetObj, annotation.data());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
		return targetObj;
	}

	public <T> Optional<T> getInstance(Class targetClass, Class annotationClass) {
		Optional optional = Optional.empty();
		Object object;
		Field[] fields;
		try {
			object = targetClass.getDeclaredConstructor().newInstance();
			fields = object.getClass().getDeclaredFields();
			object = checkAnnotation4Insert(object, fields, annotationClass);
			optional = Optional.of(object);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return optional;
	}
}
