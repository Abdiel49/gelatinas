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
            sms("estas intentando entrar a su base de datos");
            try{
                sms("estas tan cerca de entrar a su corazon, vamos campeon tu puedes!!");
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
                if ( conn != null )     sms("Felicidades conseguiste una coneccion estable con ella :)");
                else sms("raioz, diste lo mejor de ti pero aun asi no fue suficiente para ella, intenta en otro momento");
            }catch( SQLTimeoutException e ){
                e.getMessage();
                sms("Lo siento hermano, ella esta ocupada siendo feliz con otro");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                sms("Lo siemto, lo que buscas no lo puedes encontrar");
            } catch (SQLException e) {
                e.printStackTrace();
                sms("ELLA DIJO NO!");
            }
        }
        return conn;
    }

    public void insert (Connection conn, String postre){
        try {
            if(!exists(conn, postre)) {
                sms("tigreee! xD");
                query = "INSERT INTO " + this.table + "(nom) VALUES('"+postre+"');";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.execute();
                sms("buen trabajo campeon, eres una maquina");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private boolean exists(Connection conn, String postre) throws SQLException {
        boolean resp = false;
        String nomPostre;
        try{
            query = "SELECT nom FROM "+this.table+" WHERE nom = '"+postre+"';";
            Statement st = conn.createStatement();
            ResultSet rest = st.executeQuery(query);
            //sms(rest.toString());
            while(rest.next()){
                nomPostre = rest.getString("nom");
                if (!nomPostre.equals("")) {
                    resp = true;
                    sms("no puedes avanzar al siguiente nivel porque ya hay otro en su vida");
                    break;
                }
            }
            st.close();
        }catch(SQLException ex){
            sms("Le duele la cabeza, o sea ahora no");// pd. en este punto ya dejo de ser gracioso :'(
            throw new SQLException(ex);
        }finally {
            return resp;
        }
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close(); // y desde aqui comenzo todo y me fui a la cima xD
                sms("la coneccion con la base de datos termino, asi como ella termino contigo :'( ");
            } catch (SQLException e) {
                e.printStackTrace();
                sms("no pudiste cerrar la coneccion, pero ella si y ya es feliz con otro alv que sad");
            }
        }
    }

    private void sms(String cad){   System.out.println(cad); }

}
