package in.ashokit.binding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DTLS")
public class Contact {

	@Id
	@GeneratedValue
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNum;

}
