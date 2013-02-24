package jp.co.dk.property;

import java.util.Iterator;

/**
 * 
 * Propertiesは、プロパティへの操作を行うクラスが実装するインターフェースです。<p>
 * <br>
 * 
 * @version 1.0
 * @author D.Kanno
 */
public interface Properties {
	
	/**
	 * プロパティに何も定義されていない場合、trueを返します。
	 * 
	 * @return プロパティ定義有無
	 */
	public boolean isEmpty();
	
	/**
	 * 指定のプロパティキーが定義されているかを検証します。<br>
	 * プロパティが定義されている場合、trueを返却します。
	 * 
	 * @param key プロパティキー
	 * @return プロパティキー定義の有無
	 */
	public boolean containsKey(java.lang.String key);
	
	/**
	 * 指定のプロパティキーにてプロパティ値を追加します。<br>
	 * 
	 * @param key プロパティキー
	 * @param value プロパティ値
	 */
	public void addProperty(java.lang.String key, java.lang.Object value);
	
	/**
	 * 指定のプロパティキーにてプロパティ値を設定します。<br>
	 * 
	 * @param key プロパティキー
	 * @param value プロパティ値
	 */
	public void setProperty(java.lang.String key, java.lang.Object value);
	
	/**
	 * 指定のプロパティキーを削除します。<br>
	 * 
	 * @param key プロパティキー
	 */
	public void clearProperty(java.lang.String key);
	
	/**
	 * 定義されているプロパティをすべて削除します。<br>
	 */
	public void clear();
	
	/**
	 * 指定のプロパティキーを削除します。<br>
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値
	 */
	public Object getProperty(String key);
	
	/**
	 * 指定のプロパティキーで始まるプロパティキー一覧を取得します。<br>
	 * 
	 * @param key プロパティキー
	 * @return プロパティキー一覧
	 */
	public Iterator<String> getKeys(String key);
	
	/**
	 * 定義されているすべてのプロパティキー一覧を取得します。<br>
	 * 
	 * @return プロパティキー一覧
	 */
	public Iterator<String> getKeys();
	
	/**
	 * 定義されているすべてのプロパティキー一覧を取得します。<br>
	 * 
	 * @param key プロパティキー
	 * @return プロパティキー一覧
	 */
	public java.util.Properties getProperties(String key);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を boolean 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値
	 */
	public boolean getBoolean(String key);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を boolean 型で取得します。<br>
	 * 存在しない場合は指定されたデフォルト値を取得します。
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public boolean getBoolean(String key, boolean defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を Boolean クラスで取得します。<br>
	 * 存在しない場合は指定されたデフォルト値を取得します。
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public Boolean getBoolean(String key, Boolean defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を byte 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値
	 */
	public byte getByte(String key);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を byte 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public byte getByte(String key, byte defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を Boolean クラスで取得します。<br>
	 * 存在しない場合は指定されたデフォルト値を取得します。
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public Byte getByte(String key, Byte defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を double 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値
	 */
	public double getDouble(String key);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を double 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public double getDouble(String key, double defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を Boolean クラスで取得します。<br>
	 * 存在しない場合は指定されたデフォルト値を取得します。
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public Double getDouble(String key, Double defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を float 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値
	 */
	public float getFloat(String key);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を float 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public float getFloat(String key, float defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を Boolean クラスで取得します。<br>
	 * 存在しない場合は指定されたデフォルト値を取得します。
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public Float getFloat(String key, Float defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を int 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値
	 */
	public int getInt(String key);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を int 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public int getInt(String key, int defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を Integer クラスで取得します。<br>
	 * 存在しない場合は指定されたデフォルト値を取得します。
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public Integer getInteger(String key, Integer defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を long 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値
	 */
	public long getLong(String key);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を long 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public long getLong(String key, long defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を Long クラスで取得します。<br>
	 * 存在しない場合は指定されたデフォルト値を取得します。
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public Long getLong(String key, Long defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を short 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値
	 */
	public short getShort(String key);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を short 型で取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public short getShort(String key, short defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を Short クラスで取得します。<br>
	 * 存在しない場合は指定されたデフォルト値を取得します。
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public Short getShort(String key, Short defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を BigDecimal クラスで取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値
	 */
	public java.math.BigDecimal getBigDecimal(String key);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を BigDecimal クラスで取得します。<br>
	 * 存在しない場合は指定されたデフォルト値を取得します。
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public java.math.BigDecimal getBigDecimal(String key, java.math.BigDecimal defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を BigInteger クラスで取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値
	 */
	public java.math.BigInteger getBigInteger(String key);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を BigInteger クラスで取得します。<br>
	 * 存在しない場合は指定されたデフォルト値を取得します。
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public java.math.BigInteger getBigInteger(String key, java.math.BigInteger defaltValue);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を String クラスで取得します。<br>
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値
	 */
	public String getString(String key);
	
	/**
	 * 指定のプロパティキーで定義されているプロパティ値を String クラスで取得します。<br>
	 * 存在しない場合は指定されたデフォルト値を取得します。
	 * 
	 * プロパティに設定された値が変換できない値の場合は、例外を返却します。
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値
	 * @return プロパティ値
	 */
	public String getString(String key, String defaltValue);
	
	/**
	 * 指定したプロパティキーに関連付けられた文字列の配列を取得します。<br>
	 * キーは既存のオブジェクトにマップされない場合は空の配列が返されます。<br>
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値一覧
	 */
	public String[] getStringArray(String key);
	
	/**
	 * 指定したプロパティキーに関連付けられた文字列のリストを取得します。<br>
	 * キーは既存のオブジェクトにマップされない場合は、空リストが返されます。<br>
	 * 
	 * @param key プロパティキー
	 * @return プロパティ値一覧
	 */
	public java.util.List getList(String key);
	
	/**
	 * 指定したプロパティキーに関連付けられた文字列のリストを取得します。<br>
	 * キーは既存のオブジェクトにマップされない場合は、指定されたデフォルトのリストが返されます。<br>
	 * 
	 * @param key プロパティキー
	 * @param defaltValue デフォルトのプロパティ値一覧
	 * @return プロパティ値一覧
	 */
	public java.util.List getList(String key, java.util.List defaltValue);
	
}
