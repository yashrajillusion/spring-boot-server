package com.illusioncart.springserver.model.response;

import lombok.Data;

@Data
public class CommonResponse {
    String message;
    Integer statusCode;
    String accessToken;
}
