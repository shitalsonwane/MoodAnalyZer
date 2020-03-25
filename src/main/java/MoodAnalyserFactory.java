import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
        public static Constructor getConstructor(String className) throws MoodAnalysisException {
            try {
                Class<?> moodAnalyserClass = Class.forName(className);
                return  moodAnalyserClass.getConstructor();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static MoodAnalyser createMoodAnalyserObject(Constructor constructor) throws  MoodAnalysisException {
            try {
                return (MoodAnalyser) constructor.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
