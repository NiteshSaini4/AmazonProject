package com.testcase.com;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageobject.com.LogOutClass;
import com.pageobject.com.LoginClass;
import com.utlities.com.DataDrivernTesting;

public class TestCase extends BaseClass
{
	@Test(dataProvider = "DataPro")
	void login(String user,String pass)
	{
		l.info("open url");
		driver.get(url);
		LoginClass lc=new LoginClass(driver);
		l.info("Enter username");
		lc.user_Name(user);
		l.info("Enter pass");
		lc.user_Pass(pass);
		l.info("Click on submit button");
		lc.user_Sub();
		//LogOutClass lc1=new LogOutClass(driver);
		//lc1.user_logOut();
	}
	@DataProvider(name="DataPro")    
	public String[][]getDataPro() throws Exception
	{
		String filename="C:\\Users\\dell\\Desktop\\framedata.xlsx";
		int row=DataDrivernTesting.getRow(filename, "Sheet1");
		int col=DataDrivernTesting.getCol(filename, "Sheet1");
		String s1[][]=new String[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				 s1[i][j]=DataDrivernTesting.getcellData(filename, "Sheet1", i, j);
			}
		}
		return s1;
	}

}
//testng.xml,pom.xml,cmd,batch,jenkins.......
//B
