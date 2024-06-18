package com.demoqa.entities;

import lombok.*;

//чтобы не прописывать геттер и сеттер тостринг и т.д. можно вот так:
@Getter
@Setter
@AllArgsConstructor //обьекты со всеми полями
@NoArgsConstructor //пустой конструктор
@ToString
@EqualsAndHashCode
@Builder //помогает создавать сложные обьекты
public class TextBoxEntity {
    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;

}
