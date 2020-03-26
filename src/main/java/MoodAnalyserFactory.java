import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public static MoodAnalyser createMoodAnalyserObject(Constructor constructor,Object... objects) throws  MoodAnalysisException {
        try {
            return (MoodAnalyser) constructor.newInstance(objects);
             }
            catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }
    public static Object invokeMethod(Object moodAnalyserObject, String analyseMood) {
        try {
            Class objectClass = moodAnalyserObject.getClass();
            Method moodMethod = objectClass.getMethod(analyseMood);
            Object result = moodMethod.invoke(moodAnalyserObject);
            return result;
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
