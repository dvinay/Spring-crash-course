package com.fuppino.spring.externalization;

public class Extern {
	private String dbServer;
	private String userId;
	private String password;

	public Extern() {
		super();
	}

	public Extern(String dbServer, String userId, String password) {
		super();
		this.dbServer = dbServer;
		this.userId = userId;
		this.password = password;
	}

	public String getDbServer() {
		return dbServer;
	}

	public void setDbServer(String dbServer) {
		this.dbServer = dbServer;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Extern [dbServer=" + dbServer + ", userId=" + userId
				+ ", password=" + password + "]";
	}
	
	
}
