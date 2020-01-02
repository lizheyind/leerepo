package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CertBean {
	
	public Date   etl_dt;
	
	public String cert_no;
	
	public CertBean() {
		
	}
	
	public CertBean(Date etl_dt,String cert_no) {
		this.etl_dt=etl_dt;
		this.cert_no=cert_no;
	}
}
