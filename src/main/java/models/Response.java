package models;

import constants.RETURN;

public class Response {
	
	private Integer status;
	private String message;
	private Object result;
	
	public Response(Integer status, String message, Object result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
	}
	
	public Response(RETURN error) {
		super();
		this.status = error.getCode();
		this.message = error.getMsg();
		this.result = null;
		
	}
	public Response(RETURN success, Object m1) {
		super();
		this.status = success.getCode();
		this.message = success.getMsg();
		this.result = m1;		
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	

}
