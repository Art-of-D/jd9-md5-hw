package org.utils;

import org.db.DatabaseInitService;
import org.db.DatabasePopulateService;
import org.db.DatabaseQueryService;
import org.selection_classes.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Choice {
    public void giveChoice() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please do your choice:\n 1) Creat the tables (enter 1)\n 2) Populate the tables (enter 2)" +
                "\n 3) Do query from tables (enter 3)\n enter 0 to exit");
        Integer choice = in.nextInt();
        switch (choice) {
            case (1):
                String [] arguments1 = new String[]{"123"};
                DatabaseInitService.main(arguments1);
                break;
            case (2):
                String [] arguments2 = new String[]{"123"};
                DatabasePopulateService.main(arguments2);
                break;
            case (3):
                System.out.println("1 - find_max_salary_worker;\n2 - find_max_projects_client;\n3 - " +
                        "find_longest_project;\n4 - find_youngest_eldest_workers;\n5-  print_project_prices");
                Integer choiceQuery = in.nextInt();
                switch (choiceQuery) {
                    case (1):
                        List<MaxSalaryWorker> list1 = new DatabaseQueryService().maxSalaryWorkersList();
                        for (MaxSalaryWorker maxSalaryWorker : list1) {
                            System.out.println("Name - " + maxSalaryWorker.getName() +
                                    ", Salary - " + maxSalaryWorker.getSalary());
                        }
                        break;
                    case (2):
                        List<MaxProjectClient> list2 = new DatabaseQueryService().maxProjectClientsList();
                        for (MaxProjectClient maxProjectClient : list2) {
                            System.out.println("Name - " + maxProjectClient.getName() +
                                    ", Project count - " + maxProjectClient.getProject_count());
                        }
                        break;
                    case (3):
                        List<LongestProject> list3 = new DatabaseQueryService().longestProjectList();
                        for (LongestProject lproject : list3) {
                            System.out.println("Name - " + lproject.getName() +
                                    ", Month count - " + lproject.getMonth_count());
                        }
                        break;
                    case (4):
                        List<YoungestEldestWorker> list4 = new DatabaseQueryService().youngestEldestWorkerList();
                        for (YoungestEldestWorker youngestEldestWorker : list4) {
                            System.out.println("Type:" + youngestEldestWorker.getType() +
                                    ", Name - " + youngestEldestWorker.getName() +
                                    ", Birthday - " + youngestEldestWorker.getBirthday());
                        }
                        break;
                    case (5):
                        List<ProjectPrices> list5 = new DatabaseQueryService().projectPricesList();
                        for (ProjectPrices projectPrices : list5) {
                            System.out.println("Name - " + projectPrices.getName() +
                                    ", Price - " + projectPrices.getPrice());
                        }
                        break;
                    case (0):
                        break;
                    }
            case(0):
                break;
            default:
                System.out.println("Please choose something!");
        }
    }
}
