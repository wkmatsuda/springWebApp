package jp.co.ws.training.form;

import jp.co.ws.training.util.ConstUtil;

/**
 * Form基幹クラス
 * @author 
 */
public class BaseForm {

	/**
	 * 画面モード
	 */
	private String mode;

	/**
	 * 画面タイトル
	 */
	private String title;

	/**
	 * 画面タイトルを返します。
	 * @return title 画面タイトル
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 画面タイトルを設定する。
	 * @param title 画面タイトル
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 画面モードを返します。
	 * @return mode 画面モード
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 画面モードを設定する。
	 * @param mode 画面モード
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 編集モードの場合trueを返します。
	 * @return
	 */
	public boolean isUpdateMode(){

		if(mode != null && mode.equals(ConstUtil.MODE_UPDATE)){
			return true;
		}

		return false;
	}

	/**
	 * 新規モードの場合trueを返します。
	 * @return
	 */
	public boolean isCreateMode(){

		if(mode != null && mode.equals(ConstUtil.MODE_CREATE)){
			return true;
		}

		return false;
	}

	/**
	 * 参照モードの場合trueを返します。
	 * @return
	 */
	public boolean isReferenceMode(){

		if(mode != null && mode.equals(ConstUtil.MODE_REFERENCE)){
			return true;
		}

		return false;
	}


}
