package Optionen;

public class Optionen {
	private final static String jdbcurl = "jdbc:mysql://localhost/leistungkonzept";
	private final static String jdbcuser = "root";
	private final static String jdbcpw = "hermann";
	private final static String webserverURL = "http://localhost:8888/WSExample/simple";

	public static String getJdbcuser() {
		return jdbcuser;
	}

	public static String getJdbcpw() {
		return jdbcpw;
	}

	public static String getJdbcurl() {
		return jdbcurl;
	}

	public static String getWebserverURL() {
		return webserverURL;
	}
}
