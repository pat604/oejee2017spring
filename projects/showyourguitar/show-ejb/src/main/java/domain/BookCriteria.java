package domain;

public class BookCriteria {

	private String author;
	private String title;
	private BookCategoryStub category;
	private int minimumPrice;
	private int maximumPrice;

	public BookCriteria() {
	}

	public BookCriteria(String author, String title, BookCategoryStub category, int minimumPrice,
			int maximumPrice) {
		super();
		this.author = author;
		this.title = title;
		this.category = category;
		this.minimumPrice = minimumPrice;
		this.maximumPrice = maximumPrice;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BookCategoryStub getCategory() {
		return this.category;
	}

	public void setCategory(BookCategoryStub category) {
		this.category = category;
	}

	public int getMinimumPrice() {
		return this.minimumPrice;
	}

	public void setMinimumPrice(int minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	public int getMaximumPrice() {
		return this.maximumPrice;
	}

	public void setMaximumPrice(int maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

	@Override
	public String toString() {
		return "BookCriteria [author=" + this.author + ", title=" + this.title + ", category="
				+ this.category + ", minimumPrice=" + this.minimumPrice + ", maximumPrice="
				+ this.maximumPrice + "]";
	}

}
