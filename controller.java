import java.sql.*;

public class controller {

    private Connection conn;
    private String query;
    private final String    table = "postres",
                            hostName= "localhost",
                            port = "3306",
                            database = "Postres",
                        //jdbc:mysql://localhost:3306/
                            url = "jdbc:mysql://"+hostName+":"+port+"/"+database+"?autoReconnect=true&useSSL=false",
                            user = "root",
                            password  = "admin";

    public Connection getConnector(){
        if(conn==null){
            sms("se intentara conectar a la base datos");
            try{
                sms("intentando conectarce mysql");
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
                if ( conn != null )     sms("Conexión satisfactoria");
            }catch( SQLTimeoutException e ){
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void insert (Connection conn, String postre){
        try {
            query = "INSERT INTO " + this.table + "(nom) VALUES('"+postre+"');";
            //if(!exists(conn, postre)) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.execute();
            //}

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    // SELECT nom FROM postres P WHERE p.nom = ?
    private boolean exists(Connection conn, String postre) throws SQLException {
        boolean resp = false;
        String nomPostre;
        try{
            PreparedStatement query = conn.prepareStatement("SELECT nom FROM "+this.table+" p WHERE p.nom = ?");
            query.setString(1, postre);

            ResultSet resultado = query.executeQuery();
            System.out.println(resultado.toString());

            nomPostre = resultado.getString("nom");
            System.out.println(nomPostre);
             if (nomPostre != "" || nomPostre != null) { resp = true;}

        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return resp;
    }

    private void sms(String cad){   System.out.println(cad); }
}
