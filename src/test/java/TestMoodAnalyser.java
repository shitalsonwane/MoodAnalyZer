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

    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappy() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
            Object moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"I am in Happy mood");
            Object mood = MoodAnalyserFactory.invokeMethod(moodAnalyserObject, "analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenHappyMessage_WhenImproper_ShouldReturnHappy() throws MoodAnalysisException {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
            Object moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"I am in Happy mood");
            Object mood = MoodAnalyserFactory.invokeMethod(moodAnalyserObject, "AnalyseMood");

        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.NO_SUCH_METHOD,e.userDefinedObject);

        }
    }
    @Test
    public void givenHappy_whenProper_ShouldReturnHappy() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
            MoodAnalyser object = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
            MoodAnalyserFactory.moodAnalyserField(object,"message","I'm in Happy mood");
            Object mood = MoodAnalyserFactory.invokeMethod(object, "analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenHappy_whenImproper_ShouldThrowException() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
            MoodAnalyser object = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
            MoodAnalyserFactory.moodAnalyserField(object,"Message","I'm in Happy mood");
            Object mood = MoodAnalyserFactory.invokeMethod(object, "analyseMood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedDataType.NO_SUCH_FIELD,e.userDefinedObject);
        }
    }
}

