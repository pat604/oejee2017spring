package hu.qwaevisz.tickethandling.webservice;

import javax.ejb.Stateless;

@Stateless
public class MarkRestServiceBean implements MarkRestService {
	/*
	 * private static final Logger LOGGER = Logger.getLogger(MarkRestServiceBean.class);
	 *
	 * @EJB private MarkFacade facade;
	 *
	 * @Override public List<MarkDetailStub> getMarkDetails(String subject) throws AdaptorException {
	 * LOGGER.info("Get MarkDetails (" + subject + ")"); return this.facade.getMarkDetails(subject); }
	 *
	 * @Override public MarkStub addMark(MarkInputStub stub) throws AdaptorException { LOGGER.info("Add Mark (" + stub +
	 * ")"); return this.facade.addMark(stub.getSubject(), stub.getNeptun(), stub.getGrade().getValue(),
	 * stub.getNote()); }
	 *
	 * @Override public MarkStub getMatchingMark(String studentNeptun, MarkCriteria criteria) throws AdaptorException {
	 * LOGGER.info("Get first matching Mark (studentNeptun: " + studentNeptun + ", criteria: " + criteria + ")"); return
	 * this.facade.getMatchingMark(studentNeptun, criteria.getSubjectNameTerm(), criteria.getMinimumGrade(),
	 * criteria.getMaximumGrade()); }
	 *
	 * @Override public Response optionsAll(String path) { return Response.status(Response.Status.NO_CONTENT).build(); }
	 */
}
