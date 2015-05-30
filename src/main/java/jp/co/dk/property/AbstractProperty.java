package jp.co.dk.property;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.configuration.ConversionException;

import jp.co.dk.property.exception.PropertyConversionException;
import jp.co.dk.property.exception.PropertyException;

/**
 * AbstractPropertyは、プロパティを列挙する定数クラスが実装する基底クラスです。<p>
 * <br>
 * 指定されたプロパティキーをもとに、プロパティファイルよりプロパティ値を取得します。<br>
 * <br>
 * プロパティファイルの指定方法<br>
 * <br>
 * プロパティファイルを指定する場合はコンストラクタにパスを指定してください。<br>
 * <br>
 * 省略された場合、このクラスを継承しているクラス名に".properties"が付加された名称のファイルをクラスパスから参照し、使用されます。<br>
 * 例えば、クラス名が"TestProperty"であった場合、クラスパスから"TestProperty.properties"を検索し、使用します。<br>
 * <br>
 * <br>
 * ・プロパティ定義例<br>
 * 実行例、実行結果は以下の通りです。<br>
 * <code>
 * TestProperty.java -----------------------------------------------------------------------<br>
 * <br>
 * public class TestProperty extends AbstractProperty {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;// プロパティ <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;public static final TEST_PROPERTY = new TestProperty("TEST_PROPERTY_01");<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;// コンストラクタ<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;protected ConsoleMessage(String messageId) {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;super(messageId);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;}<br>
 * }<br>
 * ----------------------------------------------------------------------------------------<br>
 * <br>
 * TestProperty.properties -----------------------------------------------------------------<br>
 * <br>
 * # プロパティ設定値<br>
 * TEST_PROPERTY_01=PropertyValue<br>
 * <br>
 * ----------------------------------------------------------------------------------------<br>
 * <br>
 * TestMain.java -----------------------------------------------------------------------<br>
 * <br>
 * public class TestMain {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;public static void main(String args[]) {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(TestProperty.TEST_PROPERTY.getString());<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;}<br>
 * }<br>
 * ----------------------------------------------------------------------------------------<br>
 * <br>
 * 実行結果＝PropertyValue<br>
 * <br>
 * また、プロパティに定義された値を特定のプリミティブ型・プリミティブ型のラッパークラスにて取得することが可能です。<br>
 * 数値を例とした場合、getInt()メソッドを使用することでプロパティ値をint型に変換した値、<br>
 * getInteger()メソッドを使用することでIntegerクラスにて取得することができます。<br>
 * 変換不可能な値が設定されていた場合、org.apache.commons.configuration.ConversionExceptionがthrowされます。<br>
 * <br>
 * また、プロパティファイルにてincludeを使用することができます。<br>
 * プロパティファイルにて<br>
 * <br>
 * include=[ファイルパス]<br>
 * <br>
 * と記載することで他のプロパティファイルに定義されている内容も取得することができます。<br>
 * <br>
 * TestProperty1.properties -----------------------------------------------------------------<br>
 * <br>
 * # プロパティ設定値<br>
 * TEST_PROPERTY_01=PropertyValue01<br>
 * <br>
 * include=./TestProperty2.properties<br>
 * <br>
 * ----------------------------------------------------------------------------------------<br>
 * <br>
 * TestProperty2.properties -----------------------------------------------------------------<br>
 * <br>
 * # プロパティ設定値<br>
 * TEST_PROPERTY_02=PropertyValue02<br>
 * <br>
 * ----------------------------------------------------------------------------------------<br>
 * <br>
 * 上記のように定義されている場合、TestProperty1.propertiesを読み込むことでTestProperty2.propertiesに定義されているプロパティを読み込むことができます。<br>
 * <br>
 * </code> 
 * @version 1.0
 * @author D.Kanno
 */
public abstract class AbstractProperty implements Property {
	
	protected File file;
	
	protected Properties properties;
	
	protected String key;
	
	protected Object defaltValue;
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキーをもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 */
	protected AbstractProperty (String key) throws PropertyException {
		this.file = new File(new StringBuilder(this.getClass().getName().replace('.', '/')).append(".properties").toString());
		this.properties = PropertyFlyweight.getInstance(this.file);
		this.key        = key;
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (String key, boolean defaltValue) throws PropertyException {
		this(key);
		this.defaltValue = Boolean.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (String key, byte defaltValue) throws PropertyException {
		this(key);
		this.defaltValue = Byte.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (String key, double defaltValue) throws PropertyException {
		this(key);
		this.defaltValue = Double.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (String key, float defaltValue) throws PropertyException {
		this(key);
		this.defaltValue = Float.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (String key, int defaltValue) throws PropertyException {
		this(key);
		this.defaltValue = Integer.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (String key, long defaltValue) throws PropertyException {
		this(key);
		this.defaltValue = Long.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (String key, short defaltValue) throws PropertyException {
		this(key);
		this.defaltValue = Short.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (String key, BigDecimal defaltValue) throws PropertyException {
		this(key);
		this.defaltValue = defaltValue;
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (String key, String defaltValue) throws PropertyException {
		this(key);
		this.defaltValue = defaltValue;
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティファイルパス、プロパティキーをもとにプロパティ定数クラスを生成します。
	 * 
	 * @param file プロパティファイルパス
	 * @param key  プロパティキー
	 */
	protected AbstractProperty (File file, String key) throws PropertyException {
		this.properties = PropertyFlyweight.getInstance(file);
		this.file       = file;
		this.key        = key;
	}
	

	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティファイルパス、プロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param file プロパティファイルパス
	 * @param key  プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (File file, String key, boolean defaltValue) throws PropertyException {
		this(file, key);
		this.defaltValue = Boolean.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティファイルパス、プロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param file プロパティファイルパス
	 * @param key  プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (File file, String key, byte defaltValue) throws PropertyException {
		this(file, key);
		this.defaltValue = Byte.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティファイルパス、プロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param file プロパティファイルパス
	 * @param key  プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (File file, String key, double defaltValue) throws PropertyException {
		this(file, key);
		this.defaltValue = Double.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティファイルパス、プロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param file プロパティファイルパス
	 * @param key  プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (File file, String key, float defaltValue) throws PropertyException {
		this(file, key);
		this.defaltValue = Float.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティファイルパス、プロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param file プロパティファイルパス
	 * @param key  プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (File file, String key, int defaltValue) throws PropertyException {
		this(file, key);
		this.defaltValue = Integer.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティファイルパス、プロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param file プロパティファイルパス
	 * @param key  プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (File file, String key, long defaltValue) throws PropertyException {
		this(file, key);
		this.defaltValue = Long.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティファイルパス、プロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param file プロパティファイルパス
	 * @param key  プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (File file, String key, short defaltValue) throws PropertyException {
		this(file, key);
		this.defaltValue = Short.valueOf(defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティファイルパス、プロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param file プロパティファイルパス
	 * @param key  プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (File file, String key, BigDecimal defaltValue) throws PropertyException {
		this(file, key);
		this.defaltValue = defaltValue;
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティファイルパス、プロパティキー、デフォルト値をもとにプロパティ定数クラスを生成します。
	 * 
	 * @param file プロパティファイルパス
	 * @param key  プロパティキー
	 * @param defaltValue デフォルト値
	 */
	protected AbstractProperty (File file, String key, String defaltValue) throws PropertyException {
		this(file, key);
		this.defaltValue = defaltValue;
	}
	
	@Override
	public String getKey() {
		return this.key;
	}
	
	@Override
	public boolean getBoolean() {
		try {
			return this.properties.getBoolean(this.key);
		} catch (ConversionException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Boolean) {
				return ((Boolean) this.defaltValue).booleanValue();
			} else {
				throw new PropertyConversionException(e);
			}
		} catch (NoSuchElementException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Boolean) {
				return ((Boolean) this.defaltValue).booleanValue();
			} else {
				throw new PropertyConversionException(e);
			}
		}
	}

	@Override
	public byte getByte() {
		try {
			return this.properties.getByte(this.key);
		} catch (ConversionException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Byte) {
				return ((Byte) this.defaltValue).byteValue();
			} else {
				throw new PropertyConversionException(e);
			}
		} catch (NoSuchElementException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Byte) {
				return ((Byte) this.defaltValue).byteValue();
			} else {
				throw new PropertyConversionException(e);
			}
		}
	}

	@Override
	public double getDouble() {
		try {
			return this.properties.getDouble(this.key);
		} catch (ConversionException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Double) {
				return ((Double) this.defaltValue).doubleValue();
			} else {
				throw new PropertyConversionException(e);
			}
		} catch (NoSuchElementException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Double) {
				return ((Double) this.defaltValue).doubleValue();
			} else {
				throw new PropertyConversionException(e);
			}
		}
	}

	@Override
	public float getFloat() {
		try {
			return this.properties.getFloat(this.key);
		} catch (ConversionException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Float) {
				return ((Float) this.defaltValue).floatValue();
			} else {
				throw new PropertyConversionException(e);
			}
		} catch (NoSuchElementException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Float) {
				return ((Float) this.defaltValue).floatValue();
			} else {
				throw new PropertyConversionException(e);
			}
		}
	}

	@Override
	public int getInt() {
		try {
			return this.properties.getInt(this.key);
		} catch (ConversionException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Integer) {
				return ((Integer) this.defaltValue).intValue();
			} else {
				throw new PropertyConversionException(e);
			}
		} catch (NoSuchElementException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Integer) {
				return ((Integer) this.defaltValue).intValue();
			} else {
				throw new PropertyConversionException(e);
			}
		}
	}

	@Override
	public long getLong() {
		try {
			return this.properties.getLong(this.key);
		} catch (ConversionException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Long) {
				return ((Long) this.defaltValue).longValue();
			} else {
				throw new PropertyConversionException(e);
			}
		} catch (NoSuchElementException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Long) {
				return ((Long) this.defaltValue).longValue();
			} else {
				throw new PropertyConversionException(e);
			}
		}
	}

	@Override
	public short getShort() {
		try {
			return this.properties.getShort(this.key);
		} catch (ConversionException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Short) {
				return ((Short) this.defaltValue).shortValue();
			} else {
				throw new PropertyConversionException(e);
			}
		} catch (NoSuchElementException e) {
			if (this.defaltValue != null && this.defaltValue instanceof Short) {
				return ((Short) this.defaltValue).shortValue();
			} else {
				throw new PropertyConversionException(e);
			}
		}
	}

	@Override
	public BigDecimal getBigDecimal() {
		try {
			BigDecimal value = this.properties.getBigDecimal(this.key);
			if (value == null && this.defaltValue != null && this.defaltValue instanceof BigDecimal) {
				return new BigDecimal(((BigDecimal)this.defaltValue).toString());
			} else {
				return value;
			}
		} catch (ConversionException e) {
			if (this.defaltValue != null && this.defaltValue instanceof BigDecimal) {
				return new BigDecimal(this.defaltValue.toString());
			} else {
				throw new PropertyConversionException(e);
			}
		} catch (NoSuchElementException e) {
			if (this.defaltValue != null && this.defaltValue instanceof BigDecimal) {
				return new BigDecimal(this.defaltValue.toString());
			} else {
				throw new PropertyConversionException(e);
			}
		}
	}

	@Override
	public String getString() {
		try {
			String value = this.properties.getString(this.key);
			if (value == null && this.defaltValue != null && this.defaltValue instanceof String) {
				return this.defaltValue.toString();
			} else {
				return value;
			}
		} catch (ConversionException e) {
			if (this.defaltValue != null && this.defaltValue instanceof String) {
				return this.defaltValue.toString();
			} else {
				throw new PropertyConversionException(e);
			}
		} catch (NoSuchElementException e) {
			if (this.defaltValue != null && this.defaltValue instanceof String) {
				return this.defaltValue.toString();
			} else {
				throw new PropertyConversionException(e);
			}
		}
	}
	
	public String[] getStringArray() {
		try {
			String values[] = this.properties.getStringArray(this.key);
			if (values == null && this.defaltValue != null && this.defaltValue instanceof String[] ) {
				return (String[])this.defaltValue;
			} else {
				return values;
			}
		} catch (ConversionException e) {
			if (this.defaltValue != null && this.defaltValue instanceof String[]) {
				return (String[])this.defaltValue;
			} else {
				throw new PropertyConversionException(e);
			}
		} catch (NoSuchElementException e) {
			if (this.defaltValue != null && this.defaltValue instanceof String[]) {
				return (String[])this.defaltValue;
			} else {
				throw new PropertyConversionException(e);
			}
		}
	}
	
	@Override
	public java.util.List getList() {
		try {
			java.util.List valueList = this.properties.getList(this.key);
			if (valueList == null && this.defaltValue != null && this.defaltValue instanceof java.util.List) {
				return (java.util.List)this.defaltValue;
			} else {
				return valueList;
			}
		} catch (ConversionException e) {
			if (this.defaltValue != null && this.defaltValue instanceof java.util.List) {
				return (java.util.List)this.defaltValue;
			} else {
				throw new PropertyConversionException(e);
			}
		} catch (NoSuchElementException e) {
			if (this.defaltValue != null && this.defaltValue instanceof java.util.List) {
				return (java.util.List)this.defaltValue;
			} else {
				throw new PropertyConversionException(e);
			}
		}
	}

	@Override
	public java.util.List<Property> getPropertyList(){
		List<Property> propertyList = new ArrayList<Property>();
		List<String> keys = this.properties.getKeys(this.key);
		for (String key : keys) {
			propertyList.add(new TmpProperty(this.file, key, this.key));
		}
		return propertyList;
	}
	
}

class TmpProperty extends AbstractProperty{
	
	private String parentKey;
	
	protected TmpProperty(File propertyFile, String key, String parentKey) throws PropertyException {
		super(propertyFile, key);
		this.parentKey = parentKey;
	}
	
	@Override
	public String getKey() {
		return this.key.replaceAll(this.parentKey, "");
	}
}