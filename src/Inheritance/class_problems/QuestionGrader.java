package Inheritance.class_problems;
import java.util.*;
import java.util.regex.*;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double evaluate();
}

// Concrete Implementations
class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluate() {
        if (studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return points;
        }
        return 0.0;
    }
}

class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluate() {
        if (studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return points;
        }
        return 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluate() {
        String[] keywords = correctAnswer.split(",");
        String studentText = studentAnswer.toLowerCase();

        int matches = 0;
        for (String kw : keywords) {
            if (studentText.contains(kw.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return 0.75 * points;
        } else if (matches == 1) {
            return 0.50 * points;
        }
        return 0.0;
    }
}
class QuestionFactory {
    public static Question createQuestion(String[] parts) {
        String type = parts[0].toUpperCase();
        String text = parts[1];
        String correct = parts[2];
        String student = parts[3];
        double points = Double.parseDouble(parts[4]);

        switch (type) {
            case "MCQ":
                return new MultipleChoiceQuestion(text, correct, student, points);
            case "TF":
                return new TrueFalseQuestion(text, correct, student, points);
            case "ESSAY":
                return new EssayQuestion(text, correct, student, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }
}

public class QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = Integer.parseInt(sc.nextLine().trim());
        List<String> types = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = parseQuotedLine(line);
            types.add(parts[0]);
            questions.add(QuestionFactory.createQuestion(parts));
        }

        double overallScore = 0.0;
        for (int i = 0; i < n; i++) {
            double score = questions.get(i).evaluate();
            overallScore += score;
            System.out.printf("%s: %.2f\n", types.get(i), score);
        }

        System.out.printf("Total Score: %.2f\n", overallScore);
        sc.close();
    }

    private static String[] parseQuotedLine(String line) {
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("([^\"]\\S*|\"[^\"]*\")").matcher(line);
        while (m.find()) {
            list.add(m.group(1).replace("\"", ""));
        }
        return list.toArray(new String[0]);
    }
}
