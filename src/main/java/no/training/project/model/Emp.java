package no.training.project.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Emp {
    private static final String FILE_NAME = "src/main/resources/target/emp.json";

    public static void main(String[] args) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
        List<EmpClass> empList = new ArrayList<>();

            Address address = new Address("Nordv12","0722","Kerala", "India");
            EmpClass emp = new EmpClass("dd", 1, address, Arrays.asList("867587843", "78568547698", "785667944"));
             EmpClass emp2 = new EmpClass("sssss", 1, address, Arrays.asList("867587843", "78568547698", "785667944"));

             empList.add(emp);
             empList.add(emp2);
             for(EmpClass employee: empList){
                 System.out.println(employee.getName());
             }

            objectMapper.writeValue(new File(FILE_NAME), emp);
            String empAsString = objectMapper.writeValueAsString(emp);

            System.out.print(empAsString);
        //String addressAsString = obj.writeValueAsString(address);
      //  System.out.print(addressAsString);
        //System.out.print(emp);
    }

}
