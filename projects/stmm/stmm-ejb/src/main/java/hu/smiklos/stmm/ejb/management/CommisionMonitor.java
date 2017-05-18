package hu.smiklos.stmm.ejb.management;

import org.apache.log4j.Logger;



public class CommisionMonitor implements CommisionMonitorMBean {

	private static final Logger LOGGER = Logger.getLogger(CommisionMonitor.class);


	public void start() throws Exception {
		LOGGER.info("Start CommisionMonitor MBean");
	}

	public void stop() throws Exception {
		LOGGER.info("Stop CommisionMonitor MBean");
	}

	@Override
	public int getComissionValue() {
		return 2;
	}
}
