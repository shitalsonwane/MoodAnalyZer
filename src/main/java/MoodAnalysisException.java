public class MoodAnalysisException extends Exception{
        enum UserDefinedDataType
        {
            NULL_EXCEPTION,
            EMPTY_EXCEPTION
        };
        UserDefinedDataType userDefinedObject;
        public MoodAnalysisException(String message, UserDefinedDataType userDefinedObject)
        {
            super(message);
            this.userDefinedObject = userDefinedObject;
        }
}
