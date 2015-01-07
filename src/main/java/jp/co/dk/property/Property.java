package jp.co.dk.property;

/**
 * 
 * Propertyは、単一のプロパティを表すクラスが実装するインターフェースです。<p>
 * <br>
 * 
 * @version 1.0
 * @author D.Kanno
 */
public interface Property {
	
	/**
	 * プロパティキーを String 型として取得します。
	 * @return プロパティキー
	 */
	public String getKey();
	
	/**
	 * プロパティ値を boolean 型として取得します。
	 * @return プロパティ値
	 */
	public boolean getBoolean();
	
	/**
	 * プロパティ値を byte 型として取得します。
	 * @return プロパティ値
	 */
	public byte getByte();
	
	/**
	 * プロパティ値を double 型として取得します。
	 * @return プロパティ値
	 */
	public double getDouble();
	
	/**
	 * プロパティ値を float 型として取得します。
	 * @return プロパティ値
	 */
	public float getFloat();
	
	/**
	 * プロパティ値を int 型として取得します。
	 * @return プロパティ値
	 */
	public int getInt();
	
	/**
	 * プロパティ値を long 型として取得します。
	 * @return プロパティ値
	 */
	public long getLong();
	
	/**
	 * プロパティ値を short 型として取得します。
	 * @return プロパティ値
	 */
	public short getShort();
	
	/**
	 * プロパティ値を BigDecimal 型として取得します。
	 * @return プロパティ値
	 */
	public java.math.BigDecimal getBigDecimal();
	
	/**
	 * プロパティ値を String 型として取得します。
	 * @return プロパティ値
	 */
	public java.lang.String getString();
	
	/**
	 * プロパティ値を String 型の配列として取得します。
	 * @return プロパティ値
	 */
	public java.lang.String[] getStringArray();
	
	/**
	 * プロパティ値を List 型として取得します。
	 * @return プロパティ値
	 */
	public java.util.List<String> getList();
	
	/**
	 * プロパティ一覧を List 型にて取得します。
	 * @return プロパティ一覧
	 */
	public java.util.List<Property> getPropertyList();
	
}
