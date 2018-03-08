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
		 * 实体类对象在Hibernate中有3种状态 
		 * 分别是瞬时，持久和脱管
		 * 瞬时 指的是没有和hibernate发生任何关系，在数据库中也没有对应的记录，一旦JVM结束，这个对象也就消失了 
		 * 持久 指得是一个对象和hibernate发生联系，有对应的session,并且在数据库中有对应的一条记录 
		 * 脱管 指的是一个对象虽然在数据库中有对应的一条记录，但是它所对应的session已经关闭了 
		 */
//		Product p1=new Product();
//		p1.setName("p1");
//		System.out.println("此时p是瞬时状态");
//        session.save(p1);
//        System.out.println("此时p是持久状态");
//        
//        //通过ID获取一个对象
//        Product p2=(Product) session.get(Product.class, 6);
//        System.out.println("id=6的产品是："+p2.getName());
//        //删除一条数据
//        Product p3=(Product) session.get(Product.class, 7);
//        session.delete(p3);
//        //修改一个对象的属性，并更新到数据库中
//        Product p4=(Product) session.get(Product.class, 4);
//        System.out.println(p4.getName());
//        p4.setName("iphone-modified");
//        session.update(p4);
        
		/**
		 * HQL查询
		 * Criteria查询
		 * SQL查询
		 */
		  String name = "iphone";
//        //使用HQL,根据name进行模糊查询
//        Query q=session.createQuery("from Product p where p.name like ?");
//        q.setString(0, "%"+name+"%");
//        List<Product> pList1=q.list();
//        for (Product p : pList1) {
//			System.out.println(p.getName());
//		}
//        //使用Criteria,根据name进行模糊查询
//        Criteria criteria=session.createCriteria(Product.class);
//        criteria.add(Restrictions.ilike("name", "%"+name+"%"));
//        List<Product> pList2=criteria.list();
//        for (Product p : pList2) {
//			System.out.println(p.getName());
//		}
//        //使用标准SQL,根据name进行模糊查询.
//        String sql = "select * from product_ p where p.name like '%"+name+"%'";
//        Query q2 = session.createSQLQuery(sql);
//        List<Object[]> list=q2.list();
//        for (Object[] os : list) {
//			for (Object filed : os) {
//				System.out.println(filed+"\t");
//			}
//			System.out.println();
//		}
        
        //测试many-to-one关系.新建Category对象
//        Category category= new Category();
//        category.setName("c1");
//        session.save(category);
//        Product p5 = (Product) session.get(Product.class, 8);
//        p5.setCategory(category);
//        session.update(p5);
        
//        //HIBERNATE 实现一对多
//        Category category2=(Category) session.get(Category.class, 1);
//        Set<Product> products=category2.getProducts();
//        for (Product product : products) {
//			System.out.println(product.getName());
//		}
//        
//        /**
//         * 实现多对多
//         * 1.增加3个用户
//         * 2.产品1被用户1,2,3购买
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
//		 * 属性的延迟加载: 
//		 * 当使用load的方式来获取对象的时候，只有访问了这个对象的属性，hibernate才会到数据库中进行查询。否则不会访问数据库
//		 */
//		Product p7=(Product) session.load(Product.class, 1);
//		System.out.println("log1");
//		System.out.println(p7.getName());
//		System.out.println("log2");
//		
//		//lazy=true演示
//		Category category3=(Category) session.get(Category.class, 1);
//		System.out.println("log1");
//		System.out.println(category3.getProducts());
//		System.out.println("log2");
		
//		//Category.hbm.xml中设置cascade="delete" delete级联
//		Category category4=(Category) session.get(Category.class, 3);
//		session.delete(category4);
//		//Category.hbm.xml中设置cascade="save-update" save-update级联
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
		
		//二级缓存.只访问一次数据库。因为第二次获取虽然没有从第二个session中拿到缓存，但是从sessionfactory中拿到了Category缓存对象
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
		
//		//分页查询
//		//String name = "iphone";
//		Criteria criteria2=session.createCriteria(Product.class);
//		criteria2.add(Restrictions.ilike("name", "%"+name+"%"));
//		criteria2.setFirstResult(2); //从第2条数据开始
//		criteria2.setMaxResults(5); //一共查询5条数据
		
		/**
		 * get&load
		 * load方式是延迟加载，只有属性被访问的时候才会调用sql语句
		 * get方式是非延迟加载，无论后面的代码是否会访问到属性，马上执行sql语句
		 * 对于id不存在的对象,get方式会返回null,load方式会抛出异常
		 */
		System.out.println("log1");
        Product p11 = (Product) session.get(Product.class, 1);
        System.out.println("log2");
        Product p12 = (Product) session.load(Product.class, 2);
        System.out.println("log3");
        System.out.println(p12.getName());
        System.out.println("log4");
        
        /**
         * Hibernate有两种方式获得session,分别是： openSession和getCurrentSession 
         * 他们的区别在于 
         * 1. 获取的是否是同一个session对象 
         * openSession每次都会得到一个新的Session对象 
         * getCurrentSession在同一个线程中，每次都是获取相同的Session对象，但是在不同的线程中获取的是不同的Session对象 
         * 2. 事务提交的必要性 
         * openSession只有在增加，删除，修改的时候需要事务(session.beginTransaction())，查询时不需要的 
         * getCurrentSession是所有操作都必须放在事务中进行，并且提交事务后，session就自动关闭，不能够再进行关闭 
         */
		
        /**
         * N+1
         * Hibernate有缓存机制，可以通过用id作为key把product对象保存在缓存中 
         * 同时hibernate也提供Query的查询方式。假设数据库中有100条记录，其中有30条记录在缓存中，但是使用Query的的list方法，就会所有的100条数据都从数据库中查询，而无视这30条缓存中的记录 
         * N+1是什么意思呢，首先执行一条sql语句，去查询这100条记录，但是，只返回这100条记录的ID 
         * 然后再根据id,进行进一步查询。 
         * 如果id在缓存中，就从缓存中获取product对象了，否则再从数据库中获取
         * 
         * 实现步骤：
         * 首先通过Query的iterator把所有满足条件的Product的id查出来
         * 然后再通过it.next()查询每一个对象
         * 如果这个对象在缓存中，就直接从缓存中取了
         * 否则就从数据库中获取
         * 
         * N+1中的1，就是指只返回id的SQL语句，N指的是如果在缓存中找不到对应的数据，就到数据库中去查
         */
        //String name = "iphone";
        Query q3 =session.createQuery("from Product p where p.name like ?");
        q3.setString(0, "%"+name+"%");
        Iterator<Product> it= q3.iterate();
        while(it.hasNext()){
            Product p =it.next();
            System.out.println(p.getName());
        }
        
        //查询总数
        //String name = "iphone";
        Query q4 =session.createQuery("select count(*) from Product p where p.name like ?");
        q4.setString(0, "%"+name+"%");
        long total= (Long) q4.uniqueResult(); //调用Query对象的uniqueResult()方法，返回一个long型的数据，即查询总数。
        System.out.println(total);
        
        
        
        session.getTransaction().commit();
        session.close();
//		System.out.println("此时p是脱管状态");
		sessionFactory.close();
	}
}
