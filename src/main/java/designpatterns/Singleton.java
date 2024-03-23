package designpatterns;

public class Singleton {


    static class DatabaseConnection {
        private static volatile DatabaseConnection instance;
        private String databaseUrl;

        private DatabaseConnection(String databaseUrl) {
            if (instance != null) throw new IllegalStateException("Instance already created");

            this.databaseUrl = databaseUrl;
        }


        public static DatabaseConnection getInstance() {
            if (instance == null) {
                synchronized (DatabaseConnection.class) {
                    if (instance == null) {
                        instance = new DatabaseConnection("jdbc:mysql://localhost:3306/maydatabase");
                    }
                }
            }

            return instance;
        }
    }
}
