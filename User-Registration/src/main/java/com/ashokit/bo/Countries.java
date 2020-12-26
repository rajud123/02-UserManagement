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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="COUNTRY_MASTER")
@Data
public class Countries {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUNTRY_ID")
private Integer countryId;
	@Column(name = "COUNTRY_NAME",length = 15)
private String countryName;
/*
 * @OneToMany(targetEntity = States.class, cascade = CascadeType.ALL, fetch =
 * FetchType.LAZY )
 * 
 * @JoinColumn(name = "COUNTRY_ID",referencedColumnName = "countryId") private
 * Set<States> states;
 */
}
