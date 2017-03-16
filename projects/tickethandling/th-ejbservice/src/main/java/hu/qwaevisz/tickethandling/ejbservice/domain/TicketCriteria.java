package hu.qwaevisz.tickethandling.ejbservice.domain;

public class TicketCriteria {

	private String id;
    private String system;

    public TicketCriteria() {
    }

    
   

    public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getSystem() {
		return system;
	}


	public void setSystem(String system) {
		this.system = system;
	}


	@Override
    public String toString() {
        return "TicketCriteria [id=" + id + ", system=" + system + "]";
    }

}
