package jp.co.dk.property.exception;

/**
 * PropertyExceptionはプロパティ操作にて例外が発生したことを通知する例外クラスです。<p>
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class PropertyException extends RuntimeException {
	
	/**
	 * シリアルバージョンID 
	 */
	private static final long serialVersionUID = 8987317987019827195L;
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 例外を生成します。
	 * 
	 * @since 1.0
	 */
	public PropertyException() {
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
	public PropertyException(String message) {
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
	public PropertyException(String message, Throwable e) {
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
	public PropertyException(Throwable e) {
		super(e);
	}
}
