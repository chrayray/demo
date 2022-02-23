package com.SpringBoot.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "work_messages")
public class WorkMessages implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	// https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-builtin-constraints
	@NotEmpty(message = "不可空白")
	@Size(min = 3, max = 20, message = "請輸入3-20個字")
	@Column(name = "text")
	private String text;

	@JsonFormat(pattern = "yyyy/MM/dd HH.mm.ss", timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	private Date added;
// TIMESTAMP=時間標記，會得到yyyy-MM-dd-hh-mm-ss

	public WorkMessages() {
	}

	// 當 Entity 狀態要變成 Persistent 的時候，做以下方法
	@PrePersist
	public void onCreate() {
		if (added == null) {
			added = new Date();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkMessages [id=");
		builder.append(id);
		builder.append(", text=");
		builder.append(text);
		builder.append(", added=");
		builder.append(added);
		builder.append("]");
		return builder.toString();
	}

}