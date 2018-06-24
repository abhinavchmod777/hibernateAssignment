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
		

//---------------------------------Author Entries-------------------------------------------------//		
		
		Author author1 = new Author();
		author1.setId(101);
		author1.setfName("Chetan");
		author1.setlName("Bhagat");
 
		Author author2 = new Author();
		author2.setId(102);
		author2.setfName("SB");
		author2.setlName("Navathe");
		 
//------------------------------Address Entries-----------------------------------------------------//
		Address ad1 = new Address();
		ad1.setHouseNo(2);
		ad1.setCity("faridabad");
		ad1.setStreet("Enclave 3");
		ad1.setPinCode(110023);
		ad1.setState("Delhi");

		Address ad2 = new Address();
		ad2.setHouseNo(202);
		ad2.setCity("Ghaziabad");
		ad2.setStreet("Shakti khand");
		ad2.setPinCode(201023);
		ad2.setState("UP");

		Address ad3 = new Address();
		ad3.setHouseNo(102);
		ad3.setCity("faridabad");
		ad3.setStreet("Gyan Khand");
		ad3.setPinCode(330023);
		ad3.setState("Delhi");

		Address ad4 = new Address();
		ad4.setHouseNo(2);
		ad4.setCity("Bareilly");
		ad4.setStreet("Saudagran");
		ad4.setPinCode(243001);
		ad4.setState("UP");

		Address ad5 = new Address();
		ad5.setHouseNo(324);
		ad5.setCity("Gurugram");
		ad5.setStreet("Anamika Enclave");
		ad5.setPinCode(110343);
		ad5.setState("Harayana");
		
	//------------------------mapping address
		author1.getAddressList().add(ad4);
		author1.getAddressList().add(ad1);
		author1.getAddressList().add(ad2);
		author2.getAddressList().add(ad3);
		author2.getAddressList().add(ad5);
		
	//-------------saving objects
		try 
		{
			transaction = session.beginTransaction();
			session.save(author1);
			session.save(author2);
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
