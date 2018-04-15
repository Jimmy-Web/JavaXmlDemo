package com.jimmy.parser.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.jimmy.util.Book;

public class SaxHandler extends DefaultHandler {

	private static final String TAG = "SaxHandler---";

	private List<Book> bList = null;
	private Book book = null;
	private boolean bTitle = false;
	private boolean bAuthor = false;
	private boolean bYear = false;
	private boolean bPrice = false;

	public List<Book> getList() {
		return bList;
	}

	public void setList(List<Book> bList) {
		this.bList = bList;
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(TAG + "startDocument...");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(TAG + "endDocument...");
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(TAG + "startElement...");
		System.out.println(TAG + "uri=" + uri);
		System.out.println(TAG + "localName=" + localName);
		System.out.println(TAG + "qName=" + qName);
		if (qName.equalsIgnoreCase("book")) {
			book = new Book();
			String category = attributes.getValue("category");
			book.setCategory(category);
			if (bList == null) {
				bList = new ArrayList<Book>();
			}
		} else if (qName.equalsIgnoreCase("title")) {
			String titleLang = attributes.getValue("lang");
			book.setTitleLang(titleLang);
			bTitle = true;
		} else if (qName.equalsIgnoreCase("author")) {
			bAuthor = true;
		} else if (qName.equalsIgnoreCase("year")) {
			bYear = true;
		} else if (qName.equalsIgnoreCase("price")) {
			bPrice = true;
		}
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		System.out.println(TAG + "endElement...");
		System.out.println(TAG + "uri=" + uri);
		System.out.println(TAG + "localName=" + localName);
		System.out.println(TAG + "qName=" + qName);
		if (qName.equalsIgnoreCase("book")) {
			bList.add(book);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		System.out.println(TAG + "characters...");
		// System.out.println(TAG + "ch生成字符串=" + String.valueOf(ch));
		System.out.println(TAG + "start=" + start);
		System.out.println(TAG + "length" + length);
		if (bTitle) {
			book.setTitle(String.valueOf(ch, start, length));
			// 解析完毕，必须设置为false，防止重复设置Title造成资源浪费
			bTitle = false;
		} else if (bAuthor) {
			if (book.getAuthor() == null) {
				book.setAuthor(new String(ch, start, length));
			} else {
				book.setAuthor(book.getAuthor() + "/" + String.valueOf(ch, start, length));
			}
			bAuthor = false;
		} else if (bYear) {
			book.setYear(Integer.parseInt(String.valueOf(ch, start, length)));
			bYear = false;
		} else if (bPrice) {
			book.setPrice(Double.parseDouble(new String(ch, start, length)));
			bPrice = false;
		}

	}

}
