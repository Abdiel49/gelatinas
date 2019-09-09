import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static void main(String[]args) throws SQLException {
        System.out.println("holamundo");
        //formMain form = new formMain();
        controller ctr = new controller();
        String postre = "helado";
        //ctr.useDataBase(ctr.getConnector());
        ctr.insert( ctr.getConnector(), postre);
        System.out.println("revisa la base de datos");
    }

}
