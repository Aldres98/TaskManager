package taskManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Database {
    
        private final String url = "jdbc:postgresql://localhost/tasksdb";
        private final String user = "postgres";
        private final String password = "31415926";

        public Connection connect() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the PostgreSQL server successfully.");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return conn;
        }

        public void createItem(int idCur, String title, String description, LocalDate date){
            try {
                Statement stmnt = null;
                stmnt = connect().createStatement();
                String sql = "INSERT INTO TASKS (ID,TITLE,DESCRIPTION,DATE) "
                        + "VALUES " + "(" + idCur +", " + title + ", " + description + ", " + date + ");";
                stmnt.executeUpdate(sql);

            }
            catch (SQLException e ){
                System.out.println(e.getMessage());
            }

        }

        public static void main(String[] args) {
            Database database = new Database();
            database.connect();
            Task task = new Task("Test2", "Test2 description", "MAY 19 1998");
            database.createItem(2, task.getTitle(), task.getDescription(), task.getDateFormat());
        }
    }

