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

	//-------updating book object author id i.e foreign key------------//
			Query query = session.createQuery("Update Book set AUTHOR_ID=:a where AUTHOR_ID=:id");
			query.setParameter("a", "103");
			query.setParameter("id", "102");
			query.executeUpdate();
			System.out.println("1st done");
			
	//----------adding new record to book--------------//		
			Author a = (Author)session.get(Author.class, 102);
			Book b = new Book();
			b.setTitle("The mocking Bird");
			b.setPublisherName("Eve");
			b.setReleaseYear(1889);
			b.setAuthor(a);
			session.save(b);
			System.out.println("2nd done");
	
	//----------------updating author object first and last name-------------//		
			Query query2 = session.createQuery("update Author set fname=:f, lname=:l where id=:id");
			query2.setParameter("f", "Grave");
			query2.setParameter("l", "King");
			query2.setParameter("id", 101);
			query2.executeUpdate();
			System.out.println("3rd done");
			
	//---------------updating author object id i.e. primary key--------------------------------//
			Query q4 = session.createQuery("update Book set AUTHOR_ID=:id1 where AUTHOR_ID=:id2");
			q4.setParameter("id1", null);
			q4.setParameter("id2", 108);
			q4.executeUpdate();
			Query q3 = session.createQuery("update Author set id=:id1 where id=:id2");
			q3.setParameter("id1", 111);
			q3.setParameter("id2", 108);
			q3.executeUpdate();
			System.out.println("4th done");
	
	//--------------updating book object id i.e. primary key------------------------------------//
			Query q6 = session.createQuery("update Book set id=:id1 where id=:id2");
			q6.setParameter("id1",15);
			q6.setParameter("id2",1);
			q6.executeUpdate();
			System.out.println("5th done");
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
