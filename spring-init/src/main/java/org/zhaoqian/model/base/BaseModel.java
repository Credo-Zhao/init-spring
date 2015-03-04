package org.zhaoqian.model.base;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 实体基类,重写toString,hashCode,equals方法.
 * 
 * @author Credo
 * @date: 2014年8月12日
 */
public class BaseModel implements Serializable
{

	private static final long serialVersionUID = 6494888277191966864L;

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode()
	{
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj)
	{
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
