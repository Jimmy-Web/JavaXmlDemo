package com.jimmy.dimen;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
	
	private static final String TAG = "SaxHandler---";
	
	private List<Book> list = null;
	private Book book = null;
	private boolean bTitle = false;  
    private boolean bAuthor = false;  
    private boolean bYear = false;  
    private boolean bPrice = false;
    
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
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
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(TAG + "endElement...");
		System.out.println(TAG + "uri=" + uri);
		System.out.println(TAG + "localName=" + localName);
		System.out.println(TAG + "qName=" + qName);
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(TAG + "characters...");
//		System.out.println(TAG + "chÉú³É×Ö·û´®=" + String.valueOf(ch));
		System.out.println(TAG + "start=" + start);
		System.out.println(TAG + "length" + length); 		
		super.characters(ch, start, length);
	}  
    
	
    
	
	

}
