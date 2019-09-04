

public class controller {
    private static ConnectorMySQLDB conn;

    public static  ConnectorMySQLDB getConnector(){
        if (conn == null)
            return conn = new ConnectorMySQLDB();
        else
            return conn;
    }
}
