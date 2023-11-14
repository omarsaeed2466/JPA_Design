package com.example.JPA_Design;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Convert {
    public static void main(String[] args) {
        try {
            // Path to the file
            Path filePath = Paths.get("C:\\Users\\Dirac\\Desktop\\accounting\\SystemDesign\\Folder-1\\File789.xls");

            // Read the file into a byte array
            byte[] fileBytes = Files.readAllBytes(filePath);

            // Convert the byte array to JSON
            String jsonString = convertByteArrayToJson(fileBytes);

            // Print the JSON string
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String convertByteArrayToJson(byte[] byteArray) {
        // Logic to convert the byte array to JSON
        // Construct a JSON object or use a library like Jackson or Gson
        // to convert the byte array to JSON representation

        // Example with Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNode = objectMapper.createObjectNode();
        jsonNode.put("fileData", Base64.getEncoder().encodeToString(byteArray));

        return jsonNode.toString();
    }

}
