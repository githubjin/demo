package cn.demo.random.redis;

import java.io.Serializable;

class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String factory;

	public Product() {
		super();
	}

	public Product(String id, String name, String factory) {
		super();
		this.id = id;
		this.name = name;
		this.factory = factory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}
}