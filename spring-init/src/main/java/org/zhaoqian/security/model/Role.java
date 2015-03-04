package org.zhaoqian.security.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotEmpty;
import org.zhaoqian.model.base.BaseModel;

@Entity
@Table(name = "roles", uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME" }) })
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, include = "non-lazy")
public class Role extends BaseModel {

	private static final long serialVersionUID = -7695495840123338576L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NaturalId
	@NotEmpty
	@Column(name = "NAME")
	@Size(min=3)
	private String name;

	@Basic(optional = true)
	@Column(length = 255)
	private String description;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "permissions", joinColumns = @JoinColumn(name = "role_id"))
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@Column(name = "permission")
	private List<String> permissions = new ArrayList<String>();

	@Version
	@Column(name = "OPT_LOCK")
	private int versionNum = 0;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public List<String> getPermissions() {

		return permissions;
	}

	public void setPermissions(List<String> permissions) {

		this.permissions = permissions;
	}

	public int getVersionNum() {

		return versionNum;
	}

	public void setVersionNum(int versionNum) {

		this.versionNum = versionNum;
	}

	/**
	 * @return the roles List
	 */
	@Transient
	public String getViewPermissions() {

		StringBuilder sb = new StringBuilder();

		for ( Iterator<String> it = getPermissions().iterator(); it.hasNext(); )
		{
			sb.append(it.next());
			if ( it.hasNext() )
				sb.append(",");
		}

		return sb.toString();
	}

	
}