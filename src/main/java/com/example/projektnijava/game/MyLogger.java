package com.example.projektnijava.game;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;


public class MyLogger {

    private static Handler handler;
    public static final Logger logger = Logger.getLogger("Loger");

    static {
        try {
            handler = new FileHandler("src" + File.separator + "main" + File.separator + "resources" + File.separator + "com" + File.separator + "example" + File.separator + "projektnijava" + File.separator + "logs.log",true);
            logger.addHandler(handler);
            logger.getLogger(MyLogger.class.getName()).setUseParentHandlers(false);

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
