package calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerSingleton {
    private static LoggerSingleton instance;
    private final String logFile = "calculator.log";

    private LoggerSingleton() {}

    public static LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    public void log(String message) {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(LocalDateTime.now() + " - " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
