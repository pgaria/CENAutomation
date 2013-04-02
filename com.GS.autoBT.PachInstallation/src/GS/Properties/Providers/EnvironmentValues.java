package GS.Properties.Providers;

public class EnvironmentValues {
	//USe the getter and setter values to get the runtime config values
	

	// Application Server Details
	private  String ApplicationName = null;
	private  String applicationServerPort = null;
	private  String applicationServerHostName = null;
	private String WebLogicUserName = null;
	private  String WebLogicPassword = null;
	private  String JNDIName = null;

	// Data Base parameters form RuntimeConfig File

	private  String DBSysUserName = null;
	private  String DBSysPwd = null;
	private  String DBService = null;
	private  String DBHostName = null;
	private  String DataBasePortNO = null;
	private  String DBSchemaName = null;
	private  String DBSchemaPwd = null;
	
	
	public  String getApplicationName() {
		return ApplicationName;
	}
	public  void setApplicationName(String applicationName) {
		ApplicationName = applicationName;
	}
	public  String getApplicationServerPort() {
		return applicationServerPort;
	}
	public  void setApplicationServerPort(String applicationServerPort) {
		applicationServerPort = applicationServerPort;
	}
	public  String getApplicationServerHostName() {
		return applicationServerHostName;
	}
	public  void setApplicationServerHostName(String applicationServerHostName) {
		applicationServerHostName = applicationServerHostName;
	}
	public  String getWebLogicUserName() {
		return WebLogicUserName;
	}
	public  void setWebLogicUserName(String webLogicUserName) {
		WebLogicUserName = webLogicUserName;
	}
	public  String getWebLogicPassword() {
		return WebLogicPassword;
	}
	public  void setWebLogicPassword(String webLogicPassword) {
		WebLogicPassword = webLogicPassword;
	}
	public  String getJNDIName() {
		return JNDIName;
	}
	public  void setJNDIName(String jNDIName) {
		JNDIName = jNDIName;
	}
	public  String getDBSysUserName() {
		return DBSysUserName;
	}
	public  void setDBSysUserName(String dBSysUserName) {
		DBSysUserName = dBSysUserName;
	}
	public  String getDBSysPwd() {
		return DBSysPwd;
	}
	public  void setDBSysPwd(String dBSysPwd) {
		DBSysPwd = dBSysPwd;
	}
	public  String getDBService() {
		return DBService;
	}
	public  void setDBService(String dBService) {
		DBService = dBService;
	}
	public  String getDBHostName() {
		return DBHostName;
	}
	public  void setDBHostName(String dBHostName) {
		DBHostName = dBHostName;
	}
	public  String getDataBasePortNO() {
		return DataBasePortNO;
	}
	public  void setDataBasePortNO(String dataBasePortNO) {
		DataBasePortNO = dataBasePortNO;
	}
	public  String getDBSchemaName() {
		return DBSchemaName;
	}
	public  void setDBSchemaName(String dBSchemaName) {
		DBSchemaName = dBSchemaName;
	}
	public  String getDBSchemaPwd() {
		return DBSchemaPwd;
	}
	public  void setDBSchemaPwd(String dBSchemaPwd) {
		DBSchemaPwd = dBSchemaPwd;
	}
	
	
	

}
