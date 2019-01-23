package com.robert.arch.design.uuid;

public class IdWorker {
    // ����ID
    private final long workerId;

    // ��Ԫ��ʼʱ��
    private final static long twepoch = 1361753741828L;

    // Sequence��0��ʼ
    private long sequence = 0L;

    // ����ID��ռ��λ��
    private final static long workerIdBits = 4L;

    // ����ID�����ֵ
    public final static long maxWorkerId = -1L ^ -1L << workerIdBits;

    // Sequence��ռ��λ��
    private final static long sequenceBits = 10L;

    // ����ID��ƫ����
    private final static long workerIdShift = sequenceBits;

    // ʱ�����ƫ����
    private final static long timestampLeftShift = sequenceBits + workerIdBits;

    // Sequence������λ
    public final static long sequenceMask = -1L ^ -1L << sequenceBits;

    // ��һ��������
    private long lastTimestamp = -1L;

    public IdWorker(final long workerId) {
        super();
        // ���16���ڵ�
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        this.workerId = workerId;
    }

    public synchronized long nextId() {
        long timestamp = this.timeGen();
        if (this.lastTimestamp == timestamp) {
            // ��ͳһ�����ڲ���
            this.sequence = (this.sequence + 1) & this.sequenceMask;
            if (this.sequence == 0) {
                // ͬһ�����ڵ�ID�Ѿ��ù��ˣ��ȵ���һ������ܼ�������
                System.out.println("###########" + sequenceMask);
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            // ��һ�εĺ����Ѿ���ȥ�ˣ����ڽ�����һ�����룬����Sequence
            this.sequence = 0;
        }

        // ���ϵͳʱ�䷢���˸��ģ����Ҹ��ĵ���һ����ȥ��ʱ��
        if (timestamp < this.lastTimestamp) {
            try {
                throw new Exception(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", this.lastTimestamp
                        - timestamp));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // �����ϴεĺ���
        this.lastTimestamp = timestamp;

        // ������ ------> ����ID ------> �����ڵ�Sequence
        long nextId = ((timestamp - twepoch << timestampLeftShift)) | (workerId << workerIdShift) | (this.sequence);
        return nextId;
    }

    private long tilNextMillis(final long lastTimestamp) {
        // �ȴ�����һ������
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }


    public static void main1(String[] args) {
        IdWorker worker2 = new IdWorker(2);
        System.out.println(worker2.nextId());
    }
}
