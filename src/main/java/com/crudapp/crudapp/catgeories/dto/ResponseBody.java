package com.crudapp.crudapp.catgeories.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseBody {
    private String message;
    private Boolean success;
    private Object data;

}
