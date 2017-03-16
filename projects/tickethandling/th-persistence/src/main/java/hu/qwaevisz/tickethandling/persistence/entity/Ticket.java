package hu.qwaevisz.tickethandling.persistence.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import hu.qwaevisz.tickethandling.persistence.entity.trunk.Priority;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Status;
import hu.qwaevisz.tickethandling.persistence.parameter.TicketParameter;
import hu.qwaevisz.tickethandling.persistence.query.TicketQuery;

@Entity
@Table(name = "ticket")
@NamedQueries(value = { //
		@NamedQuery(name = TicketQuery.GET_BY_ID, query = "SELECT t FROM ticket t WHERE t.tic_id=:" + TicketParameter.ID),
		@NamedQuery(name = TicketQuery.GET_BY_SYSTEM, query = "SELECT t FROM ticket t WHERE t.tic_sys_id=:" + TicketParameter.SYSTEM),
		@NamedQuery(name = TicketQuery.GET_ALL, query = "SELECT t FROM ticket t ORDER BY t.tic_id"),
		@NamedQuery(name = TicketQuery.REMOVE_BY_ID, query = "DELETE FROM ticket t WHERE t.id=:" + TicketParameter.ID)
		//
})
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@SequenceGenerator(name = "generatorTicket", sequenceName = "ticket_tic_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTicket")
	@Column(name = "tic_id", nullable = false)
	private Long id;

	@Column(name = "tic_sys_id", nullable = false)
	private String system;

	@Column(name = "tic_sender_name", nullable = false)
	private String sender_name;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tic_priority", nullable = false)
	private Priority priority;
	
	@Column(name = "tic_business_imp", nullable = false)
	private String business_impact;
	
	@Column(name = "tic_steps_to_rep", nullable = false)
	private String steps_to_rep;
	
	@Column(name = "tic_creationdate", nullable = false)
	private Date creationdate;
	
	@Column(name = "tic_level", nullable = false)
	private Integer level;
	
	@Column(name = "tic_processor_id", nullable = false)
	private String processor;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tic_status", nullable = false)
	private Status status;
	
	@Column(name = "tic_lastchanged", nullable = false)
	private Date lastchanged;


	public Ticket(String system, String sender_name, Priority priority, String business_impact, String steps_to_rep, Date creationdate, Integer level, String processor, Status status, Date lastchanged) {
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

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
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



	public Priority getPriority() {
		return priority;
	}



	public void setPriority(Priority priority) {
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



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
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
		return "Ticket [id=" + this.id + ", system=" + this.system + ", sender=" + this.sender_name + ", priority=" + this.priority + ", business impact=" + this.business_impact + ", steps to reproduce=" + this.steps_to_rep + ", created on=" + this.creationdate + ", level=" + this.level + ", processor=" + this.processor + ", status="+this.status+" last changed on=" + this.lastchanged + "]";
	}
}
