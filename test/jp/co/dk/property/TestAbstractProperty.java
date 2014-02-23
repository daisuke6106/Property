/**
 * 
 */
package jp.co.dk.property;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import jp.co.dk.property.exception.PropertyConversionException;
import jp.co.dk.property.exception.PropertyException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author dk
 *
 */
public class TestAbstractProperty {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void getBoolean() {
		try {
			DummyProperty.BOOLEAN_BLANK.getBoolean();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.BOOLEAN_TRUE.getBoolean());
		
		assertFalse(DummyProperty.BOOLEAN_FALSE.getBoolean());
		
		try {
			DummyProperty.BOOLEAN_ERROR.getBoolean();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.BOOLEAN_DEFALT.getBoolean());
	}

	@Test
	public void getByte() {
		try {
			DummyProperty.BYTE_BLANK.getByte();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.BYTE_MIN.getByte() == -128);
		
		assertTrue(DummyProperty.BYTE_MAX.getByte() == 127);
		
		try {
			DummyProperty.BYTE_ERROR.getByte();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.BYTE_MIN_ERROR.getByte();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.BYTE_MAX_ERROR.getByte();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.BYTE_DEFALT.getByte() == (byte)123);
	}

	@Test
	public void getDouble() {
		try {
			DummyProperty.DOUBLE_BLANK.getDouble();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.DOUBLE_MIN.getDouble() == 4.9E-324);
		
		assertTrue(DummyProperty.DOUBLE_MAX.getDouble() == 1.7976931348623157E308);
		
		try {
			DummyProperty.DOUBLE_ERROR.getDouble();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.DOUBLE_MIN_ERROR.getDouble();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.DOUBLE_MAX_ERROR.getDouble();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.DOUBLE_DEFALT.getDouble() == (double)1.1);
	}

	@Test
	public void getFloat() {
		try {
			DummyProperty.FLOAT_BLANK.getFloat();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.FLOAT_MIN.getFloat() == Float.MIN_VALUE);
		
		assertTrue(DummyProperty.FLOAT_MAX.getFloat() == Float.MAX_VALUE);
		
		try {
			DummyProperty.FLOAT_ERROR.getFloat();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.FLOAT_MIN_ERROR.getFloat();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.FLOAT_MAX_ERROR.getFloat();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.FLOAT_DEFALT.getFloat() == (float)1.1F);
	}

	@Test
	public void getInt() {
		try {
			DummyProperty.INT_BLANK.getInt();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.INT_MIN.getInt() == -2147483648);
		
		assertTrue(DummyProperty.INT_MAX.getInt() == 2147483647);
		
		try {
			DummyProperty.INT_ERROR.getInt();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.INT_MIN_ERROR.getInt();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.INT_MAX_ERROR.getInt();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.INT_DEFALT.getInt() == 123456);
	}

	@Test
	public void getLong() {
		try {
			DummyProperty.LONG_BLANK.getLong();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.LONG_MIN.getLong() == -9223372036854775808L);
		
		assertTrue(DummyProperty.LONG_MAX.getLong() == 9223372036854775807L);
		
		try {
			DummyProperty.LONG_ERROR.getLong();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.LONG_MIN_ERROR.getLong();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.LONG_MAX_ERROR.getLong();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.LONG_DEFALT.getLong() == (long)9223372036854775807L);
	}

	@Test
	public void getShort() {
		try {
			DummyProperty.SHORT_BLANK.getShort();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.SHORT_MIN.getShort() == -32768);
		
		assertTrue(DummyProperty.SHORT_MAX.getShort() == 32767);
		
		try {
			DummyProperty.SHORT_ERROR.getShort();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.SHORT_MIN_ERROR.getShort();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			DummyProperty.SHORT_MAX_ERROR.getShort();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.SHORT_DEFALT.getShort() == (short)123);
	}

	@Test
	public void getBigDecimal() {
		try {
			DummyProperty.BIGDECIMAL_BLANK.getBigDecimal();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.BIGDECIMAL_VALUE.getBigDecimal().equals(new BigDecimal("9999999999999999")));
		
		try {
			DummyProperty.BIGDECIMAL_ERROR.getBigDecimal();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(DummyProperty.BIGDECIMAL_DEFALT.getBigDecimal().equals(new BigDecimal("123")));
	}

	@Test
	public void getString() {
		assertTrue(DummyProperty.STRING_BLANK.getString().equals(""));
		
		assertTrue(DummyProperty.STRING.getString().equals("STRING"));
		
		assertTrue(DummyProperty.STRING_DEFALT.getString().equals("aaaa"));
	}
	

}

class DummyProperty extends AbstractProperty {
	
	public static DummyProperty BOOLEAN_BLANK = new DummyProperty("BOOLEAN_BLANK");
	
	public static DummyProperty BOOLEAN_TRUE = new DummyProperty("BOOLEAN_TRUE");
	
	public static DummyProperty BOOLEAN_FALSE = new DummyProperty("BOOLEAN_FALSE");
	
	public static DummyProperty BOOLEAN_ERROR = new DummyProperty("BOOLEAN_ERROR");
	
	public static DummyProperty BOOLEAN_DEFALT = new DummyProperty("BOOLEAN_ERROR", true);
	
	public static DummyProperty BYTE_BLANK = new DummyProperty("BYTE_BLANK");
	
	public static DummyProperty BYTE_MIN = new DummyProperty("BYTE_MIN");
	
	public static DummyProperty BYTE_MAX = new DummyProperty("BYTE_MAX");
	
	public static DummyProperty BYTE_ERROR = new DummyProperty("BYTE_ERROR");
	
	public static DummyProperty BYTE_MIN_ERROR = new DummyProperty("BYTE_MIN_ERROR");
	
	public static DummyProperty BYTE_MAX_ERROR = new DummyProperty("BYTE_MAX_ERROR");
	
	public static DummyProperty BYTE_DEFALT = new DummyProperty("BYTE_DEFALT", (byte)123);
	
	public static DummyProperty DOUBLE_BLANK = new DummyProperty("DOUBLE_BLANK");
	
	public static DummyProperty DOUBLE_MIN = new DummyProperty("DOUBLE_MIN");
	
	public static DummyProperty DOUBLE_MAX = new DummyProperty("DOUBLE_MAX");
	
	public static DummyProperty DOUBLE_ERROR = new DummyProperty("DOUBLE_ERROR");
	
	public static DummyProperty DOUBLE_MIN_ERROR = new DummyProperty("DOUBLE_MIN_ERROR");
	
	public static DummyProperty DOUBLE_MAX_ERROR = new DummyProperty("DOUBLE_MAX_ERROR");
	
	public static DummyProperty DOUBLE_DEFALT = new DummyProperty("DOUBLE_DEFALT", (double)1.1);
	
	public static DummyProperty FLOAT_BLANK = new DummyProperty("FLOAT_BLANK");
	
	public static DummyProperty FLOAT_MIN = new DummyProperty("FLOAT_MIN");
	
	public static DummyProperty FLOAT_MAX = new DummyProperty("FLOAT_MAX");
	
	public static DummyProperty FLOAT_ERROR = new DummyProperty("FLOAT_ERROR");
	
	public static DummyProperty FLOAT_MIN_ERROR = new DummyProperty("FLOAT_MIN_ERROR");
	
	public static DummyProperty FLOAT_MAX_ERROR = new DummyProperty("FLOAT_MAX_ERROR");
	
	public static DummyProperty FLOAT_DEFALT = new DummyProperty("FLOAT_DEFALT", (float)1.1F);
	
	public static DummyProperty INT_BLANK = new DummyProperty("INT_BLANK");
	
	public static DummyProperty INT_MIN = new DummyProperty("INT_MIN");
	
	public static DummyProperty INT_MAX = new DummyProperty("INT_MAX");
	
	public static DummyProperty INT_ERROR = new DummyProperty("INT_ERROR");
	
	public static DummyProperty INT_MIN_ERROR = new DummyProperty("INT_MIN_ERROR");
	
	public static DummyProperty INT_MAX_ERROR = new DummyProperty("INT_MAX_ERROR");
	
	public static DummyProperty INT_DEFALT = new DummyProperty("INT_DEFALT", (int)123456);
	
	public static DummyProperty LONG_BLANK = new DummyProperty("LONG_BLANK");
	
	public static DummyProperty LONG_MIN = new DummyProperty("LONG_MIN");
	
	public static DummyProperty LONG_MAX = new DummyProperty("LONG_MAX");
	
	public static DummyProperty LONG_ERROR = new DummyProperty("LONG_ERROR");
	
	public static DummyProperty LONG_MIN_ERROR = new DummyProperty("LONG_MIN_ERROR");
	
	public static DummyProperty LONG_MAX_ERROR = new DummyProperty("LONG_MAX_ERROR");
	
	public static DummyProperty LONG_DEFALT = new DummyProperty("LONG_DEFALT", (long)9223372036854775807L);
	
	public static DummyProperty SHORT_BLANK = new DummyProperty("SHORT_BLANK");
	
	public static DummyProperty SHORT_MIN = new DummyProperty("SHORT_MIN");
	
	public static DummyProperty SHORT_MAX = new DummyProperty("SHORT_MAX");
	
	public static DummyProperty SHORT_ERROR = new DummyProperty("SHORT_ERROR");
	
	public static DummyProperty SHORT_MIN_ERROR = new DummyProperty("SHORT_MIN_ERROR");
	
	public static DummyProperty SHORT_MAX_ERROR = new DummyProperty("SHORT_MAX_ERROR");
	
	public static DummyProperty SHORT_DEFALT = new DummyProperty("SHORT_DEFALT", (short)123);
	
	public static DummyProperty BIGDECIMAL_BLANK = new DummyProperty("BIGDECIMAL_BLANK");
	
	public static DummyProperty BIGDECIMAL_MIN = new DummyProperty("BIGDECIMAL_MIN");
	
	public static DummyProperty BIGDECIMAL_VALUE = new DummyProperty("BIGDECIMAL_VALUE");
	
	public static DummyProperty BIGDECIMAL_ERROR = new DummyProperty("BIGDECIMAL_ERROR");
	
	public static DummyProperty BIGDECIMAL_MIN_ERROR = new DummyProperty("BIGDECIMAL_MIN_ERROR");
	
	public static DummyProperty BIGDECIMAL_MAX_ERROR = new DummyProperty("BIGDECIMAL_MAX_ERROR");
	
	public static DummyProperty BIGDECIMAL_DEFALT = new DummyProperty("BIGDECIMAL_DEFALT", new BigDecimal("123"));
	
	public static DummyProperty STRING_BLANK = new DummyProperty("STRING_BLANK");
	
	public static DummyProperty STRING = new DummyProperty("STRING");
	
	public static DummyProperty STRING_DEFALT = new DummyProperty("STRING_DEFALT", "aaaa");
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキーをもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 */
	protected DummyProperty (String key) throws PropertyException {
		super(key);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected DummyProperty (String key, boolean defaltValue) throws PropertyException {
		super(key, defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected DummyProperty (String key, byte defaltValue) throws PropertyException {
		super(key, defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected DummyProperty (String key, double defaltValue) throws PropertyException {
		super(key, defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected DummyProperty (String key, float defaltValue) throws PropertyException {
		super(key, defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected DummyProperty (String key, int defaltValue) throws PropertyException {
		super(key, defaltValue);
	}

	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected DummyProperty (String key, long defaltValue) throws PropertyException {
		super(key, defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected DummyProperty (String key, short defaltValue) throws PropertyException {
		super(key, defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected DummyProperty (String key, BigDecimal defaltValue) throws PropertyException {
		super(key, defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected DummyProperty (String key, String defaltValue) throws PropertyException {
		super(key, defaltValue);
	}
}
