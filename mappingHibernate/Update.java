package mappingHibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Update
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
//			Query query = session.createQuery("Update Book set author.id=:a where author.id=:id");
//			query.setParameter("a", "103");
//			query.setParameter("id", "102");
//			int n = query.executeUpdate();
			
			Author a = (Author)session.get(Author.class, 107);
			
			Book b = new Book();
			b.setTitle("The mocking Bird");
			b.setPublisherName("Eve");
			b.setReleaseYear(1889);
			b.setAuthor(a);
			session.save(b);

			Query query2 = session.createQuery("update Author set fname=:f, lname=:l where id=:id");
			query2.setParameter("f", "Grave");
			query2.setParameter("l", "King");
			query2.setParameter("id", 101);
			int n=query2.executeUpdate();
			System.out.println("number of records updated = "+n);
			
			
			
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
