package mappingHibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

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
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(joinColumns=@JoinColumn(name="AUTHOR_ID"),inverseJoinColumns=@JoinColumn(name="BOOK_ID"))
	
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
		return "Author [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}
	
	
}
