package com.robert.bigdata.fileinter;

import java.io.File;

/*
 �������ļ��󽻼�, ��������m - n

 ��O(mn)

 �ⷨ1��ƽ���ֿ�: k

 �Ա�O(mn)
 ���̶�ȡ����O(m + k * n) = O(m + kn)
 -----�ֿ�kԽ�࣬��ȡ������Խ�࣬���ǣ�ÿ�������ڴ��ԽС
 -----�ֿ�kԽ�٣���ȡ������Խ�٣����ǣ���Ҫ���ڴ��Խ��
 -----�ڴ�ʹ�úͶ�ȡ�����ǳɷ��ȵ�


 �ⷨ2��ʹ��hash�ֿ飬hash(string) % k, һ���ֳ�k��,ͬ����������ͬ����Ҫ�Ŀ��Ȼ������hashͳ�� 

 �Ա�O(m + n + (m/k + n/k) * k) = O(m + n) ��������
 ���̶�ȡ����O(m + n + (m/k + n /k) * k) = O(2m + 2n) = O(m + n) ��������

 ------�ɼ�����ʹ��hash���������ڷֿ�ķ�Χ�ڣ��ͽ����˸��Ӷȣ�ʱ�临�ӶȽ��Ƴ�����

 �ⷨ3�������еĹ����Ӹ��ڵ����������

 http://www.cnblogs.com/chenwenbiao/archive/2011/05/26/2058261.html
 */

public interface FilesIntercept {
	public File interceptFiles(File f1, File f2);
}
