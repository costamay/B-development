package com.bring.sacco.headers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Header {
    private long statusCode;
    private String statusMessage;
    private LocalDateTime timeStamp = LocalDateTime.now();
}
