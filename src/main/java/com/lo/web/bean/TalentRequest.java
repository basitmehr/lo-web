package com.lo.web.bean;

import java.io.Serializable;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class TalentRequest implements Serializable {

	private static final long serialVersionUID = 4158708405615621013L;
	
	private String firstName;
	private String lastName;
	private String address;
	private String category;
	private String resume;

}
