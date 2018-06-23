package mappingHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Delete 
{
	public static void main(String[] args) 
	{
		//---------------------------opening transaction session--------------------------//		

		Configuration con= new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Author.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = con.buildSessionFactory(reg);
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try 
		{
			transaction=session.beginTransaction();
			
			Query query1 = session.createQuery("delete from Book where publisherName='Orielly'" );
			int n = query1.executeUpdate();
			System.out.println("number of Book Record deleted = "+n);
			
			Query query2 = session.createQuery("delete from Author");
			int m = query2.executeUpdate();
			System.out.println("number of Book Record deleted = "+m);

			transaction.commit();
		}
		catch(HibernateException e)
		{
			transaction.rollback();
			e.printStackTrace();
		}
		finally
		{
			//-------------------------------closing transaction session----------------------//		
			session.close();
			sessionFactory.close();				
			
		}
		
	}

}
