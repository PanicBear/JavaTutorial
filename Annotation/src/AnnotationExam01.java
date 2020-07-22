import java.util.HashMap;

public class AnnotationExam01 {

	@InsertIntData(data = 26)
	private int myAge;

	@InsertIntData
	private int defaultAge;
	
	private HashMap<String, Integer> map = new HashMap<String, Integer>();

	public AnnotationExam01() {
		this.myAge = -1;
		this.defaultAge = -1;
	}
	
	public HashMap<String, Integer> getAge(String str){
		return map;
	}


	
	public int getMyAge() {
		return myAge;
	}

	public int getDefaultAge() {
		return defaultAge;
	}
}
