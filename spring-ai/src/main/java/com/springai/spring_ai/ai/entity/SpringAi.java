package com.springai.spring_ai.ai.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "spring_ai")
public class SpringAi {

    @Id
	@SequenceGenerator(name = "EntitySequence", initialValue = 600)
	@GeneratedValue(generator = "EntitySequence",strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "created_at")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "last_modified_at")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedAt;

	@Column(columnDefinition = "boolean default false", name = "is_deleted")
	private boolean isDeleted;

    @Column(name = "promt")
    private String propmt;

    @Column(name = "api-response")
    private String apiResponse;
    
}
