package mappingHibernate;

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
		Transaction transaction = session.beginTransaction();

//----------------------------------book entries----------------------------------//		
		Book book1 = new Book();
		book1.setTitle("Harnessing Hibernate");
		book1.setPublisherName("Orielly");
		book1.setReleaseYear(2014);
		session.save(book1);
		
		Book book2 = new Book();
		book2.setTitle("Operating System Concepts");
		book2.setPublisherName("McGrawHill");
		book2.setReleaseYear(2001);
		session.save(book2);
		
		Book book3 = new Book();
		book3.setTitle("Mathematics Advanced");
		book3.setPublisherName("Evergreen");
		book3.setReleaseYear(1989);
		session.save(book3);
		
		Book book4 = new Book();
		book4.setTitle("Java The Complete Reference");
		book4.setPublisherName("Orielly");
		book4.setReleaseYear(2004);
		session.save(book4);
		
		Book book5 = new Book();
		book5.setTitle("DataBase Concepts");
		book5.setPublisherName("Arihant");
		book5.setReleaseYear(2008);
		session.save(book5);

		Book book6 = new Book();
		book6.setTitle("Programming with Java");
		book6.setPublisherName("McGraw Hill");
		book6.setReleaseYear(2002);
		session.save(book6);

		Book book7 = new Book();
		book7.setTitle("C++ The Complete Reference");
		book7.setPublisherName("McGraw Hill");
		book7.setReleaseYear(1998);
		session.save(book7);

		Book book8 = new Book();
		book8.setTitle("Operating System Concepts");
		book8.setPublisherName("Wiley");
		book8.setReleaseYear(2002);
		session.save(book8);

		Book book9 = new Book();
		book9.setTitle("Data Communication and Networking");
		book9.setPublisherName("McGraw Hill");
		book9.setReleaseYear(1993);
		session.save(book9);

		Book book10 = new Book();
		book10.setTitle("HeadFirst JavaScript");
		book10.setPublisherName("Orielly");
		book10.setReleaseYear(2005);
		session.save(book10);

//---------------------------------Author Entries-------------------------------------------------//		
		
		Author author1 = new Author();
		author1.setId(101);
		author1.setfName("Chetan");
		author1.setlName("Bhagat");
//		author1.setBook(book4);
		session.save(author1);
 
		Author author2 = new Author();
		author2.setId(102);
		author2.setfName("RD");
		author2.setlName("Sharma");
//		author2.setBook(book3);
		session.save(author2);
		 
		Author author3 = new Author();
		author3.setId(103);
		author3.setfName("SB");
		author3.setlName("Navathe");
//		author3.setBook(book5);
		session.save(author3);
		 
		Author author4 = new Author();
		author4.setId(104);
		author4.setfName("Grave");
		author4.setlName("King");
//		author4.setBook(book1);
		session.save(author4);
		 
		Author author5 = new Author();
		author5.setId(105);
		author5.setfName("Ramez");
		author5.setlName("Elamarsi");
//		author5.setBook(book2);
		session.save(author5);
		
		Author author6 = new Author();
		author6.setId(106);
		author6.setfName("E");
		author6.setlName("Balaguruswamy");
//		author6.setBook(book7);
		session.save(author6);
		
		Author author7 = new Author();
		author7.setId(107);
		author7.setfName("Abraham");
		author7.setlName("Silberschatz");
//		author7.setBook(book6);
		session.save(author7);
		
		Author author8 = new Author();
		author8.setId(108);
		author8.setfName("Peter");
		author8.setlName("Galvin");
//		author8.setBook(book8);
		session.save(author8);
		
		Author author9 = new Author();
		author9.setId(109);
		author9.setfName("Behrouz");
		author9.setlName("Furouzan");
//		author9.setBook(book10);
		session.save(author9);
		
		Author author10 = new Author();
		author10.setId(110);
		author10.setfName("Greg");
		author10.setlName("Gange");
//		author10.setBook(book9);
		session.save(author10);

//-------------------------------closing transaction session----------------------//		
		transaction.commit();
		session.close();
		sessionFactory.close();
	
	}

}