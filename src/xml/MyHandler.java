package xml;

import java.util.ArrayList;
import java.util.Hashtable;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

       private Publication publication = new Publication();
       protected Hashtable<String, ArrayList<Publication>> professorsPublications = new Hashtable<String, ArrayList<Publication>>();
       private String temp ;
       
       public MyHandler() {
    	   super();
       }
      
       public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
       {
    	   temp = "";
    	   if (qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings") 
    			   || qName.equalsIgnoreCase("proceedings") || qName.equalsIgnoreCase("book") 
    			   || qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis")
    			   || qName.equalsIgnoreCase("mastersthesis") || qName.equalsIgnoreCase("www")) {
    		   publication = new Publication();
    	   }
       }
       
       public void characters(char[] ch, int start, int length) {
    	   temp = new String(ch, start, length);
       }
      

       public void endElement(String uri, String localName, String qName) throws SAXException 
       {
    	   if (qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings") 
    			   || qName.equalsIgnoreCase("proceedings") || qName.equalsIgnoreCase("book") 
    			   || qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis")
    			   || qName.equalsIgnoreCase("mastersthesis") || qName.equalsIgnoreCase("www")) 
    	   {
    		   for(int i=0; i<publication.getAuthors().size(); i++) {
    			   String authorName = publication.getAuthors().get(i);
    			   if(this.professorsPublications.containsKey(authorName)) {
    				   this.publication.setType(localName);
    				  this.professorsPublications.get(authorName).add(publication);
    			   }
    		   }
    	   }
    	   if(qName.equalsIgnoreCase("author")) {
    		   publication.addAuthor(temp);
    	   }
    	   else if(qName.equalsIgnoreCase("title")) {
    		   publication.setTitle(temp);
           }
    	   else if(qName.equalsIgnoreCase("year")) {
    		   publication.setYear(Short.parseShort(temp));
           } 
    	   else if(qName.equalsIgnoreCase("booktitle")) {
    		   publication.setBooktitle(temp);
    	   }
       }
       
 }




