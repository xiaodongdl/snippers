package com.robert.dsal.tree.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.robert.dsal.util.CollectionUtil;

public class BinaryTreeIteratorInOrderDefault implements BinaryTreeIteratorInOrder {

    private void iterateBinaryTreeInOrder(Stack<BinaryTreeNode> stack, List<Integer> result) {
        BinaryTreeNode p = stack.pop();
        if (p == null)
            return;

        while (true) {
            if (p != null) {
            	// ���p����������p��ջ��֪��û����������
                stack.push(p);
                p = p.left;
            } else if (!stack.isEmpty()) {
            	//ֱ��û���������ˣ����ջ��ȡ��һ������ӡ�������м�ڵ㣬���Ұ�pתΪ������
                p = stack.pop();
                result.add(p.value);
                p = p.right;
            } else {
                return;
            }
        }

    }

    public int[] iterateBinaryTreeInOrder(BinaryTreeNode tree) {
        List<Integer> result = new ArrayList<Integer>();

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(tree);

        iterateBinaryTreeInOrder(stack, result);

        return CollectionUtil.convert(result);
    }
}
