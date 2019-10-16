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
public class Documentclassification extends Model<Documentclassification> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer did;
	private Integer cid;


	public Integer getId() {
		return id;
	}

	public Documentclassification setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getDid() {
		return did;
	}

	public Documentclassification setDid(Integer did) {
		this.did = did;
		return this;
	}

	public Integer getCid() {
		return cid;
	}

	public Documentclassification setCid(Integer cid) {
		this.cid = cid;
		return this;
	}

	public static final String ID = "id";

	public static final String DID = "did";

	public static final String CID = "cid";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Documentclassification{" +
			", id=" + id +
			", did=" + did +
			", cid=" + cid +
			"}";
	}
}
