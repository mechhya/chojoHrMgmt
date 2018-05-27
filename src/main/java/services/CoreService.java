package services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CoreService {

    public static <T> T getInfo(String path, T requestEntityType, Class<T> responseClassType) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path(path);
        Response response = target.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(Entity.json(requestEntityType));
        return response.readEntity(responseClassType);
    }

    public static <T> String getInfoInString(String baseUrl, String path, T requestEntityType) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseUrl).path(path);
        Response response = target.request(MediaType.APPLICATION_JSON).accept(MediaType.TEXT_PLAIN).post(Entity.json(requestEntityType));
        if (response.getStatus() == 200) {
            return response.readEntity(String.class);
        } else {
            return null;
        }
    }
}
