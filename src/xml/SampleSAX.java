package xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SampleSAX
{

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
	{
		/*
		 * int i=0; MyBufferedReaderWriter f = new MyBufferedReaderWriter();
		 * f.openRFile("dblp.xml"); String sLine=""; while ((i<10) &&
		 * (sLine=f.readLine()) != null) { System.out.println(sLine); i++; }
		 */

		System.setProperty("entityExpansionLimit", "1000000");

		SAXParserFactory spfac = SAXParserFactory.newInstance();
		spfac.setNamespaceAware(true);

		SAXParser saxparser = spfac.newSAXParser();

		MyHandler handler = new MyHandler();

		InputSource is = new InputSource("books.xml");
		is.setEncoding("ISO-8859-1");
		System.out.println("Please wait...");
		saxparser.parse(is, handler);

		// System.out.println(handler.getProfessors());

		// handler.createHtmlPage();//emfanizei mia html selida me ta
		// apotelesmata
	}
}
