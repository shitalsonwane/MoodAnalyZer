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
    public String analyseMood() {
        try {
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch (NullPointerException e)
        {
            return "HAPPY";
        }
    }
}
