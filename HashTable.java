package com.hashtable;

public class HashTable {
	
    private HashNode Array[];
    private int noOfArrays;
    private int size;

    //Create HashTable custom array Constructor
    public HashTable(int x) {
        this.noOfArrays = x;
        this.Array = new HashNode[noOfArrays];
        this.size = 0;
    }
    public HashTable() {
        this(10);
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
    public int getArrayIndex(Integer key) {
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
        int wordCount = 0;
        while (node != null) {
            if (node.value.equals(value)) {
                wordCount++;
            }
            node = node.next;
        }
        return wordCount;
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
        System.out.println("The size of hash table : " + hashTable.size);
    }
	public String getKeyValue(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	public void freqOfWords(String paraString) {
		// TODO Auto-generated method stub
		
	}
	public void remWord(String string) {
		
	}
}