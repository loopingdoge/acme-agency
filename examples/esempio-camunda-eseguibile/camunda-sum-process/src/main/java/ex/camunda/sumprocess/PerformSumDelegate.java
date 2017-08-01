package ex.camunda.sumprocess;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PerformSumDelegate implements JavaDelegate {
	
	private final static Logger LOGGER = Logger.getLogger("SUM-PROCESS");

	public void execute(DelegateExecution execution) throws Exception {
	    LOGGER.info("Processing sum request of " + 
	    	execution.getVariable("first_el") + " + " + execution.getVariable("second_el") + "...");
	    
	    execution.setVariable("result", (Double)execution.getVariable("first_el") + (Double)execution.getVariable("second_el"));
	
	    LOGGER.info("Obtained " + 
		    	execution.getVariable("result"));
	}

}
