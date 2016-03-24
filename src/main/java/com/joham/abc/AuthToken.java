package com.joham.abc;

import java.io.Serializable;

public class AuthToken implements Serializable{

	/**
	 * @author herion
	 * 2015-7-26 下午6:54:24
	 */
	private static final long serialVersionUID = -4291175015795922791L;
	private String client_id;
	private String redirect_url;
	private String return_param;
	private String sign;
	private String scope;
	private String user_scope;
	private String requestXml;
	
	
	
//	public String getSession_id() {
//		return session_id;
//	}
//	public void setSession_id(String session_id) {
//		this.session_id = session_id;
//	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getRedirect_url() {
		return redirect_url;
	}
	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}
	public String getReturn_param() {
		return return_param;
	}
	public void setReturn_param(String return_param) {
		this.return_param = return_param;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
	
	
	
	public String getRequestXml() {
		return requestXml;
	}
	public void setRequestXml(String requestXml) {
		this.requestXml = requestXml;
	}
	public String values(String secret){
		StringBuffer sb=new StringBuffer();
		sb.append(client_id);
		sb.append(scope);
		sb.append(secret);
		sb.append(redirect_url);
		sb.append(return_param);
		return sb.toString();
	}
	
	public String getUser_scope() {
		return user_scope;
	}
	public void setUser_scope(String user_scope) {
		this.user_scope = user_scope;
	}
	@Override
	public String toString() {
		return "AuthToken [client_id="
				+ client_id + ", redirect_url=" + redirect_url
				+ ", return_param=" + return_param + ", sign=" + sign
				+ ", scope=" + scope + ", user_scope=" + user_scope
				+ ", requestXml=" + requestXml + "]";
	}
	
}
