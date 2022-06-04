package com.shoppingapp.revature.error;

import lombok.Data;
import java.time.*;

@Data
public class ApiError {
    private LocalDateTime timeStamp;
    private int status;
    private String message;
    private String debugMessage;
}
