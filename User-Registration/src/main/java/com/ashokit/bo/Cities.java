package com.ashokit.bo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CITIES_MASTER")
public class Cities {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CITY_ID")
private Integer cityId;
	@Column(name="CITY_NAME",length = 15)
private String cityName;
	@Column(name="STATE_ID")
private Integer stateId;
/*
 * @ManyToOne(targetEntity = States.class, cascade = CascadeType.ALL, fetch =
 * FetchType.LAZY) private States states;
 */
}
