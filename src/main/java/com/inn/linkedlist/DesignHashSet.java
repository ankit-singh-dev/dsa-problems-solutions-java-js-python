package com.inn.linkedlist;

/*
 * Leetcode-705
 * https://leetcode.com/problems/design-hashset/
 */
class HashSetNode{
	int hashCode;
	int key;
	String value = "PRESENT";
	HashSetNode next;
	public HashSetNode(int hashCode, int key,HashSetNode next) {
		super();
		this.hashCode = hashCode;
		this.key = key;
		this.next = next;
	}
}

class MyHashSet {

	int defaultSize = 16;
	HashSetNode[] nodes;
	
    public MyHashSet() {
        nodes = new HashSetNode[defaultSize];
    }
    
    public void add(int key) {
    	int hashCode = hashCode(key);
    	int bucketIndex = hashCode % defaultSize;
    	if(nodes[bucketIndex] != null) {
    		HashSetNode existingNodes = nodes[bucketIndex];
    		HashSetNode justPrevNode = null;
    		HashSetNode tempNode = existingNodes;
    		while(tempNode != null) {
    			if(tempNode.key == key) {
    				return;
    			}
    			justPrevNode = tempNode;
    			tempNode = tempNode.next;
    		}
    		HashSetNode node = new HashSetNode(hashCode, key,null);
    		justPrevNode.next = node;
    	}else {
    		HashSetNode node = new HashSetNode(hashCode, key,null);
    		nodes[bucketIndex] = node;
    	}
    }
    
    public void remove(int key) {
    	int hashCode = hashCode(key);
    	int bucketIndex = hashCode % defaultSize;
    	if(nodes[bucketIndex] != null) {
    		HashSetNode existingNodes = nodes[bucketIndex];
    		HashSetNode justPrevNode = null;
    		HashSetNode tempNode = existingNodes;
    		while(tempNode != null) {
    			if(tempNode.key == key) {
    				if(justPrevNode == null) {
    					// pahela node
    					nodes[bucketIndex] = tempNode.next;
    				}else {
    					justPrevNode.next = tempNode.next;
    				}
    				return;
    			}
    			justPrevNode = tempNode;
    			tempNode = tempNode.next;
    		}
    	}
    }
    
    public boolean contains(int key) {
    	int hashCode = hashCode(key);
    	int bucketIndex = hashCode % defaultSize;
    	if(nodes[bucketIndex] != null) {
    		HashSetNode existingNodes = nodes[bucketIndex];
    		HashSetNode tempNode = existingNodes;
    		while(tempNode != null) {
    			if(tempNode.key == key) {
    				return true;
    			}
    			tempNode = tempNode.next;
    		}
    		return false;
    	}
        return false;
    }
    
    private int hashCode(int key) {
    	return key;
    }
}

public class DesignHashSet {

	public static void main(String[] args) {
		MyHashSet myHashSet = new MyHashSet();
		myHashSet.add(1);      // set = [1]
		myHashSet.add(2);      // set = [1, 2]
		myHashSet.contains(1); // return True
		myHashSet.contains(3); // return False, (not found)
		myHashSet.add(2);      // set = [1, 2]
		myHashSet.contains(2); // return True
		myHashSet.remove(2);   // set = [1]
		myHashSet.contains(2); // return False, (already removed)
	}

}
