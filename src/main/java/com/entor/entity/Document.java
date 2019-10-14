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
public class Document extends Model<Document> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 标题
     */
	private String title;
    /**
     * 作者
     */
	private String author;
    /**
     * 保存地址
     */
	private String address;
	private String size;


	public Integer getId() {
		return id;
	}

	public Document setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Document setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public Document setAuthor(String author) {
		this.author = author;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Document setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getSize() {
		return size;
	}

	public Document setSize(String size) {
		this.size = size;
		return this;
	}

	public static final String ID = "id";

	public static final String TITLE = "title";

	public static final String AUTHOR = "author";

	public static final String ADDRESS = "address";

	public static final String SIZE = "size";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Document{" +
			", id=" + id +
			", title=" + title +
			", author=" + author +
			", address=" + address +
			", size=" + size +
			"}";
	}
}
