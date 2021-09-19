package services;
import data.ExamDAO;
import model.Exam;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class examServices {
    public class ExamService {
        private ExamDAO examDAO;

        public ExamService() {
            examDAO = new ExamDAO();
        }

        public void showAllExams() throws SQLException {
            examDAO.getAllExams().forEach(System.out::println);
        }

        public void showExamById() throws SQLException {
            Scanner scanner = new Scanner(System.in);
            int id = 0;
            System.out.println("give Id");
            try {
                id = Integer.parseInt(scanner.next());
                scanner.nextLine();

            } catch (NumberFormatException e) {
                System.out.println("wrong id");
            }
            Exam exam = examDAO.getExamById((long) id);
            System.out.println("exam got added");
        }

        public void addExam() throws SQLException {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Insert name");
            String name = scanner.next();

            System.out.println("Insert description");
            String description = scanner.next();

            System.out.println("Insert day for exam date");
            int day = scanner.nextInt();

            System.out.println("Insert month for exam date");
            int month = scanner.nextInt();

            System.out.println("Insert year for exam date");
            int year = scanner.nextInt();

            LocalDate dateTime = LocalDate.of(day, month, year);

            System.out.println("Insert weight");
            int weight = scanner.nextInt();

            System.out.println("Insert total");
            int total = scanner.nextInt();

            Exam exam = new Exam(name, description, dateTime, weight, total);
            examDAO.addExam(exam);
        }

        public void updateExam() throws SQLException {
            Scanner scanner = new Scanner(System.in);

            examDAO.getAllExams().forEach(System.out::println);

            System.out.println("select id you want to update");
            long id = scanner.nextLong();

            examDAO.getExamById(id);

            Exam exam = examDAO.getExamById(id);

            System.out.println(" change name? Y/N");
            String change = scanner.next();

            if (change.toUpperCase().equals("Y")) {
                System.out.println("to what you want to change it?");
                String newName = scanner.next();
                exam.setName(newName);
            }

            System.out.println("change the description? y/n");
            change = scanner.next();

            if (change.toUpperCase().equals("Y")) {
                System.out.println("to what u want to change it");
                String description = scanner.next();
                exam.setDescription(description);
            }

            System.out.println("change the date? y/n");
            change = scanner.next();

            if (change.toUpperCase().equals("Y")) {
                System.out.println("day for exam ");
                int day = scanner.nextInt();

                System.out.println("month for exam");
                int month = scanner.nextInt();

                System.out.println("year for exam");
                int year = scanner.nextInt();

                LocalDate date = LocalDate.of(day, month, year);
                exam.setDate(date);
            }

            System.out.println("change the weight? NA for nothing");
            change = scanner.next();

            if (change.toUpperCase().equals("Y")) {
                System.out.println("to what u want to change it?");
                int weight = scanner.nextInt();
                exam.setWeight(weight);
            }

            System.out.println("change the total? Y/N");
            change = scanner.next();

            if (change.toUpperCase().equals("Y")) {
                System.out.println("What do you want to change it do?");
                int total = scanner.nextInt();
                exam.setTotal(total);
            }
            examDAO.updateExam(exam);
            System.out.println("Exam is successfully updated");
        }

        public void deleteAExam() throws SQLException {

            Scanner scanner = new Scanner(System.in);
            examDAO.getAllExams().forEach(System.out::println);

            System.out.println("Give id of module you want to delete:");
            int personId = scanner.nextInt();

            System.out.println("Exam has been deleted");
        }
    }
}
