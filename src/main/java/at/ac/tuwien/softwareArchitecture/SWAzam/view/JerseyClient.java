package at.ac.tuwien.softwareArchitecture.SWAzam.view;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class JerseyClient {
	ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(getBaseURI());
    
    
    
    
    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/Server").build();
     }
}
