package hu.qwaevisz.tickethandling.weblayer.common;

public enum Page {

	LIST("list.jsp", "TicketList"),
	TICKET_VIEW("ticket.jsp", "Ticket"),
	TICKET_EDIT("ticket-edit.jsp", "Ticket");

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
