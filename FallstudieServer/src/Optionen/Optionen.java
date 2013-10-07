package Optionen;

public class Optionen {
	private static String jdbcurl = "jdbc:mysql://localhost/leistungkonzept";
	private static String jdbcuser = "root";
	private static String jdbcpw = "hermann";

	public static String getJdbcuser() {
		return jdbcuser;
	}

	public static String getJdbcpw() {
		return jdbcpw;
	}

	public static String getJdbcurl() {
		return jdbcurl;
	}

}
