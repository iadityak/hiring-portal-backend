package com.idemia.HiringProject.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requirement")
public class Requirement {
		
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="domain")
	private String domain;
	
	@Column(name="sub_domain")
	private String subDomain;
	
	@Column(name="reporting_manager")
	private String reportingManager;
	
	@Column(name="status")
	private String status;

	@Column(name="vacancy")
	private int vacancy;

	@Column(name="job_location")
	private String jobLocation;
	
	@Column(name="min_exp")
	private int minExp; 
	
	public Requirement()
	{
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSubDomain() {
		return subDomain;
	}

	public void setSubDomain(String subDomain) {
		this.subDomain = subDomain;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public int getMinExp() {
		return minExp;
	}

	public void setMinExp(int minExp) {
		this.minExp = minExp;
	}

	@Override
	public String toString() {
		return "Requirement [id=" + id + ", name=" + name + ", domain=" + domain + ", subDomain=" + subDomain
				+ ", reportingManager=" + reportingManager + ", status=" + status + ", vacancy=" + vacancy
				+ ", jobLocation=" + jobLocation + ", minExp=" + minExp + "]";
	}
	
	
		
}