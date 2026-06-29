//3) Student Result Processing System
//Build a Result Processing System.
//Two types of students:
//• RegularStudent
//• RevaluationStudent
//________________________________________
//🔹 Abstract Class: Result
//Private Variables:
//•	resultId (auto-generated)
//•	studentName
//•	marks
//Abstract Method:
//calculateGrade()
//________________________________________
//🔹 Child Classes
// RegularStudent
//Grading Rule:
//•	≥ 90 → Grade A
//•	≥ 75 → Grade B
//•	≥ 50 → Grade C
//•	Else → Fail
//Method:
//resultDetails()
//________________________________________
//	 RevaluationStudent
//Rules:
//•	Extra 5 grace marks added
//•	Grade calculated after grace
//Method:
//resultDetails()
//Print:
//Revaluation marks applied
//________________________________________
//	 Expected Output
//Result Generated Successfully
//
//Result ID: R1001
//Name: Vikram
//Marks: 82.0
//Grade: B
//
//--------------------------------
//
//Result Generated Successfully
//
//Result ID: R1002
//Name: Neha
//Marks: 48.0
//Revaluation marks applied
//Grade: C

package scenerious;

abstract class Result {

    private static int counter = 1000;

    private String resultId;
    private String studentName;
    private double marks;

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    protected String generateResultId() {
        return "R" + (++counter);
    }

    public abstract String calculateGrade();
}

class RegularStudent extends Result {

    @Override
    public String calculateGrade() {

        double marks = getMarks();

        if (marks >= 90)
            return "A";
        else if (marks >= 75)
            return "B";
        else if (marks >= 50)
            return "C";
        else
            return "Fail";
    }

    public void resultDetails() {

        System.out.println("Result Generated Successfully\n");

        System.out.println("Result ID: " + getResultId());
        System.out.println("Name: " + getStudentName());
        System.out.println("Marks: " + getMarks());
        System.out.println("Grade: " + calculateGrade());
    }
}

class RevaluationStudent extends Result {

    @Override
    public String calculateGrade() {

        double updatedMarks = getMarks() + 5;

        if (updatedMarks >= 90)
            return "A";
        else if (updatedMarks >= 75)
            return "B";
        else if (updatedMarks >= 50)
            return "C";
        else
            return "Fail";
    }

    public void resultDetails() {

        System.out.println("Result Generated Successfully\n");

        System.out.println("Result ID: " + getResultId());
        System.out.println("Name: " + getStudentName());
        System.out.println("Marks: " + getMarks());
        System.out.println("Revaluation marks applied");
        System.out.println("Grade: " + calculateGrade());
    }
}

public class ResultMain {

    public static void main(String[] args) {

        RegularStudent r1 = new RegularStudent();

        r1.setResultId(r1.generateResultId());
        r1.setStudentName("Vikram");
        r1.setMarks(82);

        r1.resultDetails();

        System.out.println("\n--------------------------------\n");

        RevaluationStudent r2 = new RevaluationStudent();

        r2.setResultId(r2.generateResultId());
        r2.setStudentName("Neha");
        r2.setMarks(48);

        r2.resultDetails();
    }
}