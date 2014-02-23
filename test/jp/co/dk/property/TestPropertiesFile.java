package jp.co.dk.property;

import jp.co.dk.property.exception.PropertyException;
import jp.co.dk.test.template.TestCaseTemplate;

import org.junit.Test;

public class TestPropertiesFile extends TestCaseTemplate{

	@Test
	public void constractor() {
		// NULLを渡した場合、例外が発生すること
		try {
			PropertiesFile propertyFile = new PropertiesFile(null);
			fail();
		} catch (PropertyException e) {
			assertEquals(e.getMessage(), "Property File was not found.file=null");
		}
		
		// 空文字を渡した場合、例外が発生すること
		try {
			PropertiesFile propertyFile = new PropertiesFile("");
			fail();
		} catch (PropertyException e) {
			assertEquals(e.getMessage(), "Property File was not found.file=");
		}
		
		// 存在しないファイル名を指定した場合、例外が発生すること
		try {
			PropertiesFile propertyFile = new PropertiesFile("Dummy.property");
			fail();
		} catch (PropertyException e) {
			assertEquals(e.getMessage(), "Property File was not found.file=Dummy.property");
		}
		
		// 存在しないファイル名を指定した場合、例外が発生すること
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			assertEquals(propertyFile.propertyFile, "jp/co/dk/property/DummyProperty.properties");
			assertNotNull(propertyFile.configure);
		} catch (PropertyException e) {
			fail(e);
		}
	}
	
	@Test
	public void isEmpty() {
		// ファイル内に値が定義されていた場合、falseが返却されること。
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			assertThat(propertyFile.isEmpty(), is (false));
		} catch (PropertyException e) {
			fail(e);
		}
		
		// ファイル内に値が定義されていなかった場合、trueが返却されること。
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty_Empty.properties");
			assertThat(propertyFile.isEmpty(), is (true));
		} catch (PropertyException e) {
			fail(e);
		}
	}
	
	@Test
	public void containsKey() {
		
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			
			// ファイル内に値が定義されていた場合、falseが返却されること。
			assertThat(propertyFile.containsKey("STRING"), is (true));
			
			// ファイル内に部分一致する値が定義されていた場合、falseが返却されること。
			assertThat(propertyFile.containsKey("STR"), is (false));
						
			// ファイル内に値が定義されていた場合、falseが返却されること。
			assertThat(propertyFile.containsKey("NOTHING"), is (false));
		} catch (PropertyException e) {
			fail(e);
		}
		
	}

}
