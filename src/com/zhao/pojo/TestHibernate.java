package com.zhao.pojo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class TestHibernate {
	public static void main(String[] args) {
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
//		for (int i = 0; i < 10 ; i++) {
//			Product p=new Product();
//			p.setName("iphone"+i);
//			p.setPrice(i);
//			session.save(p);
//		}
		
		/**
		 * ʵ���������Hibernate����3��״̬ 
		 * �ֱ���˲ʱ���־ú��ѹ�
		 * ˲ʱ ָ����û�к�hibernate�����κι�ϵ�������ݿ���Ҳû�ж�Ӧ�ļ�¼��һ��JVM�������������Ҳ����ʧ�� 
		 * �־� ָ����һ�������hibernate������ϵ���ж�Ӧ��session,���������ݿ����ж�Ӧ��һ����¼ 
		 * �ѹ� ָ����һ��������Ȼ�����ݿ����ж�Ӧ��һ����¼������������Ӧ��session�Ѿ��ر��� 
		 */
//		Product p1=new Product();
//		p1.setName("p1");
//		System.out.println("��ʱp��˲ʱ״̬");
//        session.save(p1);
//        System.out.println("��ʱp�ǳ־�״̬");
//        
//        //ͨ��ID��ȡһ������
//        Product p2=(Product) session.get(Product.class, 6);
//        System.out.println("id=6�Ĳ�Ʒ�ǣ�"+p2.getName());
//        //ɾ��һ������
//        Product p3=(Product) session.get(Product.class, 7);
//        session.delete(p3);
//        //�޸�һ����������ԣ������µ����ݿ���
//        Product p4=(Product) session.get(Product.class, 4);
//        System.out.println(p4.getName());
//        p4.setName("iphone-modified");
//        session.update(p4);
        
		/**
		 * HQL��ѯ
		 * Criteria��ѯ
		 * SQL��ѯ
		 */
		  String name = "iphone";
//        //ʹ��HQL,����name����ģ����ѯ
//        Query q=session.createQuery("from Product p where p.name like ?");
//        q.setString(0, "%"+name+"%");
//        List<Product> pList1=q.list();
//        for (Product p : pList1) {
//			System.out.println(p.getName());
//		}
//        //ʹ��Criteria,����name����ģ����ѯ
//        Criteria criteria=session.createCriteria(Product.class);
//        criteria.add(Restrictions.ilike("name", "%"+name+"%"));
//        List<Product> pList2=criteria.list();
//        for (Product p : pList2) {
//			System.out.println(p.getName());
//		}
//        //ʹ�ñ�׼SQL,����name����ģ����ѯ.
//        String sql = "select * from product_ p where p.name like '%"+name+"%'";
//        Query q2 = session.createSQLQuery(sql);
//        List<Object[]> list=q2.list();
//        for (Object[] os : list) {
//			for (Object filed : os) {
//				System.out.println(filed+"\t");
//			}
//			System.out.println();
//		}
        
        //����many-to-one��ϵ.�½�Category����
//        Category category= new Category();
//        category.setName("c1");
//        session.save(category);
//        Product p5 = (Product) session.get(Product.class, 8);
//        p5.setCategory(category);
//        session.update(p5);
        
//        //HIBERNATE ʵ��һ�Զ�
//        Category category2=(Category) session.get(Category.class, 1);
//        Set<Product> products=category2.getProducts();
//        for (Product product : products) {
//			System.out.println(product.getName());
//		}
//        
//        /**
//         * ʵ�ֶ�Զ�
//         * 1.����3���û�
//         * 2.��Ʒ1���û�1,2,3����
//         */
//        Set<User> users=new HashSet();
//        for (int i = 0; i < 3; i++) {
//			User user = new User();
//			user.setName("user"+i);
//			users.add(user);
//			session.save(user);
//		}
//        Product p6=(Product) session.get(Product.class, 1);
//        p6.setUsers(users);
//        session.save(p6);
        
//		/**
//		 * ���Ե��ӳټ���: 
//		 * ��ʹ��load�ķ�ʽ����ȡ�����ʱ��ֻ�з����������������ԣ�hibernate�Żᵽ���ݿ��н��в�ѯ�����򲻻�������ݿ�
//		 */
//		Product p7=(Product) session.load(Product.class, 1);
//		System.out.println("log1");
//		System.out.println(p7.getName());
//		System.out.println("log2");
//		
//		//lazy=true��ʾ
//		Category category3=(Category) session.get(Category.class, 1);
//		System.out.println("log1");
//		System.out.println(category3.getProducts());
//		System.out.println("log2");
		
//		//Category.hbm.xml������cascade="delete" delete����
//		Category category4=(Category) session.get(Category.class, 3);
//		session.delete(category4);
//		//Category.hbm.xml������cascade="save-update" save-update����
//		Category category5=(Category) session.get(Category.class, 5);
//		Product p8=new Product();
//		p8.setName("product_501");
//		Product p9=new Product();
//		p9.setName("product_502");
//		Product p10=new Product();
//		p10.setName("product_503");
//		category5.getProducts().add(p8);
//		category5.getProducts().add(p9);
//		category5.getProducts().add(p10);
		
		//��������.ֻ����һ�����ݿ⡣��Ϊ�ڶ��λ�ȡ��Ȼû�дӵڶ���session���õ����棬���Ǵ�sessionfactory���õ���Category�������
//		Category category6=(Category) session.get(Category.class, 1);
//		System.out.println("log1");
//		Category category7=(Category) session.get(Category.class, 1);
//		System.out.println("log2");
//		session.getTransaction().commit();
//		session.close();
//		Session session2=sessionFactory.openSession();
//		session2.beginTransaction();
//		Category category8=(Category) session.get(Category.class, 1);
//		System.out.println("log3");
		
//		//��ҳ��ѯ
//		//String name = "iphone";
//		Criteria criteria2=session.createCriteria(Product.class);
//		criteria2.add(Restrictions.ilike("name", "%"+name+"%"));
//		criteria2.setFirstResult(2); //�ӵ�2�����ݿ�ʼ
//		criteria2.setMaxResults(5); //һ����ѯ5������
		
		/**
		 * get&load
		 * load��ʽ���ӳټ��أ�ֻ�����Ա����ʵ�ʱ��Ż����sql���
		 * get��ʽ�Ƿ��ӳټ��أ����ۺ���Ĵ����Ƿ����ʵ����ԣ�����ִ��sql���
		 * ����id�����ڵĶ���,get��ʽ�᷵��null,load��ʽ���׳��쳣
		 */
		System.out.println("log1");
        Product p11 = (Product) session.get(Product.class, 1);
        System.out.println("log2");
        Product p12 = (Product) session.load(Product.class, 2);
        System.out.println("log3");
        System.out.println(p12.getName());
        System.out.println("log4");
        
        /**
         * Hibernate�����ַ�ʽ���session,�ֱ��ǣ� openSession��getCurrentSession 
         * ���ǵ��������� 
         * 1. ��ȡ���Ƿ���ͬһ��session���� 
         * openSessionÿ�ζ���õ�һ���µ�Session���� 
         * getCurrentSession��ͬһ���߳��У�ÿ�ζ��ǻ�ȡ��ͬ��Session���󣬵����ڲ�ͬ���߳��л�ȡ���ǲ�ͬ��Session���� 
         * 2. �����ύ�ı�Ҫ�� 
         * openSessionֻ�������ӣ�ɾ�����޸ĵ�ʱ����Ҫ����(session.beginTransaction())����ѯʱ����Ҫ�� 
         * getCurrentSession�����в�����������������н��У������ύ�����session���Զ��رգ����ܹ��ٽ��йر� 
         */
		
        /**
         * N+1
         * Hibernate�л�����ƣ�����ͨ����id��Ϊkey��product���󱣴��ڻ����� 
         * ͬʱhibernateҲ�ṩQuery�Ĳ�ѯ��ʽ���������ݿ�����100����¼��������30����¼�ڻ����У�����ʹ��Query�ĵ�list�������ͻ����е�100�����ݶ������ݿ��в�ѯ����������30�������еļ�¼ 
         * N+1��ʲô��˼�أ�����ִ��һ��sql��䣬ȥ��ѯ��100����¼�����ǣ�ֻ������100����¼��ID 
         * Ȼ���ٸ���id,���н�һ����ѯ�� 
         * ���id�ڻ����У��ʹӻ����л�ȡproduct�����ˣ������ٴ����ݿ��л�ȡ
         * 
         * ʵ�ֲ��裺
         * ����ͨ��Query��iterator����������������Product��id�����
         * Ȼ����ͨ��it.next()��ѯÿһ������
         * �����������ڻ����У���ֱ�Ӵӻ�����ȡ��
         * ����ʹ����ݿ��л�ȡ
         * 
         * N+1�е�1������ָֻ����id��SQL��䣬Nָ��������ڻ������Ҳ�����Ӧ�����ݣ��͵����ݿ���ȥ��
         */
        //String name = "iphone";
        Query q3 =session.createQuery("from Product p where p.name like ?");
        q3.setString(0, "%"+name+"%");
        Iterator<Product> it= q3.iterate();
        while(it.hasNext()){
            Product p =it.next();
            System.out.println(p.getName());
        }
        
        //��ѯ����
        //String name = "iphone";
        Query q4 =session.createQuery("select count(*) from Product p where p.name like ?");
        q4.setString(0, "%"+name+"%");
        long total= (Long) q4.uniqueResult(); //����Query�����uniqueResult()����������һ��long�͵����ݣ�����ѯ������
        System.out.println(total);
        
        
        
        session.getTransaction().commit();
        session.close();
//		System.out.println("��ʱp���ѹ�״̬");
		sessionFactory.close();
	}
}
