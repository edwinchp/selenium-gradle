package utils;

public class EnvConfig {

    public static String getRequired(String key){
        String value = getFromSystem(key);
        if(value == null || value.isBlank()){
            throw new IllegalStateException("Missing environment variable: " + key);
        }
        return value;
    }

    public static String getOptional(String key, String defaultValue){
        String value = getFromSystem(key);
        if (value == null || value.isBlank()) {
            System.err.println("Environment variable not defined: " + key + ". Using the default value: " + defaultValue);
            return defaultValue;
        }
        return value;
    }

    private static String getFromSystem(String key){
        return System.getProperty(key);
    }
}
