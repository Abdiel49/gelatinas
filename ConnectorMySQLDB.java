import java.sql.*;

public class ConnectorMySQLDB {

    private String  hostName= "localhost",
                    port = "3306",
                    database = "Postres",

                    url = "jdbc:mysql://"+hostName+":"+port+"/"+database,
                    user = "root",
                    password = "admin";

    public ConnectorMySQLDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(url, user, password);
            if ( conn != null ){
                System.out.println("Conexión satisfactoria");
                conn.close();
            }
        }catch( SQLTimeoutException e ){
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
