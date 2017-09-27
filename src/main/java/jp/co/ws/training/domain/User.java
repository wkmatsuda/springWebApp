
package jp.co.ws.training.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    private Integer id;
    private String firstName;
    private String lastName;
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