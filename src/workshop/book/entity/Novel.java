package workshop.book.entity;

public class Novel extends Publication{
	private String author;
	private String gerne;
	
	public Novel() {
		
	}

	public Novel(String title, String publishingDate, int page, int price,String author, String gerne) {
		super(title, publishingDate, page, price);
		this.author = author;
		this.gerne = gerne;
		
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGerne() {
		return gerne;
	}

	public void setGerne(String gerne) {
		this.gerne = gerne;
	}
}
