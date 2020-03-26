import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class TestMoodAnalyser {
    MoodAnalyser MoodAnalyserObj=new MoodAnalyser();

    @Test
    public void givenMessage_whenResponse_thenSad() throws MoodAnalysisException {
        MoodAnalyser MoodAnalyserObj=new MoodAnalyser("i am in sad mood");
        Assert.assertEquals("SAD",MoodAnalyserObj.analyseMood());
    }

    @Test
    public void givenMessage_whenReaponse_thenHappy() throws MoodAnalysisException{
        MoodAnalyser MoodAnalyserObj=new MoodAnalyser("i am in any mood");
        Assert.assertEquals("HAPPY",MoodAnalyserObj.analyseMood());
    }
    @Test
    public void givenMessage_WhenNull_ThenShouldReturnCustomException() {
        try {
            MoodAnalyser MoodAnalyserObj = new MoodAnalyser(null);
            MoodAnalyserObj.analyseMood();
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.NULL_EXCEPTION,e.userDefinedObject);
        }
    }
    @Test
    public void GivenEmptyMessage_ShouldReturn_EmptyMoodException () {
        try{
            MoodAnalyser MoodAnalyserObj = new MoodAnalyser("");
            MoodAnalyserObj.analyseMood();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.EMPTY_EXCEPTION,e.userDefinedObject);
        }
    }
    @Test
    public void givenObject_WhenEquals_ThenTrue() throws MoodAnalysisException {
        MoodAnalyser MoodAnalyserObj = new MoodAnalyser();
        Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
        boolean result = MoodAnalyserObj.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }
    @Test
    public void givenClass_WhenWrong_ThenReturnClassNotFound() {
        try {
            MoodAnalyserFactory.getConstructor("Moodanalyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.NO_SUCH_CLASS,e.userDefinedObject);
        }
    }
    @Test
    public void givenConstructor_WhenWrong_ThenReturnNoSuchMethod() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyser",Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.NO_SUCH_METHOD,e.userDefinedObject);
        }
    }
    @Test
    public void givenObject_WhenEqualsWithParameter_ThenTrue() throws MoodAnalysisException {
        MoodAnalyser MoodAnalyser = new MoodAnalyser("Hello");
        Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"Hello");
        boolean result = MoodAnalyser.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }
    @Test
    public void givenClassWithParameter_WhenWrong_ThenReturnClassNotFound() {
        try {
            MoodAnalyserFactory.getConstructor("Moodanalyzer",String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.NO_SUCH_CLASS,e.userDefinedObject);
        }
    }
    @Test
    public void givenConstructorWithParameter_WhenWrong_ThenReturnNoSuchMethod() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class,Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.NO_SUCH_METHOD,e.userDefinedObject);
        }
    }
}

