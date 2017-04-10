package hu.qwaevisz.tickethandling.ejbservice.domain;

public class TicketCriteria {

	private String id;
	private String system;
	private PriorityStub priority;
	private StatusStub status;

	public TicketCriteria() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public PriorityStub getPriority() {
		return this.priority;
	}

	public void setPriority(PriorityStub priority) {
		this.priority = priority;
	}

	public StatusStub getStatus() {
		return this.status;
	}

	public void setStatus(StatusStub status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TicketCriteria [id=" + this.id + ", system=" + this.system + "]";
	}

}
