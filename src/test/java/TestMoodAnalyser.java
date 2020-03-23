import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyser {
    MoodAnalyser MoodAnalyserObj=new MoodAnalyser();

    @Test
    public void givenMessage_whenResponse_thenSad() {
        String result=MoodAnalyserObj.analyseMood("I am in sad Mood");
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_whenReaponse_thenHappy() {
        String result=MoodAnalyserObj.analyseMood("i am in any mood");
        Assert.assertEquals("HAPPY",result);
    }
}
