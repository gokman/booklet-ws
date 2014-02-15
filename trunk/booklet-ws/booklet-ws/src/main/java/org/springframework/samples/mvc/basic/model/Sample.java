package org.springframework.samples.mvc.basic.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sample")
public class Sample  {
	
	public Sample(){
		
	}
	
	public Sample(Long sampleId,String sampleName){
		this.sampleId=sampleId;
		this.sampleName=sampleName;
	}

private Long sampleId;

@Column(name = "sample_surname")
public String getSampleSurname() {
	return sampleSurname;
}

public void setSampleSurname(String sampleSurname) {
	this.sampleSurname = sampleSurname;
}

private String sampleName;
private String sampleSurname;

@NotNull
@Column(name = "sample_id")
@GeneratedValue
@Id
public Long getSampleId() {
        return sampleId;
}
public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
}
@Column(name = "sample_name")
public String getSampleName() {
        return sampleName;
}
public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
}

}
  