package codechef;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	static boolean isPalindrome(String str) {
		int l = 0;
		int h = str.length() - 1;

		while(l <= h) {
			if(str.charAt(l) == str.charAt(h)) {
				l++;
				h--;
			} else {
				return false;
			}
		}

		return true;
	}
	public static void main (String[] args) throws java.lang.Exception
	{

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while(t > 0) {
			t--;
			int n = sc.nextInt();

			String str = sc.next();

			if(str.length() < 3) {
				System.out.println("No");
				continue;
			}
			boolean flag = false;
			for(int i = 1; i <= str.length() - 2; i++) {
				int leftEnd = i-2;
				String leftString = "";
				String rightString = "";
				if(leftEnd >= 0) {
					leftString = str.substring(0, leftEnd+1);
				}
				int rightStart = i+2;
				if(rightStart <= str.length()-1) {
					rightString = str.substring(rightStart);
				}

				if(isPalindrome(leftString+rightString)) {
					flag = true;
				}
			}

			if(flag) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}