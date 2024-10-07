package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class User {
    public int id;
    public String name;
    public String address;

    public User(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Default constructor is required for Jackson
    public User() {}
}

public class CreateJsonFile {
    public static void main(String[] args) {
        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        // Create a list of user objects
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Jatin","Pune"));
        userList.add(new User(2, "Manish","Mumbai"));
        userList.add(new User(3, "Dev","Thane"));
        userList.add(new User(4, "Amit","Pimpri"));
        userList.add(new User(5, "Baban","Satara"));

        try {
            // Write the list to a JSON file
            mapper.writeValue(new File("C:\\Users\\Supriya Pandit\\IdeaProjects\\Sample1\\src\\main\\resources\\users.json"), userList);
            System.out.println("JSON file 'users.json' created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}