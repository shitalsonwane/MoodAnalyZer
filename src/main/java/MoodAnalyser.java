import java.util.Objects;

public class MoodAnalyser {
    public static void main(String args[]){
        System.out.println("Welcome to Mood Analyser ");
    }
    String message;
    public MoodAnalyser() {
        }
    public MoodAnalyser(String message) {
            this.message=message;
        }
    public String analyseMood() throws MoodAnalysisException{
        try {
            if (message.length()==0)
                throw new MoodAnalysisException("Mood Should not be EMPTY",MoodAnalysisException.UserDefinedDataType.EMPTY_EXCEPTION);
            else if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch (NullPointerException e)
        {
            throw new MoodAnalysisException("Mood Should not be Null",MoodAnalysisException.UserDefinedDataType.NULL_EXCEPTION);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
