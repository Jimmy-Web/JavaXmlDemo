package com.jimmy.dimen;

import java.io.File;
import java.util.List;

public class run {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Book> books = xmlReader(new File("src/com/andieguo/saxparserdemo/books.xml")); 
		XmlBuilder xmlBuilder = new XmlBuilder();
		xmlBuilder.parserXml(new File("resources/books.xml"),Constant.SAXPARSER);  
	}

}
