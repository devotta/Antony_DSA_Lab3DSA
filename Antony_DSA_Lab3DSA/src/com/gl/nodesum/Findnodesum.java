package com.gl.nodesum;

import java.util.Scanner;
import java.util.*;

public class Findnodesum {

	static class Node {
		int key, height;
		Node left, right;
	}

	// creation of new node
	static Node newNode(int data) {
		Node temp = new Node();

		temp.key = data;
		temp.height = 0;

		temp.left = null;
		temp.right = null;

		return temp;
	}

	// Inserting a Node in a Binary Search tree
	public Node insert(Node node, int key) {

		// create node
		if (node == null) {
			return (newNode(key));
		}
		// If the data is less than the node recursive call - left subtree
		if (key < node.key)
			node.left = insert(node.left, key);
		// If the data is less than the node recursive call - right subtree
		else if (key > node.key)
			node.right = insert(node.right, key);
		else { // Duplicate data are not allowed
			System.out.println("Cannot insert Duplicate values");
			return node;
		}

		return node;
	}

	public boolean find_node_pairs(Node currptr, int sum, List<Integer> list) {
		// check the root is null
		if (currptr == null)
			return false;
		// Traverse left subtree - sum and list are passed as parameters
		if (find_node_pairs(currptr.left, sum, list))
			return true;
		// difference of sum and currptr.key checked in the list
		if (list.contains(sum - currptr.key)) {
			System.out.println("Pair is  (" + (sum - currptr.key) + "," + currptr.key + ")");
			return true;
		} else
			// if difference not found add currptr.key (i.e., data) to the list
			list.add(currptr.key);

		return (find_node_pairs(currptr.right, sum, list));

	}

	public static void main(String[] args) {
		Node root = null;
		int values;
		int sumV;
		char choice = ' ';
		List<Integer> list = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);

		// Create an object
		Findnodesum findnodes = new Findnodesum();

		// Repeat until user entry -1 to build the tree
		System.out.println("Building Tree");
		do {
			System.out.println("Enter Node data (-1 to quit):");

			values = sc.nextInt();

			if (values != -1) {
				root = findnodes.insert(root, values);
			}
		} while (values != -1);
		do {
			System.out.println("Enter the sum value :");
			sumV = sc.nextInt();

			if (root != null) {
				if (!findnodes.find_node_pairs(root, sumV, list))
					System.out.println("Nodes are not found in tree");
				;
			} else {
				System.out.println("Tree is not built-Root is empty");

			}
	
			System.out.println("Do you want to check other values(press Y/y to continue, N/n-quit)? :");
			choice = sc.next().charAt(0);
			
		} while ((choice != 'n') && (choice != 'N'));
		sc.close();
		System.out.println("----Program successfully completed----");

	}
}
