package corso.java.entities.mappedsuperclass;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date createdAt;
	private Date lastUpdatedAt;

	@PrePersist
	void setFields() {
		createdAt = new Date();
		lastUpdatedAt = new Date();
	}
	
	@PreUpdate
	void updateFields() {
		lastUpdatedAt = new Date();
	}
}
