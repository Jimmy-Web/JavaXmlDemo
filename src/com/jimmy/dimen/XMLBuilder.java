package com.jimmy.dimen;

import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

public class XMLBuilder {

	// ������������
	private SAXParserFactory saxParserFactory;
	// ����������
	private SAXParser saxParser;
	// ��ȡ���ݴ�����
	private SaxHandler saxHandler;

	private XMLReader xmlReader;

	public XMLBuilder() {
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

	private void parserXml(File file, int parserStyle) {
		switch (parserStyle) {
		case 0:
			saxParser(file);
			break;
		case 1:
			xmlReader(file);
			break;
		default:
			break;
		}
	}

	/**
	 * ͨ��SAXParser
	 * 
	 * @param file
	 */
	private void saxParser(File file) {
		try {
			saxParser.parse(file, saxHandler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ͨ��XMLReader
	 * 
	 * @param file
	 */
	private void xmlReader(File file) {
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
			xmlReader.parse(new InputSource(new FileInputStream(file)));
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
	}

//	public boolean createXml(String path) {
//		try {
//			// ��������
//			SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
//			TransformerHandler handler = factory.newTransformerHandler();
//			Transformer info = handler.getTransformer();
//			// �Ƿ��Զ���Ӷ���Ŀհ�
//			info.setOutputProperty(OutputKeys.INDENT, "yes");
//			// �����ַ�����
//			info.setOutputProperty(OutputKeys.ENCODING, "utf-8");
//			info.setOutputProperty(OutputKeys.VERSION, "1.0");
//			// ���洴����saxbooks.xml
//			StreamResult result = new StreamResult(
//					new FileOutputStream(new File("src/com/andieguo/saxparserdemo/saxbooks.xml")));
//			handler.setResult(result);
//			// ��ʼxml
//			handler.startDocument();
//			AttributesImpl impl = new AttributesImpl();
//			impl.clear();
//			handler.startElement("", "", "bookstore", impl);
//			for (int i = 0; i < books.size(); i++) {
//				Book book = books.get(i);
//				// ����<book category="xx">
//				impl.clear(); // �������
//				impl.addAttribute("", "", "category", "", book.getCategory());// ΪbookԪ�����category����
//				handler.startElement("", "", "book", impl);
//				// ����<title lang="xx">xx</title>Ԫ��
//				impl.addAttribute("", "", "lang", "", book.getTitleLang());// ΪtitleԪ�����lang����
//				handler.startElement("", "", "title", impl);
//				String title = book.getTitle();
//				handler.characters(title.toCharArray(), 0, title.length()); // ΪtitleԪ������ı�
//				handler.endElement("", "", "title");
//				// ����<author>xx</author>Ԫ��
//				String[] author = book.getAuthor().split("/");
//				for (int j = 0; j < author.length; j++) {
//					impl.clear();
//					handler.startElement("", "", "author", impl);
//					handler.characters(author[j].toCharArray(), 0, author[j].length());
//					handler.endElement("", "", "author");
//				}
//				// ����<year>xx</year>Ԫ��
//				impl.clear();
//				handler.startElement("", "", "year", impl);
//				String year = book.getYear().toString();
//				handler.characters(year.toCharArray(), 0, year.length());
//				handler.endElement("", "", "year");
//				// ����<price>xx</price>Ԫ��
//				impl.clear();
//				handler.startElement("", "", "price", impl);
//				String price = book.getPrice().toString();
//				handler.characters(price.toCharArray(), 0, price.length());
//				handler.endElement("", "", "price");
//				// ����</book>
//				handler.endElement("", "", "book");
//			}
//			// ����</bookstore>
//			handler.endElement("", "", "bookstore");
//			handler.endDocument();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
