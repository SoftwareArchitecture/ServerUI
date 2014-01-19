package at.ac.tuwien.softwareArchitecture.SWAzam.view;

import java.net.URI;
import java.util.List;

//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import at.ac.tuwien.softwarearchitecture.swazam.common.infos.*;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
//import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class JerseyClient {
	ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(getBaseURI());
    
    //login over webservice-call, return Account information
    public Account login(String username, String password)
    {	
    	MultivaluedMap<String, String> queryParams1 = new MultivaluedMapImpl();
    	queryParams1.add("username", username);
    	queryParams1.add("password", password);
    	Account ac = service.path("webapi").path("accountmanagement").path("login").queryParams(queryParams1).accept(MediaType.APPLICATION_XML).get(Account.class);
    	return ac;
    }
    
    public void updateAccount(int id, String username, String password, String Firstname, String Lastname, String sessionkey)
    {
    	MultivaluedMap<String, String> queryParams1 = new MultivaluedMapImpl();
    	queryParams1.add("id", String.valueOf(id));
    	queryParams1.add("username", username);
    	queryParams1.add("password", password);
    	queryParams1.add("firstname", Firstname);
    	queryParams1.add("lastname", Lastname);
    	queryParams1.add("sessionkey", sessionkey);
    	service.path("webapi").path("accountmanagement").path("updateaccount").queryParams(queryParams1).accept(MediaType.APPLICATION_XML).put();
    }
    
    public void deleteAccount(int id, String sessionkey)
    {
    	MultivaluedMap<String, String> queryParams1 = new MultivaluedMapImpl();
    	queryParams1.add("id", String.valueOf(id));
    	queryParams1.add("sessionkey", sessionkey);
    	service.path("webapi").path("accountmanagement").path("deleteaccount").queryParams(queryParams1).delete();
    }
    
    public void insertAccount(String username, String password, String Firstname, String Lastname, String sessionkey)
    {
    	MultivaluedMap<String, String> queryParams1 = new MultivaluedMapImpl();
    	queryParams1.add("username", username);
    	queryParams1.add("password", password);
    	queryParams1.add("firstname", Firstname);
    	queryParams1.add("lastname", Lastname);
    	queryParams1.add("sessionkey", sessionkey);
    	service.path("webapi").path("accountmanagement").path("insertaccount").queryParams(queryParams1).accept(MediaType.APPLICATION_XML).post();
    }
    
    public List<Account> list()
    {
    	return (List<Account>) service.path("webapi").path("accountmanagement").path("list").accept(MediaType.APPLICATION_XML).get(new GenericType<List<Account>>(){});
    }
    
    public List<History> getHistory(int id) 
    {
    	return (List<History>) service.path("webapi").path("searchmanagement").path("history").queryParam("accountid", String.valueOf(id)).accept(MediaType.APPLICATION_XML).get(new GenericType<List<History>>(){});
    }
    
    //String s = service.queryParams(queryParameters).get(String.class);
    /*
    ClientResponse response = service.path("webapi").path("accountmanagement")
            .accept(MediaType.APPLICATION_XML)
            .get(ClientResponse.class);
    */
    
    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8181/SWazam").build();
     }
}
