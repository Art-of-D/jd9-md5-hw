package org.db;


import org.utils.URLSetter;
import java.sql.*;
import java.util.List;

public class DatabasePopulateService {
    private static PreparedStatement stment;
    private static  Connection data;

    private void setDbPop1() throws SQLException {
        String dbPop1 = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";
        List<String> list1 = List.of("Art",  "John", "Tom", "Tom", "Jojo", "Alice", "Lola", "Lisa", "Betty", "Mila");
        List<String> list2 = List.of( "2000-01-01","1999-01-01", "1997-01-01", "1998-12-01", "1995-12-01",  "2003-11-10", "2000-05-09",  "1997-07-27", "1995-10-05","2005-05-05");
        List<String> list3 = List.of( "Junior", "Junior", "Junior", "Junior", "Senior", "Trainee", "Middle", "Middle", "Senior", "Trainee");
        List<Integer> list4 = List.of( 101, 999, 888, 950, 53000, 300, 8000, 9000, 99999, 800);
        stment = data.prepareStatement(dbPop1);

        for (int i = 0; i < list1.size(); i++){
            stment.setString(1, list1.get(i));
            stment.setDate(2, Date.valueOf(list2.get(i)));
            stment.setString(3, list3.get(i));
            stment.setInt(4, list4.get(i));
            stment.execute();
            data.commit();
        }
    }

    private void setDbPop2() throws SQLException {
        String dbPop2 = "INSERT INTO client (name) VALUES (?)";
        List<String> list1 = List.of("Emily",  "Miranda", "Julia", "Olga", "Mike", "Tomas");
        stment = data.prepareStatement(dbPop2);
        System.out.println("f");
        for (int i = 0; i < list1.size(); i++){
            stment.setString(1, list1.get(i));
            stment.execute();
            data.commit();
        }
    }

    private void setDbPop3() throws SQLException {
        String dbPop3 = "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)";
        List<Integer> list1 = List.of( 1, 1, 2, 2, 3, 3, 4, 4, 1, 5, 5, 6, 4);
        List<String> list2 = List.of( "2003-01-01","2003-01-01", "2003-03-01", "2005-05-01", "2004-02-01",  "2008-10-03", "2009-03-05",  "2010-12-19", "2011-01-07","2012-03-10", "2013-06-15", "2018-04-17", "2019-11-07");
        List<String> list3 = List.of( "2010-10-10","2010-10-10", "2004-10-10", "2007-09-09", "2011-01-15",  "2009-11-11", "2010-12-13",  "2011-09-15", "2017-06-01","2015-07-12", "2018-03-18", "2022-09-23", "2023-02-21");
        stment = data.prepareStatement(dbPop3);
        System.out.println("f");
        for (int i = 0; i < list1.size(); i++){
            stment.setInt(1, list1.get(i));
            stment.setDate(2, Date.valueOf(list2.get(i)));
            stment.setDate(3, Date.valueOf(list3.get(i)));
            stment.execute();
            data.commit();
        }
    }

    private void setDbPop4() throws SQLException {
        String dbPop4 = "INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES (?,?)";
        List<Integer> list1 = List.of(1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8, 8, 8, 8,
                9, 9, 9 ,9, 10, 10, 10, 11, 11, 11, 11, 12, 12, 12, 12, 12);
        List<Integer> list2 = List.of(2, 3, 4, 9, 3, 4, 6, 5, 6, 7, 8, 10, 2, 3, 1, 5, 6, 4, 9, 1, 2, 3, 5, 6,
                8, 7, 9, 10, 4, 5, 9, 1, 2, 3, 6, 1, 4, 5, 10, 9);
        stment = data.prepareStatement(dbPop4);
        System.out.println("f");
        for (int i = 0; i < list1.size(); i++){
            stment.setInt(1, list1.get(i));
            stment.setInt(2, list2.get(i));
            stment.execute();
            data.commit();
        }
    }

    public static void main(String[] args) throws SQLException {
        DatabasePopulateService populate = new DatabasePopulateService();
        String url_init_db = String.valueOf(new URLSetter().getMap().get("init_db"));

        try {
            data = new Database(url_init_db).getInstance().getConnection();
            data.setAutoCommit(false);

            populate.setDbPop1();
            populate.setDbPop2();
            populate.setDbPop3();
            populate.setDbPop4();
            stment.execute();
            stment.close();
            data.close();
        } catch (Exception ex) {
            data.rollback();
        } finally {
            data.setAutoCommit(true);
        }
    }
}
