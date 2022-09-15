package com.inn.linkedlist;

class HashMapNode {
	int key;
	int value;
	int hashCode;
	HashMapNode next;

	public HashMapNode(int key, int value, int hashCode) {
		super();
		this.key = key;
		this.value = value;
		this.hashCode = hashCode;
	}
}

class MyHashMap {
    
	HashMapNode[] nodes;
	int DEFAULT_SIZE = 16;

    public MyHashMap() {
        nodes = new HashMapNode[DEFAULT_SIZE];
    }
    
    public void put(int key, int value) {
        int hashCode = getHashCode(key);
		int bucketIndex = hashCode % DEFAULT_SIZE;
		if (nodes[bucketIndex] != null) {
			HashMapNode existingNode = nodes[bucketIndex];
			HashMapNode tempNode = existingNode;
			HashMapNode justPrevNode = null;
			while (tempNode != null) {
				if (tempNode.key == key) {
					tempNode.value = value;
					return;
				}
				justPrevNode = tempNode;
				tempNode = tempNode.next;
			}
			HashMapNode node = new HashMapNode(key, value, hashCode);
			justPrevNode.next = node;
		} else {
			HashMapNode node = new HashMapNode(key, value, hashCode);
			nodes[bucketIndex] = node;
		}
    }
    
    public int get(int key) {
        int hashCode = getHashCode(key);
		int bucketIndex = hashCode % DEFAULT_SIZE;
		if (nodes[bucketIndex] != null) {
			HashMapNode existingNode = nodes[bucketIndex];
			HashMapNode tempNode = existingNode;
			while (tempNode != null) {
				if (tempNode.key == key) {
					return tempNode.value;
				}
				tempNode = tempNode.next;
			}
			return -1;
		} else {
			return -1;
		}
    }
    
    public void remove(int key) {
        int hashCode = getHashCode(key);
		int bucketIndex = hashCode % DEFAULT_SIZE;
		if (nodes[bucketIndex] != null) {
			HashMapNode existingNode = nodes[bucketIndex];
			HashMapNode tempNode = existingNode;
			HashMapNode justPrevNode = null;
			while (tempNode != null) {
				if (tempNode.key == key) {
					if (justPrevNode == null) {
						// pahela node
						nodes[bucketIndex] = tempNode.next;
					} else {
						justPrevNode.next = tempNode.next;
					}
					return;
				}
				justPrevNode = tempNode;
				tempNode = tempNode.next;
			}
		}
    }
    
    private int getHashCode(int key) {
		return key;
	}
}

public class DesignHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
