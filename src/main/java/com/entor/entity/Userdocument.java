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
 * @since 2019-10-16
 */
public class Userdocument extends Model<Userdocument> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer uid;
	private Integer did;


	public Integer getId() {
		return id;
	}

	public Userdocument setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getUid() {
		return uid;
	}

	public Userdocument setUid(Integer uid) {
		this.uid = uid;
		return this;
	}

	public Integer getDid() {
		return did;
	}

	public Userdocument setDid(Integer did) {
		this.did = did;
		return this;
	}

	public static final String ID = "id";

	public static final String UID = "uid";

	public static final String DID = "did";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Userdocument{" +
			", id=" + id +
			", uid=" + uid +
			", did=" + did +
			"}";
	}
}
