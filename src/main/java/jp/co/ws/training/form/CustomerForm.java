package jp.co.ws.training.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerForm extends BaseForm {

    private Integer id;

	/**
	 * idを返します。
	 * @return id id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * idを設定する。
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	@NotNull
    @Size(min = 1, max = 127)
    private String firstName;
    @NotNull
    @Size(min = 1, max = 127)
    private String lastName;
	/**
	 * firstNameを返します。
	 * @return firstName firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * firstNameを設定する。
	 * @param firstName firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * lastNameを返します。
	 * @return lastName lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * lastNameを設定する。
	 * @param lastName lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}