package jp.co.dk.property.exception;

import org.apache.commons.configuration.ConversionException;

/**
 * PropertyConversionExceptionはプロパティ値取得時に変換処理にて例外が発生したことを通知する例外クラスです。<p>
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class PropertyConversionException extends ConversionException{

	/**
	 * シリアルバージョンID
	 */
	private static final long serialVersionUID = 2294740442166125137L;
	

	/**
	 * コンストラクタ<p>
	 * 
	 * 例外を生成します。
	 * 
	 * @since 1.0
	 */
	public PropertyConversionException() {
		super();
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定のメッセージで例外を生成します。
	 * 
	 * @param message メッセージ本文
	 * @since 1.0
	 */
	public PropertyConversionException(String message) {
		super(message);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定のメッセージ、例外で例外を生成します。
	 * 
	 * @param message メッセージ本文
	 * @param e       例外インスタンス
	 * @since 1.0
	 */
	public PropertyConversionException(String message, Throwable e) {
		super(message, e);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定の例外で例外を生成します。
	 * 
	 * @param e       例外インスタンス
	 * @since 1.0
	 */
	public PropertyConversionException(Throwable e) {
		super(e);
	}
}
