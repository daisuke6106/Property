package jp.co.dk.property;

import java.util.Iterator;

import jp.co.dk.property.exception.PropertyException;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * 
 * PropertiesFileは、プロパティファイルを表すクラスです。<p>
 * <br>
 * Configurationを保持しており、プロパティキーに紐づくプロパティ値の取得などプロパティファイルに対しての操作を行います。<br>
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class PropertiesFile implements Properties{
	
	protected String propertyFile;
	
	protected Configuration configure;
	
	/**
	 * コンストラクタ<p>
	 * <br>
	 * 指定のプロパティファイルにてインスタンスを生成します。
	 * 
	 * @param propertyFile プロパティファイルパス
	 * @throws PropertyException 指定のプロパティファイルパスにファイルが存在しなかった場合
	 */
	public PropertiesFile(String propertyFile) throws PropertyException{
		this.propertyFile = propertyFile;
		try {
			this.configure = new PropertiesConfiguration(propertyFile);
		} catch (ConfigurationException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Property File was not found.");
			sb.append("file=").append(this.propertyFile);
			throw new PropertyException(sb.toString(), e);
		}
	}
	
	@Override
	public boolean isEmpty() {
		return this.configure.isEmpty();
	}
	
	@Override
	public boolean containsKey(java.lang.String key) {
		return this.configure.containsKey(key);
	}
	
	@Override
	public void addProperty(java.lang.String key, java.lang.Object value) {
		this.configure.addProperty(key, value);
	}
	
	@Override
	public void setProperty(java.lang.String key, java.lang.Object value) {
		this.configure.setProperty(key, value);
	}
	
	@Override
	public void clearProperty(java.lang.String key) {
		this.configure.clearProperty(key);
	}
	
	@Override
	public void clear() {
		this.configure.clear();
	}
	
	@Override
	public Object getProperty(String key) {
		return this.configure.getProperty(key);
	}
	
	@Override
	public Iterator<String> getKeys(String key) {
		return this.configure.getKeys(key);
	}
	
	@Override
	public Iterator<String> getKeys() {
		return this.configure.getKeys();
	}
	
	@Override
	public java.util.Properties getProperties(String key) {
		return this.configure.getProperties(key);
	}
	
	@Override
	public boolean getBoolean(String key)  {
		return this.configure.getBoolean(key);
	}
	
	@Override
	public boolean getBoolean(String key, boolean defaltValue)  {
		return this.configure.getBoolean(key, defaltValue);
	}
	
	@Override
	public Boolean getBoolean(String key, Boolean defaltValue)  {
		return this.configure.getBoolean(key, defaltValue);
	}
	
	@Override
	public byte getByte(String key)  {
		return this.configure.getByte(key);
	}
	
	@Override
	public byte getByte(String key, byte defaltValue)  {
		return this.configure.getByte(key, defaltValue);
	}
	
	@Override
	public Byte getByte(String key, Byte defaltValue)  {
		return this.configure.getByte(key, defaltValue);
	}
	
	@Override
	public double getDouble(String key)  {
		return this.configure.getDouble(key);
	}
	
	@Override
	public double getDouble(String key, double defaltValue)  {
		return this.configure.getDouble(key, defaltValue);
	}
	
	@Override
	public Double getDouble(String key, Double defaltValue)  {
		return this.configure.getDouble(key, defaltValue);
	}
	
	@Override
	public float getFloat(String key)  {
		return this.configure.getFloat(key);
	}
	
	@Override
	public float getFloat(String key, float defaltValue)  {
		return this.configure.getFloat(key, defaltValue);
	}
	
	@Override
	public Float getFloat(String key, Float defaltValue)  {
		return this.configure.getFloat(key, defaltValue);
	}
	
	@Override
	public int getInt(String key)  {
		return this.configure.getInt(key);
	}
	
	@Override
	public int getInt(String key, int defaltValue)  {
		return this.configure.getInt(key, defaltValue);
	}
	
	@Override
	public Integer getInteger(String key, Integer defaltValue)  {
		return this.configure.getInteger(key, defaltValue);
	}
	
	@Override
	public long getLong(String key)  {
		return this.configure.getLong(key);
	}
	
	@Override
	public long getLong(String key, long defaltValue)  {
		return this.configure.getLong(key, defaltValue);
	}
	
	@Override
	public Long getLong(String key, Long defaltValue)  {
		return this.configure.getLong(key, defaltValue);
	}
	
	@Override
	public short getShort(String key)  {
		return this.configure.getShort(key);
	}
	
	@Override
	public short getShort(String key, short defaltValue)  {
		return this.configure.getShort(key, defaltValue);
	}
	
	@Override
	public Short getShort(String key, Short defaltValue)  {
		return this.configure.getShort(key, defaltValue);
	}
	
	@Override
	public java.math.BigDecimal getBigDecimal(String key)  {
		return this.configure.getBigDecimal(key);
	}
	
	@Override
	public java.math.BigDecimal getBigDecimal(String key, java.math.BigDecimal defaltValue)  {
		return this.configure.getBigDecimal(key, defaltValue);
	}
	
	@Override
	public java.math.BigInteger getBigInteger(String key)  {
		return this.configure.getBigInteger(key);
	}
	
	@Override
	public java.math.BigInteger getBigInteger(String key, java.math.BigInteger defaltValue)  {
		return this.configure.getBigInteger(key, defaltValue);
	}
	
	@Override
	public String getString(String key)  {
		return this.configure.getString(key);
	}
	
	@Override
	public String getString(String key, String defaltValue)  {
		return this.configure.getString(key, defaltValue);
	}
	
	@Override
	public String[] getStringArray(String key)  {
		return this.configure.getStringArray(key);
	}
	
	@Override
	public java.util.List getList(String key)  {
		return this.configure.getList(key);
	}
	
	@Override
	public java.util.List getList(String key, java.util.List defaltValue)  {
		return this.configure.getList(key, defaltValue);
	}
	
}
