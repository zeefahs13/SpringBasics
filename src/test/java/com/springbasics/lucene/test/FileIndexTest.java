package com.springbasics.lucene.test;

import java.io.File;

import com.springbasics.lucene.FileIndexer;
import com.springbasics.lucene.IAbstractLucene;
import com.springbasics.lucene.ILucene;

public class FileIndexTest {
	
	
	
	
	
	public static void main(String[] args) {
		String file = "D:\\DSA\\SpringBasics\\src\\main\\resources\\Lucene2.txt";
		IAbstractLucene luceneFileIndexer = new FileIndexer(true,
				"C:\\Users\\hshaik\\Music\\lucene-8.9.0\\lucene-8.9.0", new File(file));
		luceneFileIndexer.indexFiles();
	}
	
	

}
