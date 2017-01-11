/**
 * 
 */
package org.perso.rcr.spring.cloud.feign;

/**
 * @author RACHAUMI
 *
 */
public class HttpRetryConfiguration {

	/**
	 * Active ou desactive le retry
	 */
	private boolean enabled; 
	
	private long period;
	
	private long maxPeriod;
	
	private int maxAttempts;

	/**
	 * @return the period
	 */
	public long getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(long period) {
		this.period = period;
	}

	/**
	 * @return the maxPeriod
	 */
	public long getMaxPeriod() {
		return maxPeriod;
	}

	/**
	 * @param maxPeriod the maxPeriod to set
	 */
	public void setMaxPeriod(long maxPeriod) {
		this.maxPeriod = maxPeriod;
	}

	/**
	 * @return the maxAttempts
	 */
	public int getMaxAttempts() {
		return maxAttempts;
	}

	/**
	 * @param maxAttempts the maxAttempts to set
	 */
	public void setMaxAttempts(int maxAttempts) {
		this.maxAttempts = maxAttempts;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
