package DirectChaining;

import java.util.*;

class DirectChaining{
    LinkedList<String>[] hashtable;
     int maxListSize=5;

     DirectChaining(int size){
        this.hashtable=new LinkedList[size];
     }

     private int modASCIIHashFunction(String word, int M) {
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for (sum=0,i=0; i<word.length(); i++) {
          sum = sum + ch[i];
        }
        return sum % M;
      }

    public void insertHashTable(String word){
        int newIndex=modASCIIHashFunction(word,hashtable.length);
        if(hashtable[newIndex]==null){
           hashtable[newIndex]=new LinkedList<String>();
           hashtable[newIndex].add(word);
        }
        else{
            hashtable[newIndex].add(word);
        }
    }
    public void displayHashTable() {
        if (hashtable == null) {
          System.out.println("\nHashTable does not exists");
          return;
        } else {
          System.out.println("\n----------HashTable----------");
          for (int i=0; i<hashtable.length; i++) {
            System.out.println("Index " + i + ", key:" + hashtable[i]);
          }
        }
      }

      public boolean searchHashTable(String word) {
        int newIndex = modASCIIHashFunction(word, hashtable.length);
        if (hashtable[newIndex] != null && hashtable[newIndex].contains(word)) {
          System.out.println("\n" + "\"" + word + "\"" + " found in Hastable at lcoation: " +newIndex);
          return true;
        } else {
          System.out.println("\n" + "\"" + word + "\"" + " not found in HashTable");
          return false;
        }
      }

      public void deleteKeyHashTable(String word) {
        int newIndex = modASCIIHashFunction(word, hashtable.length);
        boolean result = searchHashTable(word);
        if (result == true) {
          hashtable[newIndex].remove(word);
          System.out.println("\n" + "\"" + word + "\"" + " has been deleted from HashTable ");
        }
      }


}