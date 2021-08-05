package com.hashtable;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class HashTableUC3 {

	    private static HashNode Array[];
	    private static int noOfArrays;
	    private static int size;

	    //Create HashTable custom array Constructor
	    public HashTableUC3(int x) {
	        this.noOfArrays = x;
	        this.Array = new HashNode[noOfArrays];
	        this.size = 0;
	    }
	    public HashTableUC3() {
	        this(100);
	    }

	    //Create HashNode like Linked list one link and two data types
	    public class HashNode {
	        private Integer key;
	        private String value;
	        private HashNode next;

	        //Create HashNode like Linked list Constructor
	        public HashNode(Integer key, String value) {
	            this.key = key;
	            this.value = value;
	        }
	    }

	    //Fix the index depending on the key value for reducing the no of searching iterations
	    public static int getArrayIndex(Integer key) {
	        int index = key % noOfArrays;
	        return index;
	    }

	    //Put data in Hash Table using linked Node
	    public void putData(Integer key, String value) {
	        if (key == null || value == null) {
	            System.out.println("key or value are null");
	        }
	        int arrayIndex = getArrayIndex(key);
	        HashNode head = Array[arrayIndex];
	        // check existing node in hash table
	        while (head != null) {
	            if (head.key.equals(key)) {
	                head.value = value;
	                return;
	            }
	            head = head.next;
	        }
	        size++;
	        head = Array[arrayIndex];
	        HashNode node = new HashNode(key, value);
	        node.next = head;
	        Array[arrayIndex] = node;

	    }

	    //Checking given string no.of times in Hash Table
	    public int freqChecker(String value) {
	        HashNode node = Array[0];
	        int wordCount = 1;
	        while (node != null) {
	            if (node.value.equals(value)) {
	                wordCount++;
	            }
	            node = node.next;
	        }
	        return wordCount;
	    }

	    //Checking the values of the key
	    public static String getKeyValue(Integer key){
	        int arrayIndex = getArrayIndex(key);
	        HashNode head = Array[arrayIndex];
	        while (head != null){
	            if (head.key.equals(key)){
	                return head.value;
	            }
	            head = head.next;
	        }
	        return null;
	    }


	    //find frequency of words in a large paragraph phrase
	    public void freqOfWords(String str){
	        Map<String, Integer> map = new TreeMap<>();
	        String arr[] = str.split(" ");
	        for (int i=0; i<arr.length; i++){
	            if(map.containsKey(arr[i])){
	                map.put(arr[i], map.get(arr[i])+1);
	            }else {
	                map.put(arr[i], 1);
	            }
	        }
	        for (Map.Entry<String, Integer> entry: map.entrySet()){
	            System.out.println(entry.getKey()+ "--->"+entry.getValue());
	        }
	    }

	    public void remWord(String str) {
	        Map<String, Integer> map = new TreeMap<>();

	        Iterator <String> word = map.keySet().iterator();
	        while (word.hasNext()){
	            if (word.next().equals(str)){
	                word.remove();
	            }
	        }
	    }



	    public static void main(String[] args) {

	        //Create obj hashTable HashTable and HashNode like Linked list by using HashTable class
	        HashTable hashTable = new HashTable();
	        hashTable.putData(10, "To");
	        hashTable.putData(20, "be");
	        hashTable.putData(30, "or");
	        hashTable.putData(40, "not");
	        hashTable.putData(50, "to");
	        hashTable.putData(60, "be");

	        //Checking "To", "be", "or", "not" no.of times in HashTable
	        System.out.println("Frequency of To : "+hashTable.freqChecker("To"));
	        System.out.println("Frequency of be : "+hashTable.freqChecker("be"));
	        System.out.println("Frequency of or : "+hashTable.freqChecker("or"));
	        System.out.println("Frequency of not : "+hashTable.freqChecker("not"));

	        //Checking size of the HashTable
	        System.out.println("The size of hash table : " + HashTableUC3.size);


	        //Checking the values of the key
	        System.out.println("Finding Given key value : "+HashTableUC3.getKeyValue(20));

	        String paraString = "paranoids are not paranoids because they are paranoid but they keep putting themselves deliberately into paranoid avoidable situation";
	        System.out.println("Given Para String : " + paraString);
	        hashTable.freqOfWords(paraString);
	        
	        hashTable.remWord("they");



	    }

	}