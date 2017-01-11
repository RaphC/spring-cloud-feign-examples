package org.perso.rcr.spring.cloud.feign;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author ByTel
 * 
 */
@JsonInclude(Include.NON_NULL)
public class HttpConfiguration {

	@NotNull
	protected String url;

	protected int readTimeoutMs;

	protected int connectTimeoutMs;
	
	protected int socketTimeoutMs;

	protected int maxConnections;

	protected boolean proxyEnabled;
	
	protected String proxyHost;
	
	protected int proxyPort;
	
	protected String proxyProtocol;
	
	protected HttpRetryConfiguration retry;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getReadTimeoutMs() {
		return readTimeoutMs;
	}

	public void setReadTimeoutMs(int readTimeoutMs) {
		this.readTimeoutMs = readTimeoutMs;
	}

	public int getConnectTimeoutMs() {
		return connectTimeoutMs;
	}

	public void setConnectTimeoutMs(int connectTimeoutMs) {
		this.connectTimeoutMs = connectTimeoutMs;
	}
	
	/**
	 * @return the socketTimeoutMs
	 */
	public int getSocketTimeoutMs() {
		return socketTimeoutMs;
	}

	/**
	 * @param socketTimeoutMs the socketTimeoutMs to set
	 */
	public void setSocketTimeoutMs(int socketTimeoutMs) {
		this.socketTimeoutMs = socketTimeoutMs;
	}

	public int getMaxConnections() {
		return maxConnections;
	}

	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	/**
	 * @return the proxyHost
	 */
	public String getProxyHost() {
		return proxyHost;
	}

	/**
	 * @param proxyHost the proxyHost to set
	 */
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	/**
	 * @return the proxyPort
	 */
	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * @param proxyPort the proxyPort to set
	 */
	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	/**
	 * @return the proxyProtocol
	 */
	public String getProxyProtocol() {
		return proxyProtocol;
	}

	/**
	 * @param proxyProtocol the proxyProtocol to set
	 */
	public void setProxyProtocol(String proxyProtocol) {
		this.proxyProtocol = proxyProtocol;
	}

	/**
	 * @return the proxyEnabled
	 */
	public boolean isProxyEnabled() {
		return proxyEnabled;
	}

	/**
	 * @param proxyEnabled the proxyEnabled to set
	 */
	public void setProxyEnabled(boolean proxyEnabled) {
		this.proxyEnabled = proxyEnabled;
	}

	/**
	 * @return the retry
	 */
	public HttpRetryConfiguration getRetry() {
		return retry;
	}

	/**
	 * @param retry the retry to set
	 */
	public void setRetry(HttpRetryConfiguration retry) {
		this.retry = retry;
	}
	
}