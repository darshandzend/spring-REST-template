package constants;

public enum RETURN {
	
	/*General returns*/
	SUCCESS(200, "success"),
	ERROR  (201, "error"),
	
	/*Level 0 returns*/
	ERROR_VALIDATION(301, "The input data you provided isn't valid");
	
	
	private int code;
	private String msg;
	RETURN(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
