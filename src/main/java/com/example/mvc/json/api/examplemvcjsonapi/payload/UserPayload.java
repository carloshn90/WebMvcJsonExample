package com.example.mvc.json.api.examplemvcjsonapi.payload;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class UserPayload implements Serializable {

    public static final long serialVersionUID = -6398220852307357948L;

    private final String name;
}
