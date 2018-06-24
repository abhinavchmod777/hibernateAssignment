package mappingHibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Author 
{
	//-----------------------------BookAuthor Properties-----------------------------------//
	@Id 
	private int id;
	@Column(name="fname")
	private String fName;
	@Column(name="lname")
	private String lName;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Cascade(CascadeType.DELETE)
	private Collection<Book> books = new ArrayList<Book>();
	

	public Collection<Book> getBooks() {
		return books;
	}
	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	public int getId() {
		return id;
	}
	public int getid() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	@Override
	public String toString() {
		List<Integer> bid = new ArrayList<Integer>();
		for(Book b:books)
			bid.add(b.getId());
		return "Author["+id+","+fName +","+lName+","+bid+"]";
	}
	
	
}
