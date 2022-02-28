package com.petstore.pojo.Request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("naem")
    private String name;

}
