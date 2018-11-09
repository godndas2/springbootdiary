package com.github.godndas2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Diary Class는 DB에 저장 가능한 JPA Entity이므로 
 * 
 * @Entity
 * @Id
 * @GeneratedValue
 *
 * 를 작성해준다.
 */
@Entity
public class Diary {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //GenerationType Hibernate (X)
	private Long id;
	private String title;
	private Date created;
	private String summary;
	
	@Transient
	private SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public SimpleDateFormat getFmt() {
		return fmt;
	}

	public void setFmt(SimpleDateFormat fmt) {
		this.fmt = fmt;
	}

	public String getCreatedAsShort() {
		return fmt.format(created);
	}

	@Override
	public String toString() {
		return "Diary [id=" + id + ", title=" + title + ", created=" + created + ", summary=" + summary + ", fmt=" + fmt
				+ "]";
	}

	// 주의..!
	public Diary(String title, String summary,String date ) throws ParseException {
		this.title = title;
		this.summary = summary;
		this.created = fmt.parse(date);
	}

	public Diary() {
		super();
	}
	
}
