package com.petstore.pojo.Response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
@NoArgsConstructor
@Getter @Setter
public class ResponsePet {

    private Integer code;
    private String type;
    private String message;

}
