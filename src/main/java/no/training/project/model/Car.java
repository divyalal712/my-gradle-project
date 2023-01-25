package no.training.project.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Car{
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CarObject carObject = new CarObject("Aadi", 25,"Natinpuram");
        String carAsString = objectMapper.writeValueAsString(carObject);
        System.out.print(carAsString);
    }
}

























/*
package no.training.project.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Car {
    private static final String FILE_NAME="";
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CarObject car = new CarObject("red","ID4");

        String carAsString = objectMapper.writeValueAsString(car);

        System.out.print(carAsString);
        objectMapper.writeValue(new File("src/main/resources/target/objmap.json"), car);
    }
}
*/

