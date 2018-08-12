import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

public class RestClientTest {
	
	
	@Test
	public void check404StatusCode()
	  throws ClientProtocolException, IOException {
	  
	   // Given
	   String name = "abcd567890";
	   HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );
	 
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	   // Then
	   
	   Assert.assertEquals(HttpStatus.SC_NOT_FOUND,httpResponse.getStatusLine().getStatusCode());
	   /*assertThat(
	     httpResponse.getStatusLine().getStatusCode(),
	     equalTo(HttpStatus.SC_NOT_FOUND));*/
	}
	
	@Test
	public void check200StatusCode()
	  throws ClientProtocolException, IOException {
	  
	   // Given
	   String name = "abcd";
	   HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );
	 
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	   // Then
	   
	   Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
	   /*assertThat(
	     httpResponse.getStatusLine().getStatusCode(),
	     equalTo(HttpStatus.SC_NOT_FOUND));*/
	}

}
