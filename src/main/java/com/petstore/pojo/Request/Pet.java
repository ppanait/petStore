package com.petstore.pojo.Request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
@Getter @Setter
@NoArgsConstructor
public class Pet {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("photoUrls")
    private List<String> photoUrl;

    @JsonProperty("tags")
    private List<Tag> tags;

    @JsonProperty("status")
    private Status status;
}
