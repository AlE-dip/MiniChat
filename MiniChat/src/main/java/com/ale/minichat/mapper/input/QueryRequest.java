package com.ale.minichat.mapper.input;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QueryRequest {
    @NotNull(message = "page not blank")
    private Integer page;
    @NotNull(message = "size not blank")
    private Integer size;
    private String sortBy;
    private String sortType;
}
