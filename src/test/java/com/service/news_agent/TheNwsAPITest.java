package com.service.news_agent;

import org.junit.jupiter.api.Test;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

// @SpringBootTest
class TheNwsAPITest {
    private static final String API_KEY = "T85tKj5WFVoeypAo7qjikcvFr8tpj5fV09ZiaEZS"; // Replace with your API key

    @Test
    void topNewsTest() {
        final String NEWS_API_URL = "https://api.thenewsapi.com/v1/news/top?api_token=" + API_KEY + "&locale=kr&language=ko";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(NEWS_API_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String jsonResponse = response.body().string();
                parseNewsResponse(jsonResponse);
            } else {
                System.out.println("Request failed: " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void allNewsTest() {
        final String NEWS_API_URL = "https://api.thenewsapi.com/v1/news/all?api_token=" + API_KEY + "&locale=kr&language=ko&categories=science";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(NEWS_API_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String jsonResponse = response.body().string();
                parseNewsResponse(jsonResponse);
            } else {
                System.out.println("Request failed: " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void sourceTest() {
        final String NEWS_API_URL = "https://api.thenewsapi.com/v1/news/sources?api_token=" + API_KEY + "&locale=kr&language=ko";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(NEWS_API_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String jsonResponse = response.body().string();
                parseNewsResponse(jsonResponse);
            } else {
                System.out.println("Request failed: " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseNewsResponse(String jsonResponse) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
        JsonArray articles = jsonObject.getAsJsonArray("data");

        for (int i = 0; i < articles.size(); i++) {
            JsonObject article = articles.get(i).getAsJsonObject();
            String title = article.get("title").getAsString();
            String description = article.get("description").getAsString();
            String url = article.get("url").getAsString();

            System.out.println("Title: " + title);
            System.out.println("Description: " + description);
            System.out.println("URL: " + url);
            System.out.println("---------");
        }
    }
}
