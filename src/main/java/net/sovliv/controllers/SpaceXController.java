package net.sovliv.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sovliv.rest.Hybride;
import net.sovliv.rest.Rocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@RestController
public class SpaceXController {
    Logger logger = LoggerFactory.getLogger(SpaceXController.class);

    @RequestMapping("/launch/{id}" )
    public List<Hybride> getLaunches(@PathVariable String id) {
        String launchesJson = jsonGetRequest("https://api.spacexdata.com/v3/launches");

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Hybride> hybrideList = null;
        try {
            hybrideList = objectMapper.readValue(launchesJson, new TypeReference<List<Hybride>>() {});
            logger.info("***DATA LOADED by ID***");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.error("***ERROR***");
        }

        List<Hybride> response = new ArrayList<>();
        for (Hybride hybride : hybrideList) {
            Hybride.Rocket rocket = hybride.getRocket();
            if(id.equals(rocket.getRocket_id())) {
                hybride.setRocket(null);
                response.add(hybride);
            }
        }
        return response;
    }

    @RequestMapping("/rockets")
    public List<String> getRockets() {
        String rocketJson = jsonGetRequest("https://api.spacexdata.com/v3/rockets");

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Rocket> rocketId = null;
        try {
            rocketId = objectMapper.readValue(rocketJson, new TypeReference<List<Rocket>>() {});
            logger.info("***DATA LOADED***");
        } catch (JsonProcessingException e) {
            logger.error("***ERROR***");
            e.printStackTrace();
        }

        List<String> idList = new ArrayList<>();
        for (Rocket rocket : rocketId) {
            idList.add(rocket.getRocket_id());
        }

        //return rocketId.stream().map(i -> i.getRocket_id()).collect(Collectors.toList());
        return idList;
    }

    private static String streamToString(InputStream inputStream) {
        return new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
    }
    private static String jsonGetRequest(String urlQuery) {
        String json = null;

        try {
            URL url = new URL(urlQuery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream); // input stream to string

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

}
