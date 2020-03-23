import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyser {
    MoodAnalyser MoodAnalyserObj=new MoodAnalyser();

    @Test
    public void givenMessage_whenResponse_thenSad() {
        MoodAnalyser MoodAnalyserObj=new MoodAnalyser("i am in sad mood");
        Assert.assertEquals("SAD",MoodAnalyserObj.analyseMood());
    }

    @Test
    public void givenMessage_whenReaponse_thenHappy() {
        MoodAnalyser MoodAnalyserObj=new MoodAnalyser("i am in any mood");
        Assert.assertEquals("HAPPY",MoodAnalyserObj.analyseMood());
    }
    @Test
    public void givenNull_whenResponse_thenHappy() {
        MoodAnalyser MoodAnalyserObj=new MoodAnalyser(null);
        Assert.assertEquals("HAPPY",MoodAnalyserObj.analyseMood());
    }
}
