package me.sachingupta.database;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mukund on 19-Jun-20.
 */
// This is a Database Handler Class which has methods to perform all the database operations.
// Example of creating Employee Database.  DB<Employee> employeedb=new DB("Employee",Employee.class);
public class DB<T> {
    private final Class val;
    private Configuration config;
	private String tablename;
	
    public DB(String tablename,Class val){
        this.val=val;
		this.tablename=tablename;
        config=new Configuration().configure("hibernate.cfg.xml");
        config.addAnnotatedClass(val);
    }
    //generic Insert method for all class.
    //Example: db.insert(new Employee("2","Sachin G","9876","abc@abc.com","Developer","","","","","","","","","",""));
    public void insert(T value){
        SessionFactory sessionfactory=config.buildSessionFactory();
        Session session=sessionfactory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(value);
        tx.commit();
        session.close();
    }

 //Example:   List<Employee> list=db.retrieveAll();
    public List<T> retrieveAll() {
        SessionFactory sessionfactory=config.buildSessionFactory();
        Session session=sessionfactory.openSession();
        Transaction tx=session.beginTransaction();
        if(!tablename.isEmpty()){
        return session.createQuery("from "+tablename).list();
        }
     return null;
    }


    public List<T> retrieveColumns(String ...columns) {
        String columnnames=null;
        SessionFactory sessionfactory=config.buildSessionFactory();
        Session session=sessionfactory.openSession();
        Transaction tx=session.beginTransaction();
        if(!tablename.isEmpty()){
            columnnames= Arrays.toString(columns).replace('[','\0').replace(']','\0').trim();
            return session.createQuery("Select "+columnnames+" from "+tablename).list();
        }
        return null;
    }
	
	public void update(T value){
        SessionFactory sessionfactory=config.buildSessionFactory();
        Session session=sessionfactory.openSession();
        Transaction tx=session.beginTransaction();
        session.update(value);
        tx.commit();
        session.close();
    }
	
		public void delete(T value){
        SessionFactory sessionfactory=config.buildSessionFactory();
        Session session=sessionfactory.openSession();
        Transaction tx=session.beginTransaction();
        session.delete(value);
        tx.commit();
        session.close();
    }

    public List<T> criteriaBasedRetrieval(SimpleExpression[] restrictions, Order[] orders, Projection[] projections){
        SessionFactory sessionfactory=config.buildSessionFactory();
        Session session=sessionfactory.openSession();
        Criteria cr = session.createCriteria(val);

        for (SimpleExpression restriction:restrictions) {
            cr.add(restriction);
        }
        for (Order order:orders){
            cr.addOrder(order);
        }
        for (Projection projection:projections){
            cr.setProjection(projection);
        }
        return cr.list();
    }

    public List<T> criteriaAndOrderBasedRetrieval(SimpleExpression[] restrictions, Order[] orders){
        SessionFactory sessionfactory=config.buildSessionFactory();
        Session session=sessionfactory.openSession();
        Criteria cr = session.createCriteria(val);
        if(restrictions!=null)
        for (SimpleExpression restriction:restrictions) {
            System.out.println(restriction.getPropertyName()+"="+restriction.getValue());
            cr.add(restriction);
        }
        if(orders!=null)
        for (Order order:orders){
            cr.addOrder(order);
        }
        return cr.list();
    }
    public List<T> projectionBasedRetrieval(Projection[] projections){
        SessionFactory sessionfactory=config.buildSessionFactory();
        Session session=sessionfactory.openSession();
        Criteria cr = session.createCriteria(val);
        for (Projection projection:projections){
            cr.setProjection(projection);
        }
        return cr.list();
    }

}
