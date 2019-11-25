package com.sayboard.exception;

/**
 * @outhor moke
 * @date 2019-11-25
 */
public class MsgException extends RuntimeException {
    public MsgException() {
    }

    public MsgException(String message) {
        super(message);
    }
}
