package cleancode.function;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;
import javax.sql.DataSource;
import utils.annotation.Compliant;
import utils.annotation.NonCompliant;

public class SideEffectRules {

    private int counter;

    @NonCompliant("Method has side effect and cause method getCounter to return different result")
    public int getCounterNonCompliant() {
        return counter++;
    }

    @Compliant("Method does not have side effect")
    public int getCounter() {
        return counter;
    }

    @Compliant("Side effect extracted to a separate method")
    public void incrementCounter() {
        ++counter;
    }

    @Compliant("Method encapsulates temporal coupled operations together")
    public ResultSet processQuery(DataSource dataSource, Function<Connection, ResultSet> query) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            ResultSet result = query.apply(conn);
            conn.commit();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
