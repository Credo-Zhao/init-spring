package org.zhaoqian.security.model.enums;

public enum Permission
{
	// user role
	USER("user:*", "user query,view,edit,add,delete"),
	USER_VIEW("user:view", "user query,view"),
	ROLE("role:*", "role query,view,edit,add,delete"),
	ROLE_VIEW("role:view", "role query,view"),

	// license
	LICENSE("license:setting", "license:setting");

	private String abbreviation;

	private String description;

	private Permission(String abbreviation, String description)
	{

		this.abbreviation = abbreviation;
		this.description = description;
	}

	public String getAbbreviation()
	{

		return this.abbreviation;
	}

	public String getDescription()
	{

		return this.description;
	}
}
