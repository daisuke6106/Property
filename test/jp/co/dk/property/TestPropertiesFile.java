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
			assertThat(new Boolean(propertyFile.isEmpty()), is (new Boolean(false)));
		} catch (PropertyException e) {
			fail(e);
		}
		
		// ファイル内に値が定義されていなかった場合、trueが返却されること。
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty_Empty.properties");
			assertThat(new Boolean(propertyFile.isEmpty()), is (new Boolean(true)));
		} catch (PropertyException e) {
			fail(e);
		}
	}
	
	@Test
	public void containsKey() {
		
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			
			// ファイル内に値が定義されていた場合、falseが返却されること。
			assertThat(new Boolean(propertyFile.containsKey("STRING")), is (new Boolean(true)));
			
			// ファイル内に部分一致する値が定義されていた場合、falseが返却されること。
			assertThat(new Boolean(propertyFile.containsKey("STR")), is (new Boolean(false)));
						
			// ファイル内に値が定義されていた場合、falseが返却されること。
			assertThat(new Boolean(propertyFile.containsKey("NOTHING")), is (new Boolean(false)));
		} catch (PropertyException e) {
			fail(e);
		}
		
	}
	
	@Test
	public void addProperty() {
		// 存在しないキーを指定した場合、正常に値が登録、取得できること。
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			propertyFile.addProperty("TEST", "test");
			assertEquals(propertyFile.getString("TEST"), "test");
		} catch (PropertyException e) {
			fail(e);
		}
		
		// 存在するキーを指定した場合、登録を行ったとしても無視され、追加した値ではなく定義されている値が返却されること。
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			propertyFile.addProperty("STRING", "test");
			assertEquals(propertyFile.getString("STRING"), "STRING");
		} catch (PropertyException e) {
			fail(e);
		}
	}
	
	@Test
	public void setProperty() {
		// 存在しないキーを指定した場合、正常に値が登録、取得できること。
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			propertyFile.setProperty("TEST", "test");
			assertEquals(propertyFile.getString("TEST"), "test");
		} catch (PropertyException e) {
			fail(e);
		}

		// 存在するキーを指定した場合、設定が上書きされ、設定した値が返却されること。
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			propertyFile.setProperty("STRING", "test");
			assertEquals(propertyFile.getString("STRING"), "test");
		} catch (PropertyException e) {
			fail(e);
		}
	}
	
	@Test
	public void clearProperty() {
		// 存在しないキーを指定した場合でも正常に処理が完了すること、そのキーで取得した場合、NULLが返却されること。
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			propertyFile.clearProperty("NOTHING");
			assertNull(propertyFile.getString("NOTHING"));
		} catch (PropertyException e) {
			fail(e);
		}
		
		// 存在するキーを指定した場合、設定が削除され、取得した場合、NULLが返却されること。
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			propertyFile.clearProperty("STRING");
			assertNull(propertyFile.getString("STRING"));
		} catch (PropertyException e) {
			fail(e);
		}
	}
	
	@Test
	public void clear() {
		// クリアを実施した場合、値はすべて取得できなくなること
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			propertyFile.clear();
			assertThat(new Boolean(propertyFile.isEmpty()), is (new Boolean(true)));
		} catch (PropertyException e) {
			fail(e);
		}
	}
	
	@Test
	public void getProperty() {
		// 存在するプロパティを取得した場合、String型で返却されること。
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			Object stringObject = propertyFile.getProperty("STRING");
			boolean result = stringObject instanceof String;
			assertThat(new Boolean(result), is(new Boolean(true)));
			assertEquals(stringObject.toString(), "STRING");
		} catch (PropertyException e) {
			fail(e);
		}
	}
}
