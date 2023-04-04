package org.db;

import org.utils.URLSetter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseInitService {
    private static Connection data;
    private static Statement stment;
    public static void main(String[] args) {
        String url = String.valueOf(new URLSetter().getMap().get("init_db"));
        try {
            data = new Database(url).getInstance().getConnection();
            stment = data.createStatement();
            List<String> allLines = Files.readAllLines(Paths.get("src/main/resources/" + url).toAbsolutePath());
            StringBuilder sb = new StringBuilder();
            String sql_query = "";
                for(String this_line: allLines){
                    if (this_line != null) sb.append(this_line);
                }
            sql_query = String.valueOf(sb);
            stment.execute(sql_query);
            stment.close();
            data.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
