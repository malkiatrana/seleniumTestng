package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ConfigWriter {
	public void writeData(String accountType, String value)
	{
		ConfigReader config = new ConfigReader();
	File src = new File("./Configuration/config.property");
	FileInputStream in=null;
	try {
		in = new FileInputStream(src);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Properties props = new Properties();
	try {
		props.load(in);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		in.close();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	FileOutputStream out=null;
	try {
		out = new FileOutputStream(src);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    props.setProperty(accountType, value);
 	try {
		props.store(out, null);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}}