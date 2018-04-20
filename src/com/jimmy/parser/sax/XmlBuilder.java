package com.jimmy.parser.sax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.sql.rowset.spi.XmlReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

import com.jimmy.util.Book;

public class XmlBuilder {

	// ������������
	private SAXParserFactory saxParserFactory;
	// ����������
	private SAXParser saxParser;
	// ��ȡ���ݴ�����
	private SaxHandler saxHandler;

	private XMLReader xmlReader;

	public XmlBuilder() {
		if (saxParserFactory == null) {
			this.saxParserFactory = SAXParserFactory.newInstance();
		}
		if (saxParser == null) {
			try {
				this.saxParser = this.saxParserFactory.newSAXParser();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block	
				e.printStackTrace();
			}
		}
		if (saxHandler == null) {
			this.saxHandler = new SaxHandler();
		}
	}

	public List<Book> parserXml(File file, int parserStyle) {
		List<Book> books = null;
		switch (parserStyle) {
		case 0:
			books = saxParser(file);
			return books;
		case 1:
			books = xmlReader(file);
			return books;
		default:
			break;
		}
		return books;
		
	}

	/**
	 * ͨ��SAXParser
	 * 
	 * @param file
	 */
	private List<Book> saxParser(File file) {
		List<Book> books = null;
		try {
			saxParser.parse(file, saxHandler);
			//��SaxParser����������Xml֮��Ż��������Ĵ�ӡ��䣬Ҳ������������Ż�ִ��...
			System.out.println("��������Xml�����...");
			books = saxHandler.getList();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	/**
	 * ͨ��XMLReader
	 * 
	 * @param file
	 */
	private List<Book> xmlReader(File file) {
		List<Book> books = null;
		//��SAXParser�еõ�һ��XMLReaderʵ��
		if (xmlReader == null) {
			try {
				this.xmlReader = saxParser.getXMLReader();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��SaxHandlerע�ᵽXMLReader�У�һ������Ҫ�ľ���ContentHandler����
		xmlReader.setContentHandler(saxHandler);
		try {
			//InputSource����org.xml.sax���µģ���һ����װһ����Ҫ�����xml�ļ�
			xmlReader.parse(new InputSource(new FileInputStream(file)));
			books = saxHandler.getList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	//����xml
	public boolean createXml(String path,List<Book> books) {
		try {
			// ��������
			SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
			TransformerHandler handler = factory.newTransformerHandler();
			Transformer info = handler.getTransformer();
			// �Ƿ��Զ���Ӷ���Ŀհ�
			info.setOutputProperty(OutputKeys.INDENT, "yes");
			// �����ַ�����
			info.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			info.setOutputProperty(OutputKeys.VERSION, "1.0");
			// ���洴����saxbooks.xml
			StreamResult result = new StreamResult(
					new FileOutputStream(new File(path)));
			handler.setResult(result);
			// ��ʼxml
			handler.startDocument();
			AttributesImpl impl = new AttributesImpl();
			impl.clear();
			handler.startElement("", "", "bookstore", impl);
			for (int i = 0; i < books.size(); i++) {
				Book book = books.get(i);
				// ����<book category="xx">
				impl.clear(); // �������
				impl.addAttribute("", "", "category", "", book.getCategory());// ΪbookԪ�����category����
				handler.startElement("", "", "book", impl);
				// ����<title lang="xx">xx</title>Ԫ��
				impl.addAttribute("", "", "lang", "", book.getTitleLang());// ΪtitleԪ�����lang����
				handler.startElement("", "", "title", impl);
				String title = book.getTitle();
				handler.characters(title.toCharArray(), 0, title.length()); // ΪtitleԪ������ı�
				handler.endElement("", "", "title");
				// ����<author>xx</author>Ԫ��
				String[] author = book.getAuthor().split("/");
				for (int j = 0; j < author.length; j++) {
					impl.clear();
					handler.startElement("", "", "author", impl);
					handler.characters(author[j].toCharArray(), 0, author[j].length());
					handler.endElement("", "", "author");
				}
				// ����<year>xx</year>Ԫ��
				impl.clear();
				handler.startElement("", "", "year", impl);
				String year = book.getYear().toString();
				handler.characters(year.toCharArray(), 0, year.length());
				handler.endElement("", "", "year");
				// ����<price>xx</price>Ԫ��
				impl.clear();
				handler.startElement("", "", "price", impl);
				String price = book.getPrice().toString();
				handler.characters(price.toCharArray(), 0, price.length());
				handler.endElement("", "", "price");
				// ����</book>
				handler.endElement("", "", "book");
			}
			// ����</bookstore>
			handler.endElement("", "", "bookstore");
			handler.endDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
