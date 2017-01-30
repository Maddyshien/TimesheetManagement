package com.edw.spring4swagger.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import java.awt.List;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Type;
import org.hibernate.type.DateType;
import org.springframework.format.annotation.DateTimeFormat;





@Entity
@Table(name = "project")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)

public class Project implements Serializable {
	
	 @Id
	 @GeneratedValue
	 @Column(name = "id")
	 private Integer id;
	
	 @Column(name = "proj_id")
	 private String proj_id;
	 
	 @Column(name = "proj_name")
	 private String proj_name;
	 
	 @Column(name = "proj_desc")
	 private String proj_desc;
	 
	 @Column(name = "crated_by")
	 private String created_by;
	 
    @Column(name="no_of_developer")
	 private String no_of_developer; 
	 
	 @Column(name = "start_date")
	 private java.sql.Date start_date;
	 
	 
	 @Column(name = "end_date")
	 private java.sql.Date end_date;
	 
	

	 @Column(name = "status")
	 private String status;

	 
	 
	 

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getProj_id() {
		return proj_id;
	}


	public void setProj_id(String proj_id) {
		this.proj_id = proj_id;
	}


	public String getProj_name() {
		return proj_name;
	}


	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}


	public String getProj_desc() {
		return proj_desc;
	}


	public void setProj_desc(String proj_desc) {
		this.proj_desc = proj_desc;
	}


	public String getCreated_by() {
		return created_by;
	}


	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}


	


	public String getNo_of_developer() {
		return no_of_developer;
	}


	public void setNo_of_developer(String no_of_developer) {
		this.no_of_developer = no_of_developer;
	}



	public java.sql.Date getStart_date() {
		return start_date;
	}


	public void setStart_date(java.sql.Date start_date) {
		this.start_date = start_date;
	}


	public java.sql.Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(java.sql.Date end_date) {
		this.end_date = end_date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	 
	 
	 
	 
	 
	 
	 
}
