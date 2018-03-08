package com.zhao.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate2 {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		Session s2 = sf.openSession();

		/**
		 * ���ⴴ��һ�����������������ݡ�
		 * 1. ͨ��session1�õ�id=1�Ķ��� product1
		 * 2. ��product1ԭ���۸�Ļ���������1000
		 * 3. ����product1֮ǰ��ͨ��session2�õ�id=1�Ķ���product2
		 * 4. ��product2ԭ���۸�Ļ���������1000
		 * 5. ����product1
		 * 6. ����product2
		 * �������product�ļ۸�ֻ������1000��������2000
		 */
		s1.beginTransaction();
		s2.beginTransaction();

		Product p1 = (Product) s1.get(Product.class, 1);
		System.out.println("��Ʒԭ���۸���: " + p1.getPrice());

		p1.setPrice(p1.getPrice() + 1000);

		Product p2 = (Product) s2.get(Product.class, 1);
		p2.setPrice(p2.getPrice() + 1000);

		s1.update(p1);
		s2.update(p2);

		s1.getTransaction().commit();
		s2.getTransaction().commit();

		Product p = (Product) s1.get(Product.class, 1);

		System.out.println("�������μ۸����Ӻ󣬼۸��Ϊ: " + p.getPrice());
		
		/**
		 * ʹ���ֹ���������������
		 * 1.�޸������ļ� Product.hbm.xml������һ��version�ֶΣ����ڰ汾��Ϣ���ơ�������ֹ����ĺ��Ļ��ơ�
		 * 2.�޸� Product.java������version����
		 * 3.�������д��룬�ͻ��׳��쳣����ʾ�����Ѿ�����������ɾ�������޸Ĺ��ˣ������޸��޷���Ч��
		 */
		
		/**
		 * ԭ��
		 * 1. �������ݿ��в�Ʒ�ļ۸���10000��version��10
		 * 2. session1,session2�ֱ��ȡ�˸ö���
		 * 3. ���޸��˶���ļ۸�
		 * 4. session1��ͼ���浽���ݿ⣬���version����=10���ɹ����棬����version�޸�Ϊ11
		 * 5. session2��ͼ���浽���ݿ⣬���version=11��˵���������Ѿ��������˶����ˡ� ����ʧ�ܣ��׳��쳣
		 */

		s1.close();
		s2.close();

		sf.close();
	}
}
