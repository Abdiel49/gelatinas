
import java.sql.SQLException;

public class main {
    public static void main(String[]args) throws SQLException {
        controller ctr = new controller();
        String postre = "yogurt";
        ctr.insert( ctr.getConnector(), postre);
    }
}
