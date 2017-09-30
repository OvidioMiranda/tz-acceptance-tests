package gradle.cucumber.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
    public String getPeople() {
        Client client = Client.create();

        WebResource webResource = client.resource(getServiceUrl() + "/people");

        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        return response.getEntity(String.class);
    }

    public void postPerson(String name, String title) {
        Client client = Client.create();

        WebResource webResource = client.resource(getServiceUrl() + "/people");

        String input = "{\"fullName\":\"" + name + "\",\"jobTitle\":\"" + title + "\"}";

        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
    }

    private String getServiceUrl() {
        return System.getProperty("rest.service.url", "http://localhost:8080");
    }
}
