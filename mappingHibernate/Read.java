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

public class Read 
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
			
//			Book b = (Book)session.get(Book.class, 1);
//			System.out.println(b);
//			
//			Author a = (Author)session.get(Author.class,101);
//			System.out.println(a);
//			System.out.println(a.getBooks());
			
		//-----------------------obtaining all Book table records---------------------------//	
			Query query1 = session.createQuery("from Book");
			List<Book> books = (List<Book>)query1.list();

		//------------------------obtaining all Author table records-------------------------//
			Query query2 = session.createQuery("from Author");
			List<Author> authors = (List<Author>)query2.list();
		
		//-----------------------------printing Books---------------------------------------//
			Iterator<Book> it = books.iterator();
			while(it.hasNext())
			{
				Book book = it.next();
				System.out.println(book);
			}
		//----------------------------printing Authors--------------------------------------//	
			Iterator<Author> it2 = authors.iterator();
			while(it2.hasNext())
			{
				Author author = it2.next();
				System.out.println(author);
			}
			
			transaction.commit();
		}
		catch(Exception e)
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
