package hu.qwaevisz.tickethandling.ejbservice.domain;

import java.text.ParseException;
import java.util.Date;

import hu.qwaevisz.tickethandling.persistence.entity.Ticket;

public class TicketStub {
   
	private String id;
    private String system;
	private String sender_name;
	private PriorityStub priority;
	private String business_impact;
	private String steps_to_rep;
	private Date creationdate;
	private Integer level;
	private String processor;
	private StatusStub status;
	private Date lastchanged;
	
	public TicketStub() throws ParseException{
		this("", "", "", null, "", "", Ticket.format.parse("2017-03-06"), 2, "", null, Ticket.format.parse("2017-03-06"));
	}


    public TicketStub(String id, String system, String sender_name, PriorityStub priority, String business_impact, String steps_to_rep, Date creationdate, Integer level, String processor, StatusStub status, Date lastchanged) {
    	super();
    	this.id = id;
    	this.system = system;
		this.sender_name = sender_name;
		this.priority = priority;
		this.business_impact = business_impact;
		this.steps_to_rep = steps_to_rep;
		this.creationdate = creationdate;
		this.level = level;
		this.processor = processor;
		this.status = status;
		this.lastchanged =lastchanged;;
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




	public String getSender_name() {
		return sender_name;
	}




	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}




	public PriorityStub getPriority() {
		return priority;
	}




	public void setPriority(PriorityStub priority) {
		this.priority = priority;
	}




	public String getBusiness_impact() {
		return business_impact;
	}




	public void setBusiness_impact(String business_impact) {
		this.business_impact = business_impact;
	}




	public String getSteps_to_rep() {
		return steps_to_rep;
	}




	public void setSteps_to_rep(String steps_to_rep) {
		this.steps_to_rep = steps_to_rep;
	}




	public Date getCreationdate() {
		return creationdate;
	}




	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}




	public Integer getLevel() {
		return level;
	}




	public void setLevel(Integer level) {
		this.level = level;
	}




	public String getProcessor() {
		return processor;
	}




	public void setProcessor(String processor) {
		this.processor = processor;
	}




	public StatusStub getStatus() {
		return status;
	}




	public void setStatus(StatusStub status) {
		this.status = status;
	}




	public Date getLastchanged() {
		return lastchanged;
	}




	public void setLastchanged(Date lastchanged) {
		this.lastchanged = lastchanged;
	}




	@Override
    public String toString() {
        return "TicketStub [id=" + id + ", system=" + system + ", sender=" + sender_name + ", priority=" + priority + ", status=" + status + "]";
    }

}
