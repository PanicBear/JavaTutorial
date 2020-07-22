import java.lang.reflect.Array;

public class SetArray {

	public static void main(String[] args) {

//		try {
//			Class cls1 = String.class;
//			Object arr1 = Array.newInstance(cls1, 10); // 문자열 클래스 객체, 배열 길이((Object)[] arr1 = new String[10])
//			Array.set(arr1, 5, "test");
//			String s1 = (String) Array.get(arr1, 5);
//			System.out.println(s1);
//
//			String[] arr = (String[]) arr1; // String으로 다운캐스팅
//			System.out.println(arr[5]);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		int[] dim = new int[] { 5, 10, 15 };
		Object arr2 = Array.newInstance(int.class, dim); 						// 다차원 배열도 가능하도록 int... 파라미터(가변)를 가진 메서드이다.
		System.out.println(arr2.getClass().getComponentType().getTypeName());	// int[][]

		Object arrObj = Array.get(arr2, 3); 									// get(int[][], 3)
		Class cls2 = arrObj.getClass().getComponentType();						// 배열인 경우 해당 컴포넌트 타입 클래스 반환
		System.out.println(cls2.getTypeName());									// int[]
		
		arrObj = Array.get(arrObj, 5);											// get(int[], 5)
		Array.setInt(arrObj, 10, 37);											// set(int, 10, 37(
		System.out.println(arrObj.getClass().getComponentType().getTypeName());	// int

		int[][][] arrcast = (int[][][]) arr2;
		System.out.println(arrcast[3][5][10]);
	}

}
