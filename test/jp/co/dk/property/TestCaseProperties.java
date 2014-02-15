/**
 * 
 */
package jp.co.dk.property;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import jp.co.dk.property.exception.PropertyConversionException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author dk
 *
 */
public class TestCaseProperties {

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
			TestProperty.BOOLEAN_BLANK.getBoolean();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.BOOLEAN_TRUE.getBoolean());
		
		assertFalse(TestProperty.BOOLEAN_FALSE.getBoolean());
		
		try {
			TestProperty.BOOLEAN_ERROR.getBoolean();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.BOOLEAN_DEFALT.getBoolean());
	}

	@Test
	public void getByte() {
		try {
			TestProperty.BYTE_BLANK.getByte();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.BYTE_MIN.getByte() == -128);
		
		assertTrue(TestProperty.BYTE_MAX.getByte() == 127);
		
		try {
			TestProperty.BYTE_ERROR.getByte();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.BYTE_MIN_ERROR.getByte();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.BYTE_MAX_ERROR.getByte();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.BYTE_DEFALT.getByte() == (byte)123);
	}

	@Test
	public void getDouble() {
		try {
			TestProperty.DOUBLE_BLANK.getDouble();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.DOUBLE_MIN.getDouble() == 4.9E-324);
		
		assertTrue(TestProperty.DOUBLE_MAX.getDouble() == 1.7976931348623157E308);
		
		try {
			TestProperty.DOUBLE_ERROR.getDouble();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.DOUBLE_MIN_ERROR.getDouble();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.DOUBLE_MAX_ERROR.getDouble();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.DOUBLE_DEFALT.getDouble() == (double)1.1);
	}

	@Test
	public void getFloat() {
		try {
			TestProperty.FLOAT_BLANK.getFloat();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.FLOAT_MIN.getFloat() == Float.MIN_VALUE);
		
		assertTrue(TestProperty.FLOAT_MAX.getFloat() == Float.MAX_VALUE);
		
		try {
			TestProperty.FLOAT_ERROR.getFloat();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.FLOAT_MIN_ERROR.getFloat();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.FLOAT_MAX_ERROR.getFloat();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.FLOAT_DEFALT.getFloat() == (float)1.1F);
	}

	@Test
	public void getInt() {
		try {
			TestProperty.INT_BLANK.getInt();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.INT_MIN.getInt() == -2147483648);
		
		assertTrue(TestProperty.INT_MAX.getInt() == 2147483647);
		
		try {
			TestProperty.INT_ERROR.getInt();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.INT_MIN_ERROR.getInt();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.INT_MAX_ERROR.getInt();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.INT_DEFALT.getInt() == 123456);
	}

	@Test
	public void getLong() {
		try {
			TestProperty.LONG_BLANK.getLong();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.LONG_MIN.getLong() == -9223372036854775808L);
		
		assertTrue(TestProperty.LONG_MAX.getLong() == 9223372036854775807L);
		
		try {
			TestProperty.LONG_ERROR.getLong();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.LONG_MIN_ERROR.getLong();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.LONG_MAX_ERROR.getLong();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.LONG_DEFALT.getLong() == (long)9223372036854775807L);
	}

	@Test
	public void getShort() {
		try {
			TestProperty.SHORT_BLANK.getShort();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.SHORT_MIN.getShort() == -32768);
		
		assertTrue(TestProperty.SHORT_MAX.getShort() == 32767);
		
		try {
			TestProperty.SHORT_ERROR.getShort();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.SHORT_MIN_ERROR.getShort();
			fail();
		} catch (PropertyConversionException e) {}
		
		try {
			TestProperty.SHORT_MAX_ERROR.getShort();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.SHORT_DEFALT.getShort() == (short)123);
	}

	@Test
	public void getBigDecimal() {
		try {
			TestProperty.BIGDECIMAL_BLANK.getBigDecimal();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.BIGDECIMAL_VALUE.getBigDecimal().equals(new BigDecimal("9999999999999999")));
		
		try {
			TestProperty.BIGDECIMAL_ERROR.getBigDecimal();
			fail();
		} catch (PropertyConversionException e) {}
		
		assertTrue(TestProperty.BIGDECIMAL_DEFALT.getBigDecimal().equals(new BigDecimal("123")));
	}

	@Test
	public void getString() {
		assertTrue(TestProperty.STRING_BLANK.getString().equals(""));
		
		assertTrue(TestProperty.STRING.getString().equals("STRING"));
		
		assertTrue(TestProperty.STRING_DEFALT.getString().equals("aaaa"));
	}
	

}
