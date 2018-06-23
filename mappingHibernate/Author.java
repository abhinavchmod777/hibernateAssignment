package mappingHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	// one author can have more than one book written
//	@OneToMany(mappedBy="author")
//	@Cascade(CascadeType.DELETE)	
//	private Set<Book> books = new HashSet<Book>();

	//------------------------------Getters and Setters------------------------------------//
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
//	public Set<Book> getBooks() {
//		return books;
//	}
//	public void setBooks(Set<Book> books) {
//		this.books = books;
//	}
//	//---------------------------------toString()------------------------------------------//
//	@Override
//	public String toString() {
//		return "Author [id=" + id + ", fName=" + fName + ", lName=" + lName + ", books=" + books + "]";
//	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}
	
	
}
