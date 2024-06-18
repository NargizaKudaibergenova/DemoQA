package com.demoqa.entities;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor //обьекты со всеми полями
@NoArgsConstructor //пустой конструктор
@ToString
@EqualsAndHashCode
@Builder
public class PracticeFormEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String DateOfBirth;
    private String subjects;
    private String picture;
    private String state;
    private String city;
    private String currentAddress;
}