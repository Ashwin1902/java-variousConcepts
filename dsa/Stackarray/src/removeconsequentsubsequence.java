import java.util.Stack;
public class removeconsequentsubsequence {
    public static int[] remove(int[] arr){
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty() || arr[i]!=st.peek()){
                st.push(arr[i]);
            }
            else if(st.peek()==arr[i] ){
                if(i==arr.length-1 || arr[i]!=arr[i+1]) st.pop();
            }
        }        
        int[] ans=new int[st.size()];
        int n=ans.length;
        for(int i=n-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr={1,2,2,3,10,10,10,4,4,4,5,7,7,2};
        int[] res=remove(arr);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
