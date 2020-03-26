import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static Constructor getConstructor(String className, Class... parameter) throws MoodAnalysisException {
        try {
                Class<?> moodAnalyserClass = Class.forName(className);
                return  moodAnalyserClass.getConstructor(parameter);
            } catch (ClassNotFoundException e) {
                throw new MoodAnalysisException("Class not found",MoodAnalysisException.UserDefinedDataType.NO_SUCH_CLASS);
            } catch (NoSuchMethodException e) {
                throw new MoodAnalysisException("Method not found",MoodAnalysisException.UserDefinedDataType.NO_SUCH_METHOD);
            }

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
