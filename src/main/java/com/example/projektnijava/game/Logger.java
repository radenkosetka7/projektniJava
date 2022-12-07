package com.example.projektnijava.game;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

public class Logger {

    public static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("PJ2-Logger");
    private static Handler handler;

    static {
        try {
            handler = new FileHandler("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "pictures" + File.separator + "logs.log");
            logger.getLogger(Logger.class.getName()).setUseParentHandlers(false);
        }
        catch(IOException exception)
        {
            logger.severe(exception.fillInStackTrace().toString());
        }
        catch (SecurityException exception)
        {
            logger.severe(exception.fillInStackTrace().toString());
        }
    }
}
