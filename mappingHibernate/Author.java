package mappingHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author 
{
	//-----------------------------BookAuthor Properties-----------------------------------//
	@Id
	private int id;
	@Column(name="book_id")
	private int bookId;
	@Column(name="author_name")
	private String authorName;

	//------------------------------Getters and Setters------------------------------------//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	//---------------------------------toString()------------------------------------------//
	@Override
	public String toString() {
		return "BookAuthor [bookId=" + bookId + ", authorName=" + authorName + "]";
	}
	
}
