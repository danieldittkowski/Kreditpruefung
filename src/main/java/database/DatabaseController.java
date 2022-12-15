package database;

import backend.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseController {

    public Connection connectToDatabase(String databaseName, String username, String password) {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+databaseName,username,password);
            System.out.println("verbunden");
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return connection;
    }

    public void createTable(Connection connection, String tableName) {
        try {
            String query = String.format("CREATE TABLE %s(ID SERIAL, PRIMARY KEY (ID));", tableName);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            System.out.println("Table was created successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addColumnToTable(Connection connection, String tableName, String columnName, String colomnType, String constraint) {
        try {
            String query = String.format("ALTER TABLE %s ADD %s %s %s;", tableName, columnName, colomnType, constraint);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private void addForeignKeyToTable(Connection connection, String tableName, String foreignKey, String keyOrigin, String primaryKeyOrigin) {
        try {
            String query = String.format("ALTER TABLE %s ADD FOREIGN KEY (%s) REFERENCES %s(%s);", tableName, foreignKey, keyOrigin, primaryKeyOrigin);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createTablePERSON(Connection connection) {
        String tableName = "PERSON";
        createTable(connection, tableName);
        addColumnToTable(connection, tableName, "VORNAME", "VARCHAR(50)", "");
        addColumnToTable(connection, tableName, "NACHNAME", "VARCHAR(50)", "");
        addColumnToTable(connection, tableName, "USERNAME", "VARCHAR(50)", "");
        addColumnToTable(connection, tableName, "PASSWORD", "VARCHAR(50)", "");
        addColumnToTable(connection, tableName, "ROLLE", "VARCHAR(11)", "");
        addColumnToTable(connection, tableName, "VORGESETZTER", "INTEGER", "");
        addForeignKeyToTable(connection, tableName, "VORGESETZTER", tableName, "ID");
    }

    public void addKundeToPerson(Connection connection, String vorname, String nachname, String username, String password, String rolle) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO PERSON (VORNAME, NACHNAME, USERNAME, PASSWORD, ROLLE) VALUES ( '%s', '%s', '%s', '%s', '%s' );", vorname, nachname, username, password, rolle);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Kunde was inserted succesfully");


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addMitarbeiterToPerson(Connection connection, String vorname, String nachname, String username, String password, String rolle, Integer vorgesetzter) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO PERSON (VORNAME, NACHNAME, USERNAME, PASSWORD, ROLLE, VORGESETZTER) VALUES ( '%s', '%s', '%s', '%s', '%s', '%s');", vorname, nachname, username, password, rolle, vorgesetzter);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Mitarbeiter was inserted succesfully");


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Person getPersonByUsername(Connection connection, String username) {
        Person person = null;
        ResultSet resultSet;
        Statement statement;
        try {
            String query = String.format("SELECT * FROM Person WHERE username = '%s'", username);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet != null) {
                while (resultSet.next()) {
                    String usernameString = resultSet.getString("username");
                    if (resultSet.getString("rolle").equals("KUNDE")) {
                        String rolleCapitalized = resultSet.getString("rolle").toUpperCase(); // Uppercase, weil Enum-values sind Uppercase definiert
                        person = new Kunde(
                                resultSet.getInt("id"),
                                resultSet.getString("vorname"),
                                resultSet.getString("nachname"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                Rolle.valueOf(rolleCapitalized));
                    } else {
                        String rolleCapitalized = resultSet.getString("rolle").toUpperCase();
                        person = new Mitarbeiter(
                                resultSet.getInt("id"),
                                resultSet.getString("vorname"),
                                resultSet.getString("nachname"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                Rolle.valueOf(rolleCapitalized),
                                resultSet.getInt("vorgesetzter"));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (person != null) {
            return person;
        } else {
            throw new NullPointerException("Der 'username' existiert nicht.");
        }
    }
}