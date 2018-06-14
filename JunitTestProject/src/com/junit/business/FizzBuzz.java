package com.junit.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {

	static String ones[] = { "Zero", "One", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };
	static String tens[] = { " ", " ", "Twenty", "Thirty", "Fourty", "Fifty",
			"Sixty", "Seventy", "Eighty", "Ninety" };

	public String numToStringMethod(int numb) {

		String str = "";
		if (numb >= 100) {
			str += ones[numb / 100] + " hundread ";
			str += numToStringMethod(numb % 100);

			// System.out.println(numb%100);
		} else if (numb >= 20) {

			str += tens[numb / 10];
			str += numToStringMethod(numb % 10);
			// System.out.println(numb%10);
		} else if (numb > 0) {
			str += ones[numb];
		}

		return str;
	}

	public static void main(String[] args) {

		while (true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println("Enter number");
			String input = null;
			try {
				input = reader.readLine();

				int num = Integer.parseInt(input);
				FizzBuzz obj = new FizzBuzz();

				String result = null;
				if (num != 0 && num <= 999) {
					result = obj.numToStringMethod(num);
				} else if (num > 999) {
					System.out.println("Number is greater than 999");
					result = "Number is greater than 999";
					continue;

				} else if (num == 0) {
					System.out
							.println("Number is equal to 0 so exiting the application");
					System.exit(0);
				}

				System.out.println(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
