package xml;

import java.util.ArrayList;

public class Publication {
	
	private ArrayList<String> authors;
	private String title, booktitle, type;
	private short year;
			
	public Publication() {
		authors = new ArrayList<String>();
		this.title = "-";
		this.booktitle = "-";
		this.type = "";
		this.year = 0000;
	}
	
	public boolean containAuthor(String author) {
		for(int i=0; i<this.authors.size(); i++) {
			if(author.equals(this.authors.get(i))) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<String> getAuthors() {
		return this.authors;
	}
	public void addAuthor(String author) {
		authors.add(author);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}	
	/* Methodos toString()pou orizei tin morfi emfanisis kathe dimosieusis.*/
	public String toString() {
		String temp = "";
		temp+="\t(Type: "+this.getType()+")\n";
		temp+="\t----------------------\n";
		temp+="\tAuthors: \n";
		for(int i=0; i<this.authors.size(); i++) {
			temp+="\t"+new Integer(i+1)+": "+this.authors.get(i)+"\n";
		}
		temp+="\tTitle: "+this.getTitle()+"\n";
		temp+="\tBookTitle: "+this.getBooktitle()+"\n";
		temp+="\tYear: "+this.getYear()+"\n\n";

		return temp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
