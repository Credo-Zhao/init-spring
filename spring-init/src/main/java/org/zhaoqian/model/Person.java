package org.zhaoqian.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.zhaoqian.model.base.BaseModel;

@Entity
@Table(name = "Person")
public class Person extends BaseModel
{

	private static final long serialVersionUID = 7378694178277229019L;

	@Id
	@GeneratedValue(generator = "uuidGenerator")
	@GenericGenerator(name = "uuidGenerator", strategy = "uuid2")
	@Column(name = "ID")
	private String id;

	@Column(name = "name")
	@Size(min = 1, max = 30)
	@NotNull
	private String name;

	@Column(name = "age")
	@Min(1)
	@Max(200)
	@NotNull
	private Integer age;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

}
