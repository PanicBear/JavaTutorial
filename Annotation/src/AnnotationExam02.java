public class AnnotationExam02 {

	@InsertStringData(data = "ClarXo")
	private String myData;
	
	@InsertStringData
	private String defaultData;
	
	public AnnotationExam02() {
		this.myData = "No data";
		this.defaultData = "No data";
	}
	
	public String getMyData() {
		return myData;
	}
	
	public String getDefaultData() {
		return defaultData;
	}
}
