package hu.todomanager.weblayer.common;

public enum Page {

	LIST("list.jsp", "TodoList"),
	TODO_EDIT("editTodo.jsp", "Todo"),
	TODO_NEW("newTodo.jsp", "Todo");

	private final String jspName;
	private final String url;

	public String getJspName() {
		return this.jspName;
	}

	public String getUrl() {
		return this.url;
	}

	private Page(final String jspName, final String url) {
		this.jspName = jspName;
		this.url = url;
	}

}
