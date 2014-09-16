package com.EHR.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PDCTTemplateMOUTable")
public class PDCTTemplateMOU implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer unitId;
  private String unitName;
  private Integer alternateUnitId;
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="unitId", unique=true, nullable=false)
  public Integer getUnitId()
  {
    return this.unitId;
  }
  
  public void setUnitId(Integer unitId)
  {
    this.unitId = unitId;
  }
  
  @Column(name="unitName", nullable=false, length=16)
  public String getUnitName()
  {
    return this.unitName;
  }
  
  public void setUnitName(String unitName)
  {
    this.unitName = unitName;
  }
  
  @Column(name="alternateUnitId")
  public Integer getAlternateUnitId()
  {
    return this.alternateUnitId;
  }
  
  public void setAlternateUnitId(Integer alternateUnitId)
  {
    this.alternateUnitId = alternateUnitId;
  }
  
}

