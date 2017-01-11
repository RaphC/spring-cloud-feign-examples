/**
 * 
 */
package org.perso.rcr.spring.cloud.feign;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Request;
import feign.Retryer;

/**
 * @author rachaumi
 *
 */
@FeignClient(name="my-feign-svc", path="/", qualifier="myst.myfeignClient", url = "${myst.myfeignClient.url}", configuration = MyFeignClient.MyFeignClientSpringConfiguration.class)
public interface MyFeignClient {

	    /**
	     *
	     */
	    @RequestMapping(method = RequestMethod.GET 
	                    , value = "/{param1}/{param2}"
	                    , produces = { "application/json" } 
	                   )
	    ResponseEntity<MyResponsePojo> myResource(@PathVariable("param1")  String param1, @PathVariable("param2")  String param2, @RequestHeader(name="my-header-specified", required=false, defaultValue="")  String myHeaderSpecified);

	    @Configuration
	    @EnableConfigurationProperties(MyFeignClientConfiguration.class)
	    public static class MyFeignClientSpringConfiguration {
	    	
	        @Bean
	        @ConditionalOnProperty(name="myst.myfeignClient.retry.enabled", havingValue="true")
	        Retryer retryer(){
	        	  return new Retryer.Default(
	    	       100, 
	    	        5000, 
	                3);
		    }
	    	
	        @Bean
	        @ConditionalOnProperty(name="myst.myfeignClient.retry.enabled", havingValue="false")
	        Retryer neverRetryer(){
	            return Retryer.NEVER_RETRY;
		    }
	        
	        @Bean
	        Request.Options feignOptions(MyFeignClientConfiguration myFeignClientConfiguration){
	            return new Request.Options(5000, 5000);
	        }	        
	    }
	    
	    @ConfigurationProperties("myst.myfeignClient")
	    public static class MyFeignClientConfiguration extends BackendRestClientConfiguration {


	    }
	
}
