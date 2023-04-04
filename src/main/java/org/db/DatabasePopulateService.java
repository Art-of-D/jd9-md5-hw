package org.db;

import org.selection_classes.ProjectPrices;
import org.utils.URLSetter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabasePopulateService {
    static PreparedStatement stment;
    static  Connection data;
    public static void main(String[] args) throws SQLException {
        String url_populate = String.valueOf(new URLSetter().getMap().get("populate_db"));
        String url_init_db = String.valueOf(new URLSetter().getMap().get("init_db"));
        try {
            data = new Database(url_init_db).getInstance().getConnection();
            data.setAutoCommit(false);
            List<String> allLines = Files.readAllLines(Paths.get("src/main/resources/" + url_populate).toAbsolutePath());
            StringBuilder sb = new StringBuilder();
            String sql_query = "";
            for (String this_line : allLines) {
                if (this_line != null) sb.append(this_line);
            }
            sql_query = String.valueOf(sb);
            stment = data.prepareStatement(sql_query);
            stment.executeUpdate();
            data.commit();
            stment.close();
            data.close();
        } catch (Exception ex) {
            data.rollback();
        } finally {
            data.setAutoCommit(true);
        }
    }
}
