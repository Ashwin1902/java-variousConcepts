package DirectChaining;

public class Main {
    public static void main(String[] args) {
         DirectChaining hashtable=new DirectChaining(10);
         hashtable.insertHashTable("Apple");
         hashtable.insertHashTable("ball");
         hashtable.insertHashTable("abcsg");
         hashtable.insertHashTable("hello");
         hashtable.insertHashTable("hi");
         //hashtable.insertHashTable("Apple");
         //hashtable.displayHashTable();
        //hashtable.searchHashTable("hello");

        hashtable.deleteKeyHashTable("hi");
        hashtable.displayHashTable();

   
    }
}
