public class Main {
    public static void main(String[] argv){
        Stack st = new Stack(4);
        boolean result = st.isEmpty();
        System.out.println(result);
        st.Push(1);
        st.Push(2);
        st.Push(3);
        st.Push(4);
        System.out.println(st.isFull());
        System.out.println(st.Peek());
        System.out.println(st.Pop());
        System.out.println(st.Pop());
        System.out.println(st.Pop());
        System.out.println(st.Pop());
        st.deleteStack();



}
    }
