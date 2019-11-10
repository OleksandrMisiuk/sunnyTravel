package com.santa.techtest.utils;

import java.util.Objects;

public final class ExceptionResponse {
    private final String url;
    private final String message;

    private ExceptionResponse(String url, String message) {
        this.url = url;
        this.message = message;
    }

    public static ExceptionResponseBuilder builder() {
        return new ExceptionResponseBuilder();
    }

    public static class ExceptionResponseBuilder {
        private String url;
        private String message;

        ExceptionResponseBuilder() {}

        public ExceptionResponseBuilder url(String url) {
            this.url = url;
            return this;
        }

        public ExceptionResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ExceptionResponse build() {
            return new ExceptionResponse(url, message);
        }

    }

    public String getUrl() {
        return url;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "url='" + url + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExceptionResponse)) return false;
        ExceptionResponse that = (ExceptionResponse) o;
        return url.equals(that.url) &&
                message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, message);
    }
}