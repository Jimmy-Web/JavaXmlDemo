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

	// 创建解析工厂
	private SAXParserFactory saxParserFactory;
	// 创建解析器
	private SAXParser saxParser;
	// 获取内容处理器
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
	 * 通过SAXParser
	 * 
	 * @param file
	 */
	private List<Book> saxParser(File file) {
		List<Book> books = null;
		try {
			saxParser.parse(file, saxHandler);
			//在SaxParser解析完整个Xml之后才会调用下面的打印语句，也就是下面的语句才会执行...
			System.out.println("解析整个Xml完成了...");
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
	 * 通过XMLReader
	 * 
	 * @param file
	 */
	private List<Book> xmlReader(File file) {
		List<Book> books = null;
		//从SAXParser中得到一个XMLReader实例
		if (xmlReader == null) {
			try {
				this.xmlReader = saxParser.getXMLReader();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//把SaxHandler注册到XMLReader中，一般最重要的就是ContentHandler方法
		xmlReader.setContentHandler(saxHandler);
		try {
			//InputSource类是org.xml.sax包下的，进一步封装一下需要处理的xml文件
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

	//创建xml
	public boolean createXml(String path,List<Book> books) {
		try {
			// 创建工厂
			SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
			TransformerHandler handler = factory.newTransformerHandler();
			Transformer info = handler.getTransformer();
			// 是否自动添加额外的空白
			info.setOutputProperty(OutputKeys.INDENT, "yes");
			// 设置字符编码
			info.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			info.setOutputProperty(OutputKeys.VERSION, "1.0");
			// 保存创建的saxbooks.xml
			StreamResult result = new StreamResult(
					new FileOutputStream(new File(path)));
			handler.setResult(result);
			// 开始xml
			handler.startDocument();
			AttributesImpl impl = new AttributesImpl();
			impl.clear();
			handler.startElement("", "", "bookstore", impl);
			for (int i = 0; i < books.size(); i++) {
				Book book = books.get(i);
				// 生成<book category="xx">
				impl.clear(); // 清空属性
				impl.addAttribute("", "", "category", "", book.getCategory());// 为book元素添加category属性
				handler.startElement("", "", "book", impl);
				// 生成<title lang="xx">xx</title>元素
				impl.addAttribute("", "", "lang", "", book.getTitleLang());// 为title元素添加lang属性
				handler.startElement("", "", "title", impl);
				String title = book.getTitle();
				handler.characters(title.toCharArray(), 0, title.length()); // 为title元素添加文本
				handler.endElement("", "", "title");
				// 生成<author>xx</author>元素
				String[] author = book.getAuthor().split("/");
				for (int j = 0; j < author.length; j++) {
					impl.clear();
					handler.startElement("", "", "author", impl);
					handler.characters(author[j].toCharArray(), 0, author[j].length());
					handler.endElement("", "", "author");
				}
				// 生成<year>xx</year>元素
				impl.clear();
				handler.startElement("", "", "year", impl);
				String year = book.getYear().toString();
				handler.characters(year.toCharArray(), 0, year.length());
				handler.endElement("", "", "year");
				// 生成<price>xx</price>元素
				impl.clear();
				handler.startElement("", "", "price", impl);
				String price = book.getPrice().toString();
				handler.characters(price.toCharArray(), 0, price.length());
				handler.endElement("", "", "price");
				// 生成</book>
				handler.endElement("", "", "book");
			}
			// 生成</bookstore>
			handler.endElement("", "", "bookstore");
			handler.endDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
