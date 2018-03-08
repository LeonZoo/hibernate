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
		 * 故意创造一个场景来制造脏数据。
		 * 1. 通过session1得到id=1的对象 product1
		 * 2. 在product1原来价格的基础上增加1000
		 * 3. 更新product1之前，通过session2得到id=1的对象product2
		 * 4. 在product2原来价格的基础上增加1000
		 * 5. 更新product1
		 * 6. 更新product2
		 * 最后结果是product的价格只增加了1000，而不是2000
		 */
		s1.beginTransaction();
		s2.beginTransaction();

		Product p1 = (Product) s1.get(Product.class, 1);
		System.out.println("产品原本价格是: " + p1.getPrice());

		p1.setPrice(p1.getPrice() + 1000);

		Product p2 = (Product) s2.get(Product.class, 1);
		p2.setPrice(p2.getPrice() + 1000);

		s1.update(p1);
		s2.update(p2);

		s1.getTransaction().commit();
		s2.getTransaction().commit();

		Product p = (Product) s1.get(Product.class, 1);

		System.out.println("经过两次价格增加后，价格变为: " + p.getPrice());
		
		/**
		 * 使用乐观锁来处理脏数据
		 * 1.修改配置文件 Product.hbm.xml。增加一个version字段，用于版本信息控制。这就是乐观锁的核心机制。
		 * 2.修改 Product.java。增加version属性
		 * 3.重新运行代码，就会抛出异常，提示该行已经被其他事务删除或者修改过了，本次修改无法生效。
		 */
		
		/**
		 * 原理：
		 * 1. 假设数据库中产品的价格是10000，version是10
		 * 2. session1,session2分别获取了该对象
		 * 3. 都修改了对象的价格
		 * 4. session1试图保存到数据库，检测version依旧=10，成功保存，并把version修改为11
		 * 5. session2试图保存到数据库，检测version=11，说明该数据已经被其他人动过了。 保存失败，抛出异常
		 */

		s1.close();
		s2.close();

		sf.close();
	}
}
