package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import com.kota.stratagem.ejbservice.domain.ImpedimentRepresentor;
import com.kota.stratagem.ejbservice.domain.ImpedimentStatusRepresentor;
import com.kota.stratagem.ejbservice.domain.PriorityRepresentor;
import com.kota.stratagem.persistence.entity.Impediment;
import com.kota.stratagem.persistence.entity.Remedy;

public class ImpedimentConverterImpl implements ImpedimentConverter {

	private AppUserConverter appUserConverter = new AppUserConverterImpl();
	private RemedyConverter remedyConverter = new RemedyConverterImpl();
	private ProjectConverter projectConverter = new ProjectConverterImpl();
	private TaskConverter taskConverter = new TaskConverterImpl();

	@Override
	public ImpedimentRepresentor to(Impediment impediment) {
		final PriorityRepresentor priority = PriorityRepresentor.valueOf(impediment.getPriority().toString());
		final ImpedimentStatusRepresentor status = ImpedimentStatusRepresentor.valueOf(impediment.getStatus().toString());
		final ImpedimentRepresentor representor = impediment.getId() != null
				? new ImpedimentRepresentor(impediment.getId(), impediment.getName(), impediment.getDescription(), priority, status, impediment.getReportDate(),
						appUserConverter.to(impediment.getReporter()), appUserConverter.to(impediment.getProcessor()), projectConverter.to(impediment.getProject()),
						taskConverter.to(impediment.getTask()))
				: new ImpedimentRepresentor(impediment.getName(), impediment.getDescription(), priority, status, impediment.getReportDate(), appUserConverter.to(impediment.getReporter()),
						appUserConverter.to(impediment.getProcessor()), projectConverter.to(impediment.getProject()), taskConverter.to(impediment.getTask()));
		if(impediment.getRemedies() != null) {
			for(Remedy remedy : impediment.getRemedies()) {
				representor.addRemedy(remedyConverter.to(remedy));
			}
		}
		return representor;
	}

	@Override
	public List<ImpedimentRepresentor> to(List<Impediment> impediments) {
		final List<ImpedimentRepresentor> representors = new ArrayList<>();
		for(final Impediment impediment : impediments) {
			representors.add(this.to(impediment));
		}
		return representors;
	}

}
