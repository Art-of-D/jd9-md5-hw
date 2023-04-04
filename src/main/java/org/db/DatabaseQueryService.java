package org.db;

import org.selection_classes.*;
import org.utils.URLSetter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseQueryService {
    private static final String URL_UNIT_DB= String.valueOf(new URLSetter().getMap().get("init_db"));
    private String inner_url;
    private Connection data;
    public List<LongestProject> longestProjectList() throws SQLException {
        String db_name = "find_longest_project";
        List<LongestProject> list = new ArrayList<>();
        Connection data = new Database(URL_UNIT_DB).getInstance().getConnection();
        PreparedStatement statement = data.prepareStatement(query(db_name));

        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString("name");
            Integer month_count = resultSet.getInt("month_count");
            list.add(new LongestProject(name, month_count));
        }
        return list;
    }

    public List<MaxProjectClient> maxProjectClientsList() throws SQLException {
        String db_name = "find_max_projects_client";
        List<MaxProjectClient> list = new ArrayList<>();
        Connection data = new Database(URL_UNIT_DB).getInstance().getConnection();
        PreparedStatement statement = data.prepareStatement(query(db_name));

        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString("name");
            Integer project_count = resultSet.getInt("project_count");
            list.add(new MaxProjectClient(name, project_count));
        }
        return list;
    }

    public List<MaxSalaryWorker> maxSalaryWorkersList() throws SQLException {
        String db_name = "find_max_salary_worker";
        List<MaxSalaryWorker> list = new ArrayList<>();
        Connection data = new Database(URL_UNIT_DB).getInstance().getConnection();
        PreparedStatement statement = data.prepareStatement(query(db_name));

        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString("name");
            Integer salary = resultSet.getInt("salary");
            list.add(new MaxSalaryWorker(name, salary));
        }
        return list;
    }

    public List<ProjectPrices> projectPricesList() throws SQLException {
        String db_name = "print_project_prices";
        List<ProjectPrices> list = new ArrayList<>();
        Connection data = new Database(URL_UNIT_DB).getInstance().getConnection();
        PreparedStatement statement = data.prepareStatement(query(db_name));

        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString("name");
            Integer price = resultSet.getInt("price");
            list.add(new ProjectPrices(name, price));
        }
        return list;
    }

    public List<YoungestEldestWorker> youngestEldestWorkerList() throws SQLException {
        String db_name = "find_youngest_eldest_workers";
        List<YoungestEldestWorker> list = new ArrayList<>();
        data = new Database(URL_UNIT_DB).getInstance().getConnection();
        PreparedStatement statement = data.prepareStatement(query(db_name));

        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            String type = resultSet.getString("type");
            String name = resultSet.getString("name");
            Date birthday = resultSet.getDate("birthday");
            list.add(new YoungestEldestWorker(type, name, birthday));
        }
        return list;
    }

    private String query(String url){
        inner_url = String.valueOf(new URLSetter().getMap().get(url));
        List<String> allLines;

        try {
            allLines = Files.readAllLines(Paths.get("src/main/resources/" + inner_url).toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder sb = new StringBuilder();
        for(String this_line: allLines){
            if (this_line != null) sb.append(this_line); sb.append("\n");
        }
        return String.valueOf(sb);
    }

}