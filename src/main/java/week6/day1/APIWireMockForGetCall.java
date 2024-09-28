package week6.day1;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class APIWireMockForGetCall {

	public static void main(String[] args) {
		
		WireMockServer mockServer = new WireMockServer();
		mockServer.start();
		
		mockServer.stubFor(
				  WireMock.get("/some/endpoint")
				  .willReturn(WireMock.aResponse()
						      .withStatus(200)
						      .withBody("Hi World!")
						    ));
		

	}

}