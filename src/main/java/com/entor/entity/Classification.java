package com.entor.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2019-10-14
 */
public class Classification extends Model<Classification> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String name;
	private Integer did;


	public Integer getId() {
		return id;
	}

	public Classification setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Classification setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getDid() {
		return did;
	}

	public Classification setDid(Integer did) {
		this.did = did;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String DID = "did";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Classification{" +
			", id=" + id +
			", name=" + name +
			", did=" + did +
			"}";
	}
}
