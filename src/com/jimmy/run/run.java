package com.jimmy.run;

import java.io.File;
import java.util.List;

import com.jimmy.parser.sax.XmlBuilder;
import com.jimmy.ui.AndroidDimenBuilder;
import com.jimmy.ui.Calculator;
import com.jimmy.util.Book;
import com.jimmy.util.Constant;

public class run {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Book> books = xmlReader(new File("src/com/andieguo/saxparserdemo/books.xml")); 
//		XmlBuilder xmlBuilder = new XmlBuilder();
//		File xmlFile = new File("resources/books.xml");
//		List<Book> books = xmlBuilder.parserXml(xmlFile,Constant.SAXPARSER); 
//		if(books!=null) {
//			for (Book book : books) {  
//	            System.out.println(book.toString());  
//	        }  
//		}else {
//			System.out.println("获取到的List<Book>为空");
//		}
//		
//		xmlBuilder.createXml("",books);
		AndroidDimenBuilder calculator = new AndroidDimenBuilder();
		
	}

}
