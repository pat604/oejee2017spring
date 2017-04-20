package hu.todomanager.weblayer.common;

public enum Page {

	LIST("list.jsp", "/todoList"),
	TODO_EDIT("editTodo.jsp", "/editTodo"),
	TODO_NEW("newTodo.jsp", "/newTodo");

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
