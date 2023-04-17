package com.blogging.blog_project.exceptions.ResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    long fieldValue;
    public ResourceNotFoundException() {
        super("Resource not found!");
    }
    public ResourceNotFoundException(String resource, String fieldName, long fieldValue) {
        super(String.format("Resource: %s, Field: %s, Value: %d, Exception: Not found", resource, fieldName, fieldValue));
    }
}
