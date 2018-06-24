package mappingHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Create 
{

	public static void main(String[] args) 
	{
		
//---------------------------opening transaction session--------------------------//		
		Configuration con= new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Author.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = con.buildSessionFactory(reg);
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
		
//----------------------------------book entries----------------------------------//		
		Book book1 = new Book();
		book1.setTitle("Harnessing Hibernate");
		book1.setPublisherName("Orielly");
		book1.setReleaseYear(2014);
		
		Book book2 = new Book();
		book2.setTitle("Operating System Concepts");
		book2.setPublisherName("McGrawHill");
		book2.setReleaseYear(2001);
		
		Book book3 = new Book();
		book3.setTitle("Mathematics Advanced");
		book3.setPublisherName("Evergreen");
		book3.setReleaseYear(1989);
		
		Book book4 = new Book();
		book4.setTitle("Java The Complete Reference");
		book4.setPublisherName("Orielly");
		book4.setReleaseYear(2004);
		
		Book book5 = new Book();
		book5.setTitle("DataBase Concepts");
		book5.setPublisherName("Arihant");
		book5.setReleaseYear(2008);

		Book book6 = new Book();
		book6.setTitle("Programming with Java");
		book6.setPublisherName("McGraw Hill");
		book6.setReleaseYear(2002);

		Book book7 = new Book();
		book7.setTitle("C++ The Complete Reference");
		book7.setPublisherName("McGraw Hill");
		book7.setReleaseYear(1998);

		Book book8 = new Book();
		book8.setTitle("Operating System Concepts");
		book8.setPublisherName("Wiley");
		book8.setReleaseYear(2002);

		Book book9 = new Book();
		book9.setTitle("Data Communication and Networking");
		book9.setPublisherName("McGraw Hill");
		book9.setReleaseYear(1993);

		Book book10 = new Book();
		book10.setTitle("HeadFirst JavaScript");
		book10.setPublisherName("Orielly");
		book10.setReleaseYear(2005);

//---------------------------------Author Entries-------------------------------------------------//		
		
		Author author1 = new Author();
		author1.setId(101);
		author1.setfName("Chetan");
		author1.setlName("Bhagat");
 
		Author author2 = new Author();
		author2.setId(102);
		author2.setfName("RD");
		author2.setlName("Sharma");
		 
		Author author3 = new Author();
		author3.setId(103);
		author3.setfName("SB");
		author3.setlName("Navathe");
		 
		Author author4 = new Author();
		author4.setId(104);
		author4.setfName("Grave");
		author4.setlName("King");
		 
		Author author5 = new Author();
		author5.setId(105);
		author5.setfName("Ramez");
		author5.setlName("Elamarsi");
		
		Author author6 = new Author();
		author6.setId(106);
		author6.setfName("E");
		author6.setlName("Balaguruswamy");
		
		Author author7 = new Author();
		author7.setId(107);
		author7.setfName("Abraham");
		author7.setlName("Silberschatz");
		
		Author author8 = new Author();
		author8.setId(108);
		author8.setfName("Peter");
		author8.setlName("Galvin");
		
		Author author9 = new Author();
		author9.setId(109);
		author9.setfName("Behrouz");
		author9.setlName("Furouzan");
		
		Author author10 = new Author();
		author10.setId(110);
		author10.setfName("Greg");
		author10.setlName("Gange");

//--------applying one to many mapping bidirectional
//		book1.setAuthor(author10);
//		book2.setAuthor(author10);
		author10.getBooks().add(book1);
		author10.getBooks().add(book2);
//		book3.setAuthor(author8);
//		book4.setAuthor(author8);
		author8.getBooks().add(book3);
		author8.getBooks().add(book4);
//		book5.setAuthor(author7);
		author7.getBooks().add(book5);
//		book6.setAuthor(author4);
		author4.getBooks().add(book6);
//		book7.setAuthor(author5);
		author5.getBooks().add(book7);
//		book8.setAuthor(author1);
		author1.getBooks().add(book8);
//		book9.setAuthor(author2);
		author2.getBooks().add(book9);
//		book10.setAuthor(author3);
		author3.getBooks().add(book10);

//-------------saving objects
		try 
		{
			transaction = session.beginTransaction();
			session.save(author1);
			session.save(author2);
			session.save(author3);
			session.save(author4);
			session.save(author5);
			session.save(author6);
			session.save(author7);
			session.save(author8);
			session.save(author9);
			session.save(author10);
			session.save(book1);
			session.save(book2);
			session.save(book3);
			session.save(book4);
			session.save(book5);
			session.save(book6);
			session.save(book7);
			session.save(book8);
			session.save(book9);
			session.save(book10);
			transaction.commit();
			
		}
		catch(HibernateException e)
		{
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
//-------------------------------closing transaction session----------------------//		
		session.close();
		sessionFactory.close();
		}
	}

}
