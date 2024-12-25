package com.banking.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;


public class ResponseEntityObject {
private String message;
@Nullable
private String token;

public ResponseEntityObject(String message, String token) {
	super();
	this.message = message;
	this.token = token;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
@Override
public String toString() {
	return "ResponseEntityObject [message=" + message + ", token=" + token + "]";
}

}
