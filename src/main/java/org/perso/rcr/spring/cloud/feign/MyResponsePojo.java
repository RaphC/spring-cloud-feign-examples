/**
 * 
 */
package org.perso.rcr.spring.cloud.feign;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author rachaumi
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyResponsePojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -990220172421437883L;

	  @JsonProperty(value="noComptePayeur")
	  private String noComptePayeur;
	  
	  @JsonProperty(value="noReference")
	  private String noReference;

	  /**
	   * 
	   */
	  @JsonProperty(value="noComptePayeur")
	  public String getNoComptePayeur() {
	    return noComptePayeur;
	  }
	  public void setNoComptePayeur(String noComptePayeur) {
	    this.noComptePayeur = noComptePayeur;
	  }
	  public MyResponsePojo withNoComptePayeur(String noComptePayeur) {
	    this.noComptePayeur = noComptePayeur;
	    return this;
	  }

	  
	  /**
	   * 
	   */
	  @JsonProperty(value="noReference")
	  public String getNoReference() {
	    return noReference;
	  }
	  public void setNoReference(String noReference) {
	    this.noReference = noReference;
	  }
	  public MyResponsePojo withNoReference(String noReference) {
	    this.noReference = noReference;
	    return this;
	  }
}
