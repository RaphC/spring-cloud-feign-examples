/**
 * 
 */
package org.perso.rcr.spring.cloud.feign;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.reset;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static com.github.tomakehurst.wiremock.client.WireMock.absent;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.github.tomakehurst.wiremock.common.Slf4jNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.common.net.HttpHeaders;

import feign.RetryableException;

/**
 * @author rachaumi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		properties={
				 "feign.compression.request.enabled=true"
				, "feign.compression.response.enabled=true"
				, "feign.compression.request.mime-types=text/xml,application/xml,application/json,multipart/form-data"
				, "feign.compression.request.min-request-size=128"
				, "feign.hystrix.enabled=false" // Voir @Bean Request.Options pour les timeout si pas hystrix
				, "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=6000" // timeout avec hystrix active
				
				}, 
		classes={SpringCloudFeignApplication.class})
public class SpringCloudFeignClientHystrixDisabledTest {
	
	protected static final String			TEST_RESOURCES_DIR	= System.getProperty("user.dir") + "/src/test/resources/";
	

	/**
	 * Configuration
	 */
	private static WireMockConfiguration wireMockConfig = wireMockConfig()
														.usingFilesUnderDirectory(TEST_RESOURCES_DIR+"/dataset/wiremock/")
														.port(3222)
														.dynamicHttpsPort()
														.notifier(new Slf4jNotifier(true));

	@Rule
	public WireMockClassRule gloudMockRule = new WireMockClassRule(wireMockConfig);
	
	@Autowired(required=true)
	@Qualifier("myst.myfeignClient")
	MyFeignClient myFeignClient;
	
	
	@Before
	public void before(){
		reset();
	}
	
	@Test
	public void should_not_send_header_with_null_value(){
		
		//given
		// mock appel target
		gloudMockRule.stubFor(get(urlEqualTo("/noComptePayeur/noReference"))
	            .willReturn(aResponse()
	            	.withStatus(HttpStatus.SC_OK)
	                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	                .withHeader("Date", "Wed, 12 Oct 2009 17:50:00 GMT")
	                .withBody("{\"noReference\":\"12354321354\",\"noComptePayeur\":\"125811\"}")
	                ));
        
		myFeignClient.myResource("noComptePayeur", "noReference", null);
		//verify(getRequestedFor(urlEqualTo("/noComptePayeur/noReference"))
		//        .withHeader("my-header-specified", absent()));
	}
	
}
