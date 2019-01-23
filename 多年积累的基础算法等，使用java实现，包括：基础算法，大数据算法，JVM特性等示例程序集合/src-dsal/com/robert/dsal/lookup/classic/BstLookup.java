package com.robert.dsal.lookup.classic;

import com.robert.dsal.tree.binary.BinaryTreeNode;

/**
 * �㷨���ƣ�
 * 
 * �������������
 * 
 * �㷨������
 * 
 * �Բ��ҵ����鹹���������������������������������Խ��в��ҡ�
 * 
 * ʱ�临�Ӷȣ�
 * 
 * O(log2N)
 */
public class BstLookup extends AbstractLookup {
	private BinaryTreeNode root;

	@Override
	public void setup(int[] seq) {
		super.setup(seq);

		root = constructBinarySearchTree(seq);
	}

	private BinaryTreeNode constructBinarySearchTree(int[] seq) {
		if (seq.length == 0)
			return null;

		root = new BinaryTreeNode();
		root.value = seq[0];

		for (int i = 0; i < seq.length; i++) {
			constructBinarySearchTree(root, seq[i], i);
		}

		return root;
	}

	private void constructBinarySearchTree(BinaryTreeNode root, int value,
			int index) {
		if (value < root.value) {
			if (root.left != null)
				constructBinarySearchTree(root.left, value, index);
			else {
				root.left = new BinaryTreeNode();
				root.left.value = value;
				root.left.attr = index;
			}
		} else {
			if (root.right != null)
				constructBinarySearchTree(root.right, value, index);
			else {
				root.right = new BinaryTreeNode();
				root.right.value = value;
				root.right.attr = index;
			}
		}
	}

	@Override
	public int lookup(int t) {
		BinaryTreeNode curr = root;

		while (curr != null) {
			if (curr.value == t)
				return curr.attr;

			if (t < curr.value)
				curr = curr.left;
			else
				curr = curr.right;
		}

		return -1;
	}
}
