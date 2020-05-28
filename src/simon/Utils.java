package simon;

public class Utils {
	
	//reset vars for different levels with increasing iterations
	public static int[] RESET_4 = {5,5,5,5}; // reset default user input sequence arr
	public static int[] RESET_5 = {5,5,5,5,5}; // reset default user input sequence arr
	public static int[] RESET_6 = {5,5,5,5,5,5}; // reset default user input sequence arr
	public static int[] RESET_7 = {5,5,5,5,5,5,5}; // reset default user input sequence arr
	//
	
	public static boolean areEqual(int[] arr1, int[] arr2) {
		if(arr1.length != arr2.length) {
			return false;
		}
		for(int i = 0; i < arr1.length; ++i) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void delay(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
