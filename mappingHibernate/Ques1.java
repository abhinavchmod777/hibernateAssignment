package mappingHibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings({ "unused", "deprecation" })
public class Ques1 {

	public static void main(String[] args) throws Exception 
	{
		Configuration con= new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Author.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = con.buildSessionFactory(reg);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
//		Scanner s = new Scanner(System.in);
//		Book book = new Book();
//		Author author = new Author();
		Random rand = new Random(); 
		
/**		int i=0;
		System.out.println("Enter table enteries for Book");
		System.out.println("Format for entry : title,publisherName");
		String ch;
		do
		{
			++i;
			System.out.println("enter table entry "+i);
			String details = s.nextLine();
			List<String> values = new ArrayList<String>(Arrays.asList(details.split(","))) ;
			System.out.println(values);
			book.setTitle(values.get(0));
			book.setPublisherName(values.get(1));
			session.save(book);
			System.out.println("enter n to enter next");
			ch = s.nextLine();
		}while(ch.charAt(0)=='n');
		
		
		int j=0;
		System.out.println("Enter table enteries for Author");
		System.out.println("Format for entry : authorName,bookId");
		String ch1;
		do
		{
			++j;
			System.out.println("enter table entry "+i);
			String details = s.nextLine();
			List<String> values = new ArrayList<String>(Arrays.asList(details.split(","))) ;
			author.setId(rand.nextInt(100));
			author.setAuthorName(values.get(0));
			author.setBookId(Integer.parseInt(values.get(1)));
			session.save(author);
			System.out.println("enter n to enter next");
			ch1 = s.nextLine();
		}while(ch1.charAt(0)=='n');
**/		
		int batch = 0;
		session.flush();
		for(int i=1;i<=10;i++)
		{
			Book book= new Book();
			Author author = new Author();
			System.out.println("turn "+i);
			book.setTitle("title"+i);
			book.setPublisherName("publisherName"+i);
			author.setId(rand.nextInt(100));
			author.setBookId(i);
			author.setAuthorName("authorName"+i);
			
			session.save(book);
			session.save(author);
			session.flush();
		}
		transaction.commit();

	}

}
