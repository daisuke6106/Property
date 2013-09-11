package jp.co.dk.property;

import java.io.File;
import java.math.BigDecimal;

import jp.co.dk.property.AbstractProperty;
import jp.co.dk.property.exception.PropertyException;

public class TestProperty extends AbstractProperty {
	
	public static TestProperty BOOLEAN_BLANK = new TestProperty("BOOLEAN_BLANK");
	
	public static TestProperty BOOLEAN_TRUE = new TestProperty("BOOLEAN_TRUE");
	
	public static TestProperty BOOLEAN_FALSE = new TestProperty("BOOLEAN_FALSE");
	
	public static TestProperty BOOLEAN_ERROR = new TestProperty("BOOLEAN_ERROR");
	
	public static TestProperty BOOLEAN_DEFALT = new TestProperty("BOOLEAN_ERROR", true);
	
	public static TestProperty BYTE_BLANK = new TestProperty("BYTE_BLANK");
	
	public static TestProperty BYTE_MIN = new TestProperty("BYTE_MIN");
	
	public static TestProperty BYTE_MAX = new TestProperty("BYTE_MAX");
	
	public static TestProperty BYTE_ERROR = new TestProperty("BYTE_ERROR");
	
	public static TestProperty BYTE_MIN_ERROR = new TestProperty("BYTE_MIN_ERROR");
	
	public static TestProperty BYTE_MAX_ERROR = new TestProperty("BYTE_MAX_ERROR");
	
	public static TestProperty BYTE_DEFALT = new TestProperty("BYTE_DEFALT", (byte)123);
	
	public static TestProperty DOUBLE_BLANK = new TestProperty("DOUBLE_BLANK");
	
	public static TestProperty DOUBLE_MIN = new TestProperty("DOUBLE_MIN");
	
	public static TestProperty DOUBLE_MAX = new TestProperty("DOUBLE_MAX");
	
	public static TestProperty DOUBLE_ERROR = new TestProperty("DOUBLE_ERROR");
	
	public static TestProperty DOUBLE_MIN_ERROR = new TestProperty("DOUBLE_MIN_ERROR");
	
	public static TestProperty DOUBLE_MAX_ERROR = new TestProperty("DOUBLE_MAX_ERROR");
	
	public static TestProperty DOUBLE_DEFALT = new TestProperty("DOUBLE_DEFALT", (double)1.1);
	
	public static TestProperty FLOAT_BLANK = new TestProperty("FLOAT_BLANK");
	
	public static TestProperty FLOAT_MIN = new TestProperty("FLOAT_MIN");
	
	public static TestProperty FLOAT_MAX = new TestProperty("FLOAT_MAX");
	
	public static TestProperty FLOAT_ERROR = new TestProperty("FLOAT_ERROR");
	
	public static TestProperty FLOAT_MIN_ERROR = new TestProperty("FLOAT_MIN_ERROR");
	
	public static TestProperty FLOAT_MAX_ERROR = new TestProperty("FLOAT_MAX_ERROR");
	
	public static TestProperty FLOAT_DEFALT = new TestProperty("FLOAT_DEFALT", (float)1.1F);
	
	public static TestProperty INT_BLANK = new TestProperty("INT_BLANK");
	
	public static TestProperty INT_MIN = new TestProperty("INT_MIN");
	
	public static TestProperty INT_MAX = new TestProperty("INT_MAX");
	
	public static TestProperty INT_ERROR = new TestProperty("INT_ERROR");
	
	public static TestProperty INT_MIN_ERROR = new TestProperty("INT_MIN_ERROR");
	
	public static TestProperty INT_MAX_ERROR = new TestProperty("INT_MAX_ERROR");
	
	public static TestProperty INT_DEFALT = new TestProperty("INT_DEFALT", (int)123456);
	
	public static TestProperty LONG_BLANK = new TestProperty("LONG_BLANK");
	
	public static TestProperty LONG_MIN = new TestProperty("LONG_MIN");
	
	public static TestProperty LONG_MAX = new TestProperty("LONG_MAX");
	
	public static TestProperty LONG_ERROR = new TestProperty("LONG_ERROR");
	
	public static TestProperty LONG_MIN_ERROR = new TestProperty("LONG_MIN_ERROR");
	
	public static TestProperty LONG_MAX_ERROR = new TestProperty("LONG_MAX_ERROR");
	
	public static TestProperty LONG_DEFALT = new TestProperty("LONG_DEFALT", (long)9223372036854775807L);
	
	public static TestProperty SHORT_BLANK = new TestProperty("SHORT_BLANK");
	
	public static TestProperty SHORT_MIN = new TestProperty("SHORT_MIN");
	
	public static TestProperty SHORT_MAX = new TestProperty("SHORT_MAX");
	
	public static TestProperty SHORT_ERROR = new TestProperty("SHORT_ERROR");
	
	public static TestProperty SHORT_MIN_ERROR = new TestProperty("SHORT_MIN_ERROR");
	
	public static TestProperty SHORT_MAX_ERROR = new TestProperty("SHORT_MAX_ERROR");
	
	public static TestProperty SHORT_DEFALT = new TestProperty("SHORT_DEFALT", (short)123);
	
	public static TestProperty BIGDECIMAL_BLANK = new TestProperty("BIGDECIMAL_BLANK");
	
	public static TestProperty BIGDECIMAL_MIN = new TestProperty("BIGDECIMAL_MIN");
	
	public static TestProperty BIGDECIMAL_VALUE = new TestProperty("BIGDECIMAL_VALUE");
	
	public static TestProperty BIGDECIMAL_ERROR = new TestProperty("BIGDECIMAL_ERROR");
	
	public static TestProperty BIGDECIMAL_MIN_ERROR = new TestProperty("BIGDECIMAL_MIN_ERROR");
	
	public static TestProperty BIGDECIMAL_MAX_ERROR = new TestProperty("BIGDECIMAL_MAX_ERROR");
	
	public static TestProperty BIGDECIMAL_DEFALT = new TestProperty("BIGDECIMAL_DEFALT", new BigDecimal("123"));
	
	public static TestProperty STRING_BLANK = new TestProperty("STRING_BLANK");
	
	public static TestProperty STRING = new TestProperty("STRING");
	
	public static TestProperty STRING_DEFALT = new TestProperty("STRING_DEFALT", "aaaa");
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキーをもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 */
	protected TestProperty (String key) throws PropertyException {
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
	protected TestProperty (String key, boolean defaltValue) throws PropertyException {
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
	protected TestProperty (String key, byte defaltValue) throws PropertyException {
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
	protected TestProperty (String key, double defaltValue) throws PropertyException {
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
	protected TestProperty (String key, float defaltValue) throws PropertyException {
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
	protected TestProperty (String key, int defaltValue) throws PropertyException {
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
	protected TestProperty (String key, long defaltValue) throws PropertyException {
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
	protected TestProperty (String key, short defaltValue) throws PropertyException {
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
	protected TestProperty (String key, BigDecimal defaltValue) throws PropertyException {
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
	protected TestProperty (String key, String defaltValue) throws PropertyException {
		super(key, defaltValue);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティファイルパス、プロパティキーをもとにプロパティ定数クラスを生成します。
	 * 
	 * @param file プロパティファイルパス
	 * @param key  プロパティキー
	 */
	protected TestProperty (File file, String key) throws PropertyException {
		super(file, key);
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
	protected TestProperty (File file, String key, boolean defaltValue) throws PropertyException {
		super(file, key, defaltValue);
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
	protected TestProperty (File file, String key, byte defaltValue) throws PropertyException {
		super(file, key, defaltValue);
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
	protected TestProperty (File file, String key, double defaltValue) throws PropertyException {
		super(file, key, defaltValue);
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
	protected TestProperty (File file, String key, float defaltValue) throws PropertyException {
		super(file, key, defaltValue);
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
	protected TestProperty (File file, String key, int defaltValue) throws PropertyException {
		super(file, key, defaltValue);
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
	protected TestProperty (File file, String key, long defaltValue) throws PropertyException {
		super(file, key, defaltValue);
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
	protected TestProperty (File file, String key, short defaltValue) throws PropertyException {
		super(file, key, defaltValue);
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
	protected TestProperty (File file, String key, BigDecimal defaltValue) throws PropertyException {
		super(file, key, defaltValue);
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
	protected TestProperty (File file, String key, String defaltValue) throws PropertyException {
		super(file, key, defaltValue);
	}
}
