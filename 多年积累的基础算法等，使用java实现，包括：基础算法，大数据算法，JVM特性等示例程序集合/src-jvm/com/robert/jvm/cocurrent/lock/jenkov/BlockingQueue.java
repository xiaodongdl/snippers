package com.robert.jvm.cocurrent.lock.jenkov;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

	private List queue = new LinkedList();
	private int limit = 10;

	public BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		// ��ǰ����Ϊ�գ���Ҫ����֮ǰ��֪ͨ���г������߳�ȥ�������У���Ϊͬ�������ԣ�������֪ͨ
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		// ��ǰ����������Ҫ������һ��Ԫ��ǰ��֪ͨ���׼����ȥ��Ԫ��
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}

}
