package com.robert.dsal.tree.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.robert.dsal.util.CollectionUtil;

public class BinaryTreeIteratorPostOrderDefault implements BinaryTreeIteratorPostOrder {

    private void iterateBinaryTreePostOrder(Stack<BinaryTreeNode> stack, List<Integer> result) {
        BinaryTreeNode last = null;
        while (!stack.isEmpty()) {
            BinaryTreeNode top = stack.pop();

            // �����������һ���ģ�ֻ������ʲôʱ���ӡ���ڵ㣬�������˳�ʱ��ӡ���������ƽ�ʱ���ӡ
            if (top.left == null && top.right == null) {
            	//�����ǰ��Ҷ�ӽڵ㣬����last�ǵ�ǰ�ڵ�
                last = top;
                
                //Ҷ�ӽڵ������Ǻ��������򣬶�ֱ�Ӵ�ӡ
                result.add(top.value);
            } else if (last != null && last == top.right) {
            	//��������������˻���������last�ǵ�ǰ�ڵ�
                last = top;
                result.add(top.value);
            } else if (last != null && last == top.left) {
            	//��������������˻���������last�ǵ�ǰ�ڵ�
                last = top;
                result.add(top.value);
            } else {
            	//������ǣ���ô������ǰ�ƽ�����Ҫ�ȰѸ��ڵ��ջ��Ȼ�󱣴���������������
                stack.push(top);
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left != null) {
                    stack.push(top.left);
                }
            }
        }
    }

    public int[] iterateBinaryTreePostOrder(BinaryTreeNode tree) {
        List<Integer> result = new ArrayList<Integer>();

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(tree);

        iterateBinaryTreePostOrder(stack, result);

        return CollectionUtil.convert(result);
    }
}
