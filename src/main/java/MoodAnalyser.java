public class MoodAnalyser {
    public static void main(String args[]){
        System.out.println("Welcome to Mood Analyser ");
    }
    private String message;
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
}
