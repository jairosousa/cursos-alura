package com.jnsdev.backend.dto.error;

import java.util.Date;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 16:08
 */
public class ErrorDTO {

    private int status;
    private String message;
    private Date timestamp;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
