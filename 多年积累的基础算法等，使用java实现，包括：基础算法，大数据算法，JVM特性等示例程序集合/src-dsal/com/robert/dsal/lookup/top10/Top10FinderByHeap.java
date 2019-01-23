package com.robert.dsal.lookup.top10;

import com.robert.dsal.util.AlUtil;
import com.robert.dsal.util.DisplayUtil;

public class Top10FinderByHeap implements Top10Finder {
    public int[] findTop10(int[] a) {
        DisplayUtil.printSeq("Srouce Data", a);

        // ����
        int[] heap = new int[10];
        for (int i = 0; i < 10; i++)
            heap[i] = a[i];

        DisplayUtil.printSeq("Heap Filled", heap);
        
        // ������С��
        construct(heap);
        
        DisplayUtil.printSeq("Heap Init", heap);

        for (int i = 10; i < a.length; i++) {
            if (a[i] > heap[0]) {
                //���ĳһ��ֵ����С�ѵ���Сֵ�����滻��С�ѵ���Сֵ
                heap[0] = a[i];
                adjust(heap, 0, heap.length);
            }

            DisplayUtil.printSeq("Step " + i, heap);
        }

        return heap;
    }

    private void construct(int[] heap) {
        // �ӵ�һ����Ҷ�ӽڵ㿪ʼ��ǰ����
        for (int i = heap.length / 2; i >= 0; i--) {
            adjust(heap, i, heap.length);
        }
    }

    private void adjust(int[] heap, int start, int end) {
        while (2 * start + 1 < end) {
            int min = 2 * start + 1;

            // �ҵ�������������С��
            if (2 * start + 2 < end && heap[2 * start + 2] < heap[min]) min = 2 * start + 2;

            
            if (heap[min] < heap[start]) {
             // ������ӱȸ��׻�С���򽻻����ӽ����ĺ��ӽڵ�������µ���
                AlUtil.swap(heap, min, start);
                start = min;
            } else
                // ������ڵ���С�����ǺϷ��Ķ�
                break;
        }
    }
}
