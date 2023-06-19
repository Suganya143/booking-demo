package api.app.commons;

public class AppUtils 
{
	private int statusCode;
	private String responseData;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public AppUtils(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
	
	public AppUtils(int statusCode, String responseData) {
		this.statusCode = statusCode;
		this.responseData = responseData;		
	}
}
