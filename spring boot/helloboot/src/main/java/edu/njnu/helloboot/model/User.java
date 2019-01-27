package edu.njnu.helloboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;  //primary key
    private String username;
    private String password;
    private String gender;
    private Integer age;    //not int

}
