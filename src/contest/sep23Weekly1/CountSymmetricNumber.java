package contest.sep23Weekly1;

public class CountSymmetricNumber {

    int sumOfDigit(String str) {
        int val = Integer.parseInt(str);

        int sum = 0;
        while(val > 0) {
            sum += val % 10;
            val /=10;
        }
        return sum;
    }

    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for(int i = low; i <= high; i++) {
            String str = String.valueOf(i);
            int n = str.length();
            if(n%2 != 0) continue;
            int first = sumOfDigit(str.substring(0, n/2));
            int last = sumOfDigit(str.substring(n/2,n));

            if(first == last) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new CountSymmetricNumber().countSymmetricIntegers(1, 100));
    }
}
