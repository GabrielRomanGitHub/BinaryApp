//Converter2.java
//@author Gabriel Roman
//31/01/2024

import java.util.Scanner;

public class Converter2{
	public static void main (String args[]){
		Scanner scanRead = new Scanner (System.in);
		System.out.println("--------------------------------------------");
		System.out.println("Input 1 for the BINARY to DECIMAL Converter.");
		System.out.println("Input 2 for the DECIMAL to BINARY Converter.");
		System.out.println("--------------------------------------------");

		System.out.print("User Input: ");
		int converter = scanRead.nextInt();

		// BINARY to DECIMAL converter:
		if (converter == 1){
			System.out.println("--------------------------------------------");
			System.out.print("Input the BINARY number to be converted: ");
			String binaryNum = scanRead.next();
			System.out.println("--------------------------------------------");

			int j = 0;
			int totalConvertedNum = 0;

			for (int i = binaryNum.length()-1; i <= binaryNum.length() && i >= 0; i--) {
				// i = number of positions in the input number:
				// EXAMPLE:
				//           1 0 1 1 0 1 1
				//       i = 6 5 4 3 2 1 0
				//       i = 6 <----------
				// j = selects numbers from left to right, moving one to the right each iteration:
				// EXAMPLE:
				//           1 0 1 1 0 1 1
				//  1st: j = ↑
				//  2nd: j =   ↑ ... So on and so forth.
				double convertedNum;
				int num1 = 1;
				int individualNum = Character.getNumericValue(binaryNum.charAt(j));

				convertedNum = individualNum * (Math.pow(2,i));
				totalConvertedNum += convertedNum;
				j++;
			}
			// Output of the converter:
			System.out.println("The converted number is: "+totalConvertedNum);
			System.out.println("--------------------------------------------");
		}

		// DECIMAL to BINARY converter:
		else if (converter == 2){
			System.out.println("--------------------------------------------");
			System.out.print("Input the DECIMAL number to be converted: ");
			String decimalNum = scanRead.next();
			System.out.println("--------------------------------------------");

			String remainer = "";
			int num = Integer.valueOf(decimalNum);
			int minusResult;

			// Next while loop will add all remainers (1's or 0's after the modulus on the results) to the empy "remainer" loop
			// EXAMPLE:
			// User input :7
			//             7 / 2 = 3 ---> Remainer is 1 |
			//             3 / 2 = 1 ---> Remainer is 1 |
			//             1 / 2 = 0 ---> Remainer is 1 ↓
			// The loop stops after the 0.
			// The loop added "111" to the String "remainer", top to bottom.
			while (num > 0){
				int result;
				result = num%2;
				minusResult = num-=result;
				num = minusResult/2;

				String resultString = Integer.toString(result);
				remainer += resultString;
			}

			// Next for loop will take the remainer and invert it.
			for(int i = remainer.length()-1; i>=0; i-- ){
				int individualNum = Character.getNumericValue(remainer.charAt(i));

				//Output of the converter:
				System.out.print(individualNum);
			}
			System.out.println("\n--------------------------------------------");
		}

	}

}