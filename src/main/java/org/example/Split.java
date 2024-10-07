package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Split {

        public int id;
        public String name;
        public String address;

        public Split(int id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        // Default constructor is required for Jackson
        public void Split() {}

    public static void main(String[] args) {
        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        List<Split> userList = new ArrayList<>();
        userList.add(new Split(1, "Jatin","Pune"));
        userList.add(new Split(2, "Manish","Mumbai"));
        userList.add(new Split(3, "Dev","Thane"));
        userList.add(new Split(4, "Amit","Pimpri"));
        userList.add(new Split(5, "Seema","Satara"));

        try {
            // Write the list to a JSON file
            mapper.writeValue(new File("C:\\Users\\Supriya Pandit\\IdeaProjects\\Sample1\\src\\main\\resources\\users.json"), userList);
            System.out.println("JSON file 'users.json' created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Read JSON file into a List of Maps (you can also use custom objects)
            List<Map<String, Object>> dataList = mapper.readValue(
                    new File("C:\\Users\\Supriya Pandit\\IdeaProjects\\Sample1\\src\\main\\resources\\users.json"), new TypeReference<List<Map<String, Object>>>(){}
            );

            // Determine split size, e.g., split into chunks of 2
            int chunkSize = 1;

            // Split data and write to separate files
            int fileCount = 1;
            for (int i = 0; i < dataList.size(); i += chunkSize) {
                // Get the sublist
                List<Map<String, Object>> subList = dataList.subList(i, Math.min(i + chunkSize, dataList.size()));

                // Write each chunk to a new file
                mapper.writeValue(new File("C:\\Users\\Supriya Pandit\\IdeaProjects\\Sample1\\src\\main\\resources\\output_" + fileCount + ".json"), subList);
                fileCount++;
            }

            System.out.println("JSON file split into smaller files successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
