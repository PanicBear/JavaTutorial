
public class Main {

	public static void main(String[] args) {

		AnnotationHandler handler = new AnnotationHandler();
		AnnotationExam01 exam01 = handler.getInstance(AnnotationExam01.class, InsertIntData.class)
				.map(o -> (AnnotationExam01) o).orElse(new AnnotationExam01());

		AnnotationExam02 exam02 = handler.getInstance(AnnotationExam02.class, InsertStringData.class)
				.map(o -> (AnnotationExam02) o).orElse(new AnnotationExam02());

		System.out.println("exam01.getmyAge() = " + exam01.getMyAge());
		System.out.println("exam01.defaultAge() = "+exam01.getDefaultAge());
		System.out.println("exam02.getMyData() = " + exam02.getMyData());
		System.out.println("exam02.getDefaultData() = "+exam02.getDefaultData());
	}
}
