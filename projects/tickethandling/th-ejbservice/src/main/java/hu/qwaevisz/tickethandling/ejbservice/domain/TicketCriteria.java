package hu.qwaevisz.tickethandling.ejbservice.domain;

public class TicketCriteria {

    private String system;

    public TicketCriteria() {
    }

   

    public String getSystem() {
		return system;
	}



	public void setSystem(String system) {
		this.system = system;
	}


	@Override
    public String toString() {
        return "TicketCriteria [system=" + system + "]";
    }

}
