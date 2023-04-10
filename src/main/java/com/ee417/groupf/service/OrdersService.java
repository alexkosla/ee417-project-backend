package com.ee417.groupf.service;

import com.ee417.groupf.model.Order;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    public OrdersService() {

    }

    public List<Order> listOrders() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("json/orders.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Order>>() {
        });
    }

    public List<JsonNode> getOrdersByOrderId(String orderId) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("json/orders.json");// getting JSON path as class resource path because if we give normal path it fails when creating WAR file.
        String jsonContent = Files.readString(Paths.get(resource.getURI()));// reading json as a string
        JsonNode jsonNode = objectMapper.readTree(jsonContent);// converting JSON str as json node object

        List<JsonNode> filteredData = new ArrayList<>();
        for (JsonNode node : jsonNode) {
            if (node.get("orderId").asText().equals(orderId)) {// filtering to get the orderId node
                filteredData.add(node);// when matches we take that data and add to filteredData and finally return it to rest controller
            }
        }
        return filteredData;
    }

    public void saveOrder(Order order) throws IOException {
        String filename = "orders.json";
        String filePath = "src/main/resources/json/" + filename;

        File file = new File(filePath);
        if (!file.exists()) {// creates new file if the file is not present already
            file.createNewFile();
            System.out.println("createNewFile===================");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        ObjectWriter writer = mapper.writerFor(new TypeReference<List<Order>>() {
        });
        //ObjectWriter for the type reference List<PersonalEventForm>.
        //created an empty List<Order> object to hold data from the JSON file
        List<Order> corporateEventFormsData = new ArrayList<>();

        if (file.length() > 0) {//If the file length is greater than 0, we read existing data from the JSON file and adds it to the List<PersonalEventForm>.
            System.out.println("add data===================");
            corporateEventFormsData = mapper.readValue(file, new TypeReference<List<Order>>() {
            });
        }
        System.out.println("append data===================");

        corporateEventFormsData.add(order);// appending data

        writer.writeValue(file, corporateEventFormsData);// writing to JSON file
    }

    public boolean deleteOrderByOrderId(String orderId) throws IOException {
        boolean deleted = false;
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("json/orders.json");
        String jsonContent = Files.readString(Paths.get(resource.getURI()));
        JsonNode jsonNode = objectMapper.readTree(jsonContent);

        ArrayNode updatedJson = objectMapper.createArrayNode();
        for (JsonNode node : jsonNode) {
            if (!node.get("orderId").asText().equals(orderId)) {
                updatedJson.add(node);
            } else {
                deleted = true;
            }
        }
        if (deleted) {
            String updatedJsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(updatedJson);
            Files.writeString(Paths.get(resource.getURI()), updatedJsonString);// correcting the method to write the string to the file
        }
        return deleted;
    }


}
