public class MajorityElement {
    public int majorityElement(int[] a) {
        int majorityElement = a[0];
        int count = 1;
        int n = a.length;
        for(int i = 1; i < n; i++) {
            if(a[i] == majorityElement) {
                count++;
            } else {
                count--;
            }
             if(count < 0) {
                majorityElement = a[i];
                count = 1;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[] {2,2,1,1,1,2,2}));
    }
}
