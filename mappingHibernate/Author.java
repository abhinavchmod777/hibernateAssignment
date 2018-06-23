package mappingHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
/*	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}*/
	//---------------------------------toString()------------------------------------------//
	@Override
	public String toString() {
		return "Author [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}
	
}
