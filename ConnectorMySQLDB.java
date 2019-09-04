import java.sql.*;

public class ConnectorMySQLDB {

    private String  dbMySQL = "jdbc:mysql://localhost/Ejemplo",
                    user = "admin",
                    password = "";

    public ConnectorMySQLDB(){

        try{
         //indicamos el driver y lo instanciamos
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //creamos la conexion DB , user , password
            Connection conn = DriverManager.getConnection(dbMySQL, user, password);

            if ( conn != null ){//se revisa si la conexión fue satisfactoria
                System.out.println("Conexión satisfactoria");
                conn.close();//se cierra la conexión
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
