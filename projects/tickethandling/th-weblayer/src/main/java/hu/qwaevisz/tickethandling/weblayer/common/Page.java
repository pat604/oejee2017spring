package hu.qwaevisz.tickethandling.weblayer.common;

public enum Page {

	LOGIN("login.jsp", "Login"),
	ERROR("error.jsp", "Error"),
	LIST("list.jsp", "TicketList"),
	HOME("home.jsp", "Home"),
	TICKET_VIEW("ticket.jsp", "Ticket"),
	TICKET_CREATE("ticket-create.jsp", "TicketCreate");

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
