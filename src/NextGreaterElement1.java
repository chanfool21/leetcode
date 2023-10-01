import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();

        int i = 0;
        int n = nums2.length;

        Map<Integer, Integer> ngeMap = new HashMap<>();
        while(i < 2*n) {
            if(st.empty()) {
                if(i < n)
                st.push(i);
            } else {
                int top = st.peek();
                while(!st.empty() && nums2[top] < nums2[i%n]) {
                    ngeMap.put(nums2[top], nums2[i%n]);
                    st.pop();
                    if(st.empty()) break;
                    top = st.peek();
                }
                if(i < n)
                    st.push(i%n);
            }

            i++;
        }

        while(!st.empty()) {
            int top = st.peek();
            ngeMap.put(nums2[top], -1);
            st.pop();
        }


        int [] res = new int[nums1.length];

        for(i = 0; i < nums1.length; i++) {
            res[i] = ngeMap.get(nums1[i]);
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new NextGreaterElement1().nextGreaterElement(new int[] {1,2,1}, new int[] {1,2,1}));
    }
}
