package jp.co.dk.property;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.co.dk.property.exception.PropertyException;
import jp.co.dk.test.template.TestCaseTemplate;

import org.junit.Test;

public class PropertiesFileTest extends TestCaseTemplate{
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
		
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			
			// 存在するプロパティを取得した場合、String型で返却されること。
			Object stringObject = propertyFile.getProperty("STRING");
			assertThat(new Boolean(stringObject instanceof String), is(new Boolean(true)));
			assertEquals(stringObject.toString(), "STRING");
			
			// 存在するプロパティを取得した場合、String型で返却されること。
			// 数値のみ定義されている場合でもString型で取得できること
			Object integerObject = propertyFile.getProperty("INT_MAX");
			assertThat(new Boolean(integerObject instanceof String), is(new Boolean(true)));
			assertEquals(integerObject.toString(), "2147483647");
			
		} catch (PropertyException e) {
			fail(e);
		}
	}
	
	@Test
	public void getKeys() {
		
		try {
			PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
			
			// STRINGで取得した場合、完全一致するキーと、STRINGではじまるキーを取得できること。
			List<String> keys = propertyFile.getKeys("STRING");
			assertThat(new Boolean(keys.contains("STRING")), is(new Boolean(true)));
			assertThat(new Boolean(keys.contains("STRING_BLANK")), is(new Boolean(true)));
			assertThat(new Integer(keys.size()), is (new Integer(2)));
			
			// 存在しないキーを指定した場合空のリストを返却されること
			List<String> brankkeys = propertyFile.getKeys("NOTHING");
			assertThat(new Integer(brankkeys.size()), is (new Integer(0)));
			
			// 引数を取得しなかった場合、すべてのキーを取得できること。
			// 重複するキーは除外されること。
			assertThat(new Integer(propertyFile.getKeys().size()), is(new Integer(49)));
		} catch (PropertyException e) {
			fail(e);
		}
	}
	
	@Test
	public void getBoolean() {
		PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
		
		// キーが定義されていなかった場合、例外が送出されること
		try {
			propertyFile.getBoolean("NOTHING");
			fail();
		} catch (java.util.NoSuchElementException e) {
			assertThat(e.getMessage(), is("'NOTHING' doesn't map to an existing object"));
		}
		
		// キーが定義されていなかった場合、デフォルトが返却されること
		assertThat(new Boolean(propertyFile.getBoolean("NOTHING", true)), is (new Boolean(true)));
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getBoolean("BOOLEAN_BLANK");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BOOLEAN_BLANK' doesn't map to a Boolean object"));
		}
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getBoolean("BOOLEAN_BLANK", true);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BOOLEAN_BLANK' doesn't map to a Boolean object"));
		}
				
		// trueと定義されていた場合、trueが返却されること
		assertThat(new Boolean(propertyFile.getBoolean("BOOLEAN_TRUE")), is (new Boolean(true)));
		// falseと定義されていた場合、falseが返却されること
		assertThat(new Boolean(propertyFile.getBoolean("BOOLEAN_FALSE")), is (new Boolean(false)));
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getBoolean("BOOLEAN_ERROR");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BOOLEAN_ERROR' doesn't map to a Boolean object"));
		}
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getBoolean("BOOLEAN_ERROR", true);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BOOLEAN_ERROR' doesn't map to a Boolean object"));
		}
	}
	
	@Test
	public void getByte() {
		PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
		
		// キーが定義されていなかった場合、例外が送出されること
		try {
			propertyFile.getByte("NOTHING");
			fail();
		} catch (java.util.NoSuchElementException e) {
			assertThat(e.getMessage(), is("'NOTHING doesn't map to an existing object"));
		}
		
		// キーが定義されていなかった場合、デフォルトが返却されること
		assertThat(new Byte(propertyFile.getByte("NOTHING", (byte)127)), is (new Byte((byte)127)));
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getByte("BYTE_BLANK");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BYTE_BLANK' doesn't map to a Byte object"));
		}
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getByte("BYTE_BLANK", (byte)127);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BYTE_BLANK' doesn't map to a Byte object"));
		}
				
		// trueと定義されていた場合、trueが返却されること
		assertThat(new Byte(propertyFile.getByte("BYTE_MIN")), is (new Byte((byte)-128)));
		// falseと定義されていた場合、falseが返却されること
		assertThat(new Byte(propertyFile.getByte("BYTE_MAX")), is (new Byte((byte)127)));
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getByte("BYTE_ERROR");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BYTE_ERROR' doesn't map to a Byte object"));
		}
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getByte("BYTE_ERROR", (byte)127);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BYTE_ERROR' doesn't map to a Byte object"));
		}
	}
	
	@Test
	public void getDouble() {
		PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
		
		// キーが定義されていなかった場合、例外が送出されること
		try {
			propertyFile.getDouble("NOTHING");
			fail();
		} catch (java.util.NoSuchElementException e) {
			assertThat(e.getMessage(), is("'NOTHING' doesn't map to an existing object"));
		}
		
		// キーが定義されていなかった場合、デフォルトが返却されること
		assertThat(new Double(propertyFile.getDouble("NOTHING", (double)1.7976931348623157E308)), is (new Double((double)1.7976931348623157E308)));
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getDouble("DOUBLE_BLANK");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'DOUBLE_BLANK' doesn't map to a Double object"));
		}
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getDouble("DOUBLE_BLANK", (double)1.7976931348623157E308);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'DOUBLE_BLANK' doesn't map to a Double object"));
		}
				
		// 値が定義されていた場合、その値が返却されること
		assertThat(new Double(propertyFile.getDouble("DOUBLE_MIN")), is (new Double((double)4.9E-324)));
		assertThat(new Double(propertyFile.getDouble("DOUBLE_MAX")), is (new Double((double)1.7976931348623157E308)));
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getDouble("DOUBLE_ERROR");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'DOUBLE_ERROR' doesn't map to a Double object"));
		}
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getDouble("DOUBLE_ERROR", (double)4.9E-324);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'DOUBLE_ERROR' doesn't map to a Double object"));
		}
	}
	
	@Test
	public void getFloat() {
		PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
		
		// キーが定義されていなかった場合、例外が送出されること
		try {
			propertyFile.getFloat("NOTHING");
			fail();
		} catch (java.util.NoSuchElementException e) {
			assertThat(e.getMessage(), is("'NOTHING' doesn't map to an existing object"));
		}
		
		// キーが定義されていなかった場合、デフォルトが返却されること
		assertThat(new Float(propertyFile.getFloat("NOTHING", (float)3.4028235E38)), is (new Float((float)3.4028235E38)));
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getFloat("FLOAT_BLANK");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'FLOAT_BLANK' doesn't map to a Float object"));
		}
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getFloat("FLOAT_BLANK", (float)3.4028235E38);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'FLOAT_BLANK' doesn't map to a Float object"));
		}
				
		// 値が定義されていた場合、その値が返却されること
		assertThat(new Float(propertyFile.getFloat("FLOAT_MIN")), is (new Float((float)1.4E-45)));
		assertThat(new Float(propertyFile.getFloat("FLOAT_MAX")), is (new Float((float)3.4028235E38)));
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getFloat("FLOAT_ERROR");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'FLOAT_ERROR' doesn't map to a Float object"));
		}
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getFloat("FLOAT_ERROR", (float)4.9E-324);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'FLOAT_ERROR' doesn't map to a Float object"));
		}
	}
	
	@Test
	public void getInt() {
		PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
		
		// キーが定義されていなかった場合、例外が送出されること
		try {
			propertyFile.getInt("NOTHING");
			fail();
		} catch (java.util.NoSuchElementException e) {
			assertThat(e.getMessage(), is("'NOTHING' doesn't map to an existing object"));
		}
		
		// キーが定義されていなかった場合、デフォルトが返却されること
		assertThat(new Integer(propertyFile.getInt("NOTHING", 2147483647)), is (new Integer(2147483647)));
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getInt("INT_BLANK");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'INT_BLANK' doesn't map to an Integer object"));
		}
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getInt("INT_BLANK", 2147483647);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'INT_BLANK' doesn't map to an Integer object"));
		}
				
		// 値が定義されていた場合、その値が返却されること
		assertThat(new Integer(propertyFile.getInt("INT_MIN")), is (new Integer(-2147483648)));
		assertThat(new Integer(propertyFile.getInt("INT_MAX")), is (new Integer(2147483647)));
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getInt("INT_ERROR");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'INT_ERROR' doesn't map to an Integer object"));
		}
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getInt("INT_ERROR", 2147483647);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'INT_ERROR' doesn't map to an Integer object"));
		}
	}
	
	@Test
	public void getLong() {
		PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
		
		// キーが定義されていなかった場合、例外が送出されること
		try {
			propertyFile.getLong("NOTHING");
			fail();
		} catch (java.util.NoSuchElementException e) {
			assertThat(e.getMessage(), is("'NOTHING' doesn't map to an existing object"));
		}
		
		// キーが定義されていなかった場合、デフォルトが返却されること
		assertThat(new Long(propertyFile.getLong("NOTHING", 9223372036854775807L)), is (new Long(9223372036854775807L)));
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getLong("LONG_BLANK");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'LONG_BLANK' doesn't map to a Long object"));
		}
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getLong("LONG_BLANK", 9223372036854775807L);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'LONG_BLANK' doesn't map to a Long object"));
		}
				
		// 値が定義されていた場合、その値が返却されること
		assertThat(new Long(propertyFile.getLong("LONG_MIN")), is (new Long(-9223372036854775808L)));
		assertThat(new Long(propertyFile.getLong("LONG_MAX")), is (new Long(9223372036854775807L)));
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getLong("LONG_ERROR");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'LONG_ERROR' doesn't map to a Long object"));
		}// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getByte("BYTE_ERROR");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BYTE_ERROR' doesn't map to a Byte object"));
		}
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getLong("LONG_ERROR", 9223372036854775807L);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'LONG_ERROR' doesn't map to a Long object"));
		}
	}
	
	@Test
	public void getShort() {
		PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
		
		// キーが定義されていなかった場合、例外が送出されること
		try {
			propertyFile.getShort("NOTHING");
			fail();
		} catch (java.util.NoSuchElementException e) {
			assertThat(e.getMessage(), is("'NOTHING' doesn't map to an existing object"));
		}
		
		// キーが定義されていなかった場合、デフォルトが返却されること
		assertThat(new Short(propertyFile.getShort("NOTHING", (short)32767)), is (new Short((short)32767)));
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getShort("SHORT_BLANK");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'SHORT_BLANK' doesn't map to a Short object"));
		}
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getShort("SHORT_BLANK", (short)32767);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'SHORT_BLANK' doesn't map to a Short object"));
		}
				
		// 値が定義されていた場合、その値が返却されること
		assertThat(new Short(propertyFile.getShort("SHORT_MIN")), is (new Short((short)-32768)));
		assertThat(new Short(propertyFile.getShort("SHORT_MAX")), is (new Short((short)32767)));
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getShort("SHORT_ERROR");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'SHORT_ERROR' doesn't map to a Short object"));
		}
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getShort("SHORT_ERROR", (short)32767);
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'SHORT_ERROR' doesn't map to a Short object"));
		}
	}
	
	@Test
	public void getBigDecimal() {
		PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
		
		// キーが定義されていなかった場合、例外が送出されること
		try {
			propertyFile.getBigDecimal("NOTHING");
			fail();
		} catch (java.util.NoSuchElementException e) {
			assertThat(e.getMessage(), is("'NOTHING' doesn't map to an existing object"));
		}
		
		// キーが定義されていなかった場合、デフォルトが返却されること
		assertThat(propertyFile.getBigDecimal("NOTHING", new BigDecimal("9999999999999999")), is (new BigDecimal("9999999999999999")));
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getBigDecimal("BIGDECIMAL_BLANK");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BIGDECIMAL_BLANK' doesn't map to a BigDecimal object"));
		}
		
		// キーは定義されているが値が設定されていなかった場合、例外が送出されること
		try {
			propertyFile.getBigDecimal("BIGDECIMAL_BLANK", new BigDecimal("9999999999999999"));
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BIGDECIMAL_BLANK' doesn't map to a BigDecimal object"));
		}
				
		// 値が定義されていた場合、その値が返却されること
		assertThat(propertyFile.getBigDecimal("BIGDECIMAL_VALUE"), is (new BigDecimal("9999999999999999")));
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getBigDecimal("BIGDECIMAL_ERROR");
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BIGDECIMAL_ERROR' doesn't map to a BigDecimal object"));
		}
		
		// キーは定義されているが値がbooleanでなかった場合、例外が送出されること
		try {
			propertyFile.getBigDecimal("BIGDECIMAL_ERROR", new BigDecimal("9999999999999999"));
			fail();
		} catch (org.apache.commons.configuration.ConversionException e) {
			assertThat(e.getMessage(), is("'BIGDECIMAL_ERROR' doesn't map to a BigDecimal object"));
		}
	}
	
	@Test
	public void getString() {
		PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
		
		// キーが定義されていなかった場合、NULLが送出されること
		assertNull(propertyFile.getString("NOTHING"));
		
		// キーが定義されていなかった場合、デフォルトが返却されること
		assertThat(propertyFile.getString("NOTHING", new String("TEST")), is (new String("TEST")));
		
		// キーは定義されているが値が設定されていなかった場合、空文字が送出されること
		assertThat(propertyFile.getString("STRING_BLANK"), is(""));
		
		// キーは定義されているが値が設定されていなかった場合、空文字が送出されること
		assertThat(propertyFile.getString("STRING_BLANK", new String("TEST")), is (new String("")));
		
		// 値が定義されていた場合、その値が返却されること
		assertThat(propertyFile.getString("STRING"), is (new String("STRING")));
		
	}
	
	@Test
	public void getStringArray() {
		PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
		
		// キーが定義されていなかった場合、空の配列が返却されること
		String[] nothing = propertyFile.getStringArray("NOTHING");
		assertNotNull(nothing);
		assertThat(new Integer(nothing.length), is(new Integer(0)));
		
		
		// キーは定義されているが値が設定されていなかった場合、空文字が送出されること
		String[] blank = propertyFile.getStringArray("ARRAYSTRING_BLANK");
		assertNotNull(blank);
		assertThat(new Integer(blank.length), is(new Integer(1)));
		assertThat(blank[0], is(""));
		
		// 
		String[] values_one = propertyFile.getStringArray("ARRAYSTRING_ONE");
		assertNotNull(values_one);
		assertThat(new Integer(values_one.length), is(new Integer(1)));
		assertThat(values_one[0], is("value1"));
		
		String[] values_two = propertyFile.getStringArray("ARRAYSTRING_TWO");
		assertNotNull(values_two);
		assertThat(new Integer(values_two.length), is(new Integer(2)));
		assertThat(values_two[0], is("value1"));
		assertThat(values_two[1], is("value2"));
	}
	
	@Test
	public void getList() {
		PropertiesFile propertyFile = new PropertiesFile("jp/co/dk/property/DummyProperty.properties");
		
		// デフォルトのリストを定義する
		List<String> defaultList = new ArrayList<String>();
		defaultList.add("dummy");
		
		// キーが定義されていなかった場合、空の配列が返却されること
		java.util.List nothing = propertyFile.getList("NOTHING");
		assertNotNull(nothing);
		assertThat(new Integer(nothing.size()), is(new Integer(0)));
		
		// キーが定義されていなかった場合、デフォルトのリストが取得されること
		java.util.List nothingWithDefault = propertyFile.getList("NOTHING",defaultList);
		assertNotNull(nothingWithDefault);
		assertThat(new Integer(nothingWithDefault.size()), is(new Integer(1)));
		assertThat((String)nothingWithDefault.get(0), is("dummy"));
		
		// キーは定義されているが値が設定されていなかった場合、空の配列が送出されること
		java.util.List blank = propertyFile.getList("ARRAYSTRING_BLANK");
		assertNotNull(blank);
		assertThat(new Integer(blank.size()), is(new Integer(1)));
		assertThat((String)blank.get(0), is(""));
		
		java.util.List blankWithDefault = propertyFile.getList("ARRAYSTRING_BLANK",defaultList);
		assertNotNull(blankWithDefault);
		assertThat(new Integer(blankWithDefault.size()), is(new Integer(1)));
		assertThat((String)blankWithDefault.get(0), is(""));
		
		java.util.List values_one = propertyFile.getList("ARRAYSTRING_ONE");
		assertNotNull(values_one);
		assertThat(new Integer(values_one.size()), is(new Integer(1)));
		assertThat((String)values_one.get(0), is("value1"));
		
		java.util.List values_two = propertyFile.getList("ARRAYSTRING_TWO");
		assertNotNull(values_two);
		assertThat(new Integer(values_two.size()), is(new Integer(2)));
		assertThat((String)values_two.get(0), is("value1"));
		assertThat((String)values_two.get(1), is("value2"));
		
		
	}
}
