package com.utlities.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiguration 
{
	Properties pro;
	String path="C:\\Users\\dell\\eclipse-workspace\\DataDrivenFramework\\Configuration\\Datafile.properties";
	public ReadConfiguration()
	{
		FileInputStream fn=null;
		try {
			fn = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pro=new Properties();
		try {
			pro.load(fn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUrl()
	{
		String s1=pro.getProperty("url");
		if(s1!=null)
		{
			return s1;
		}
		else
		{
			throw new RuntimeException("url not found");
		}
	}
	public String getBrowser()
	{
		String s1=pro.getProperty("browser");
		if(s1!=null)
		{
			return s1;
		}
		else
		{
			throw new RuntimeException("getBrowser not found");
		}
	}

}
