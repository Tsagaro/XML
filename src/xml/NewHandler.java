package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//Θέλω να βάλω τον σκελετό τριών μεθόδων	
//Να χρησιμοποιήσω το hashtable
//Εργασία *, μπορω να φτιάχνω publication και να το αποθυκεύω όπως εδώ με temp και αν δεν το χρειαστώ να το ξεσκαρτάρω
//Να φτιάξω τον πίνακα των authors
//Μια δημοσίευση μπορεί να είναι και 2 ατόμων, πρέπει να βγάλω και για τους δύο . Πχ Χαλκίδη έχει αυτή και ο δουλκερίδης έχει αυτή (Σε περίπτωση που Δούλκερίδης και Χαλκίδη έχουν μαζί)

public class NewHandler extends DefaultHandler
{
	boolean bFoundTitle = false;
	boolean bFoundAuthor = false;
	boolean bFoundEva = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		if (qName.equals("title"))
		{
			bFoundTitle = true;
			if (uri.equals("Eva"))
			{
				bFoundEva = true;
			}
		}

	}

	@Override
	public void characters(char[] ch, int start, int length)
	{
		String temp;
		if (bFoundAuthor)
		{
			temp = new String(ch, start, length);
			if (temp.contains("Eva"))
			{
				bFoundEva = true;
			}
		}
		if (bFoundTitle && bFoundEva)
		{
			temp = new String(ch, start, length);
			System.out.println(temp);
			bFoundEva = false;

		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException
	{
		if (qName.equals("title"))
		{
			bFoundTitle = false;
		}
		if (qName.equals("author"))
		{
			bFoundAuthor = false;
		}

	}
}
