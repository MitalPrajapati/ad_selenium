package Generic_Utilities;

import java.util.Random;

public class Java_utility {
 
//	public static int getRandomNum() {
//		Random ran = new Random();
//		int ranNum = ran.nextInt();
//		return ranNum;
//	}//int ranNum = Java_utility.getRandomNum();->call static method
	
	public int getRandomNum() {
		Random ran = new Random();
		int ranNum = ran.nextInt();
		return ranNum;
	}//--> Java_utility j = new Java_utility(); int ranNum = j.getRandomNum();-->call non static method
}
