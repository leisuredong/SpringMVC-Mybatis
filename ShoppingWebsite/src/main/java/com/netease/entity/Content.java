package com.netease.entity;

public class Content {
	private int id;
	private String title;
	private String summary;
	private String image;
	private String file;
	private String detail;
	private int price;

	public Content() {

	}

	public Content(String title, String summary, String image, String file, String detail, int price) {
		this.title = title;
		this.summary = summary;
		this.image = image;
		this.file = file;
		this.detail = detail;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Content [title=" + title + ", summary=" + summary + ", image=" + image + ", file=" + file + ", detail="
				+ detail + ", price=" + price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
