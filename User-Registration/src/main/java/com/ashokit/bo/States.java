package com.ashokit.bo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="STATES_MASTER")
@Data
public class States {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STATE_ID")
private Integer stateId;
	@Column(name="STATE_NAME",length = 15)
private String stateName;
	@Column(name="COUNTRY_ID")
private Integer countryId;
	
	
/*
 * @ManyToOne(targetEntity = Countries.class, cascade = CascadeType.ALL, fetch =
 * FetchType.LAZY) private Countries countries;
 * 
 * @OneToMany(targetEntity = Cities.class, cascade = CascadeType.ALL, fetch =
 * FetchType.LAZY, orphanRemoval = true)
 * 
 * @JoinColumn(name = "STATE_ID",referencedColumnName = "stateId") private
 * Set<Cities> cities;
 */
}
