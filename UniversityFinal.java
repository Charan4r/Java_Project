import java.util.ArrayList;   // Collection Framework -> ArrayList
import java.util.Iterator;    // Collection Framework -> Iterator
import java.util.Scanner;

public class UniversityFinal {

    // FINAL VARIABLES (final keyword topic): values can never be changed
    static final String UNIVERSITY_NAME = "KLU University, Hyd";
    static final double MIN_ATTENDANCE = 75.0;
    static final double PASS_PERCENTAGE = 60.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Student Info Input
        System.out.println("=================================");
        System.out.println("     STUDENT REGISTRATION        ");
        System.out.println("     " + UNIVERSITY_NAME);
        System.out.println("=================================");

        System.out.print("Enter Student Full Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department (e.g., Computer Science): ");
        String department = scanner.nextLine();

        System.out.print("Enter University ID: ");
        String uniId = scanner.nextLine();

        System.out.print("Enter total number of subjects: ");
        int totalSubjects = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline after nextInt()

        // Arrays to store grades and attendance for each subject
        double[] grades = new double[totalSubjects];
        int[] classesAttended = new int[totalSubjects];
        int[] totalClasses = new int[totalSubjects];

        // ArrayList to store subject names (Collection Framework topic)
        ArrayList<String> subjectNames = new ArrayList<String>();

        // Input loop to collect subject details
        for (int i = 0; i < totalSubjects; i++) {
            System.out.println("\n--- Subject " + (i + 1) + " ---");

            System.out.print("Enter subject name: ");
            subjectNames.add(scanner.nextLine());

            System.out.print("Enter grade percentage (0 - 100): ");
            grades[i] = scanner.nextDouble();

            System.out.print("Enter classes attended: ");
            classesAttended[i] = scanner.nextInt();

            System.out.print("Enter total classes held: ");
            totalClasses[i] = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline
        }

        // Processing totals using Arithmetic and Assignment Operators
        double totalGradePoints = 0;
        int sumAttended = 0;
        int sumTotalClasses = 0;

        for (int i = 0; i < totalSubjects; i++) {
            totalGradePoints += grades[i];
            sumAttended += classesAttended[i];
            sumTotalClasses += totalClasses[i];
        }

        // Calculations
        double averageGrade = totalGradePoints / totalSubjects;
        double attendancePercentage = ((double) sumAttended / sumTotalClasses) * 100; // Type casting

        // Grade scale categorization
        int gradeCategory;
        if (averageGrade >= 90) {
            gradeCategory = 4;
        } else if (averageGrade >= 80) {
            gradeCategory = 3;
        } else if (averageGrade >= 70) {
            gradeCategory = 2;
        } else if (averageGrade >= PASS_PERCENTAGE) {
            gradeCategory = 1;
        } else {
            gradeCategory = 0;
        }

        // Switch Statement for Letter Grade Assignment
        String letterGrade;
        switch (gradeCategory) {
            case 4:
                letterGrade = "A (Excellent)";
                break;
            case 3:
                letterGrade = "B (Good)";
                break;
            case 2:
                letterGrade = "C (Satisfactory)";
                break;
            case 1:
                letterGrade = "D (Pass)";
                break;
            default:
                letterGrade = "F (Fail)";
                break;
        }

        // Relational and Logical Operators for Eligibility (using final constants)
        boolean meetsAttendance = attendancePercentage >= MIN_ATTENDANCE;
        boolean passesGrades = averageGrade >= PASS_PERCENTAGE;
        boolean isEligible = meetsAttendance && passesGrades;

        // StringBuffer append() (StringBuffer topic) + Iterator over ArrayList
        StringBuffer subjectReport = new StringBuffer();
        Iterator<String> itr = subjectNames.iterator();
        int index = 0;
        while (itr.hasNext()) {
            subjectReport.append(index + 1)
                         .append(". ")
                         .append(itr.next())
                         .append(" -> Grade: ")
                         .append(grades[index])
                         .append("%, Attendance: ")
                         .append(classesAttended[index])
                         .append("/")
                         .append(totalClasses[index])
                         .append("\n");
            index++;
        }

        // Output Results
        System.out.println("\n=================================");
        System.out.println("        ACADEMIC REPORT          ");
        System.out.println("=================================");
        System.out.println("Student Name : " + name);
        System.out.println("Department   : " + department);
        System.out.println("University ID: " + uniId);
        System.out.println("---------------------------------");
        System.out.println("SUBJECT-WISE DETAILS:");
        System.out.print(subjectReport);
        System.out.println("---------------------------------");
        System.out.printf("Average Grade: %.2f%%\n", averageGrade);
        System.out.println("Letter Grade : " + letterGrade);
        System.out.printf("Attendance   : %.2f%% (%d/%d classes)\n",
                          attendancePercentage, sumAttended, sumTotalClasses);
        System.out.println("---------------------------------");

        // Ternary Operator
        String statusMessage = isEligible ? "STATUS: Eligible for Final Exams"
                                          : "STATUS: Ineligible (Check attendance or grade requirements)";
        System.out.println(statusMessage);

        scanner.close();
    }
}