package mappingHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



	@Entity
	@Table(name="Book")
	public class Book 
	{
		//------------------------------Book Properties-------------------------------//
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String title;
		@Column(name="publisher_name")
		private String publisherName;
		@Column(name="release_year")
		private int releaseYear;
	
		@ManyToOne
		@JoinColumn(name="AUTHOR_ID")
		@Cascade(CascadeType.DETACH)
		private Author author;
		
		public Author getAuthor() {
			return author;
		}
		public void setAuthor(Author auhtor) {
			this.author = auhtor;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPublisherName() {
			return publisherName;
		}
		public void setPublisherName(String publisherName) {
			this.publisherName = publisherName;
		}
		public int getReleaseYear() {
			return releaseYear;
		}
		public void setReleaseYear(int releaseYear) {
			this.releaseYear = releaseYear;
		}
		@Override
		public String toString() {
			return "Book["+id+","+title+","+publisherName+","+releaseYear+","+author.getid()+"]";
		}

	}

