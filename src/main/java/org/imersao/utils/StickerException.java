package org.imersao.utils;

public class StickerException extends RuntimeException {

    int httpStatus = 500;
    
    public StickerException(String message, int httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

}
