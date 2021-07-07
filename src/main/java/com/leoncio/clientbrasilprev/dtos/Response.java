package com.leoncio.clientbrasilprev.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private List<ErrorDTO> errors;
    private Object data;

    public Response(List<ErrorDTO> errors) {
        this.errors = errors;
    }

    public Response(Object data) {
        this.data = data;
    }
}
