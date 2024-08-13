package org.samim.misc;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.io.CloseMode;

public class HttpCallWithHttpClient {

    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpHost host = HttpHost.create("http://localhost:8080");
            HttpGet getRequest = new HttpGet("/get_req");

            try (ClassicHttpResponse response = httpClient.executeOpen(host, getRequest, HttpClientContext.create())) {
                System.out.println("Response Code: " + response.getCode());
                System.out.println("Response Body: " + new String(response.getEntity().getContent().readAllBytes()));
            }

            HttpPost postRequest = new HttpPost("/post_req");
//            postRequest.setHeader("Content-Type", "application/json");
//            postRequest.setHeader("Authorization", "Bearer your_token");
            String json = "{\"name\":\"John\",\"id\":\"777\"}";
            System.out.println(json);
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            postRequest.setEntity(entity);

            try (ClassicHttpResponse response = httpClient.executeOpen(host, postRequest, HttpClientContext.create())) {
                System.out.println("Response Code: " + response.getCode());
                System.out.println("Response Body: " + new String(response.getEntity().getContent().readAllBytes()));
            }

            httpClient.close(CloseMode.GRACEFUL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
