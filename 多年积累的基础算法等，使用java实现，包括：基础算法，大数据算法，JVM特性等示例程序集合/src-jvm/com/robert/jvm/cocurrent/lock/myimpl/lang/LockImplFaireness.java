package com.robert.jvm.cocurrent.lock.myimpl.lang;

import java.util.LinkedList;
import java.util.Queue;

import com.robert.jvm.cocurrent.lock.myimpl.Lock;

/**
 * 
 * ��ƽ������������
 * 
 */
public class LockImplFaireness implements Lock {
	private boolean isLocked = false;
	private Thread lockedThread = null;

	// Ҳ������BlockingQueue, �Ͳ�����ͬ����
	private Queue<MonitorObject> waitingThreads = new LinkedList<MonitorObject>();

	public void lock() {

		// �������������syncrhonized(this)�ܷ��ʣ��� monitor.waitҲ�ܷ���
		MonitorObject monitor = new MonitorObject();
		// ����ǰ����Ϊ�˸��ı���
		synchronized (this) {
			waitingThreads.add(monitor);

			// �����ѭ����Ϊ����ֹNested Monitor Lockup Issue,
			// �������������ӣ�Ȼ������ӣ����Ǹ���Ȼ��������˾��޷�unlock, ��Ϊunlock�޷���ø���
			while (true) {
				// ����ǰ����Ϊ�˸��ı���
				synchronized (this) {
					if (!isLocked && monitor == waitingThreads.peek()) {
						// һ���̻߳������
						waitingThreads.remove();
						isLocked = true;
						lockedThread = Thread.currentThread();
						return;
					}
				}

				try {
					// �����Ӷ���ĵȴ�
					monitor.wait();
				} catch (InterruptedException e) {
					// Suspicious wakeup�� eat it and have it queue again
				}
			}
		}
	}

	public synchronized void unlock() {
		if (lockedThread != Thread.currentThread())
			throw new IllegalMonitorStateException(
					"The current thead should have obtained this lock.");

		isLocked = false;
		lockedThread = null;

		waitingThreads.peek().doNotify();
	}

}

class MonitorObject {
	private boolean isNotified = false;

	public synchronized void doWait() {
		while (!isNotified)
			try {
				wait();
			} catch (InterruptedException e) {
				// Suspicious Wakeup
			}

		isNotified = false;
	}

	public synchronized void doNotify() {
		isNotified = true;
		notify();
	}
}
