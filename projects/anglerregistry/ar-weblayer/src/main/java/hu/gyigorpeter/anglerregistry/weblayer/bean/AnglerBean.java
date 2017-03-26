package hu.gyigorpeter.anglerregistry.weblayer.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import hu.gyigorpeter.anglerregistry.ejbservice.exception.FacadeException;
import hu.gyigorpeter.anglerregistry.ejbservice.facade.AnglerFacade;
import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Angler;

@ViewScoped
@Named("anglerBean")
public class AnglerBean implements Serializable {

	private static final long serialVersionUID = -554423484774035995L;
	private static final Logger LOGGER = Logger.getLogger(AnglerBean.class.getName());

	@Inject
	private AnglerFacade anglerFacade;

	private List<Angler> anglerList = new ArrayList<Angler>();

	private String name = "";
	private String mothersName = "";
	private String birthDay = "";
	private String birthPlace = "";
	private int zipCode = 0;
	private String city = "";
	private String address = "";
	private int socialWork = 0;
	private String banTime = "";
	private boolean isMember = false;

	private Angler selectedAngler = null;

	@PostConstruct
	public void init() {
		try {
			this.anglerList = this.anglerFacade.getAllAnglers();
		} catch (FacadeException e) {
			LOGGER.error(e);
		}

	}

	public void addAnglerAction() {
		try {
			this.anglerFacade.addAngler(new Angler(this.name, this.mothersName, new Date(this.birthDay), this.birthPlace, this.zipCode, this.city, this.address,
					this.socialWork, new Date(this.banTime), this.isMember));
		} catch (FacadeException e) {
			LOGGER.error(e.getMessage());
		}
	}

	public void cancelAddAnglerAction() {
		this.name = "";
		this.mothersName = "";
		this.birthDay = "";
		this.birthPlace = "";
		this.zipCode = 0;
		this.city = "";
		this.address = "";
		this.socialWork = 0;
		this.banTime = "";
		this.isMember = false;

		this.selectedAngler = null;

		RequestContext.getCurrentInstance().execute("PF('addMediaDialogWidget').hide()");
	}

	public void onRowSelect(SelectEvent event) {
		if (this.selectedAngler == null) {
			this.selectedAngler = (Angler) event.getObject();
		}
	}

	public void onRowUnselect(UnselectEvent event) {
		if (this.selectedAngler != null) {
			this.selectedAngler = null;
		}
	}

	public void onRowEdit(RowEditEvent event) {
		Angler editing = (Angler) event.getObject();
		// TODO persist
	}

	// public void onRowCancel(RowEditEvent event) {
	//
	// }

	public void onDelete(Object obj) {
		Angler deleting = (Angler) obj;
		if (deleting != null) {
			try {

				this.anglerFacade.delete(deleting.getId());

			} catch (FacadeException e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

	public AnglerFacade getAnglerFacade() {
		return this.anglerFacade;
	}

	public void setAnglerFacade(AnglerFacade anglerFacade) {
		this.anglerFacade = anglerFacade;
	}

	public List<Angler> getAnglerList() {
		return this.anglerList;
	}

	public void setAnglerList(List<Angler> anglerList) {
		this.anglerList = anglerList;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMothersName() {
		return this.mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public String getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public int getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSocialWork() {
		return this.socialWork;
	}

	public void setSocialWork(int socialWork) {
		this.socialWork = socialWork;
	}

	public String getBanTime() {
		return this.banTime;
	}

	public void setBanTime(String banTime) {
		this.banTime = banTime;
	}

	public boolean getIsMember() {
		return this.isMember;
	}

	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	public Angler getSelectedAngler() {
		return this.selectedAngler;
	}

	public void setSelectedAngler(Angler selectedAngler) {
		this.selectedAngler = selectedAngler;
	}

}
