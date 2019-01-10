import java.util.ArrayList;

public class ReportCard {

    private ArrayList<Character> mGrades;
    private ArrayList<String> mClassNames;

    public ReportCard() {
        mGrades = new ArrayList<>();
        mClassNames = new ArrayList<>();
    }

    public void setGrade(String className, char grade) {
        if (!mClassNames.contains(className)) {
            mClassNames.add(className);
            mGrades.add(grade);
        }
    }

    public char getGrade(String className) {
        if (!mClassNames.contains(className)) {
            throw new UnsupportedOperationException("Invalid class.");
        }
        return mGrades.get(mClassNames.indexOf(className));
    }

    public String toString() {
        String output = "";

        for (int i = 0; i < mClassNames.size(); i++) {
            output += mClassNames.get(i) + " grade: ";
            output += mGrades.get(i) + "; ";
        }

        return output;
    }

}
