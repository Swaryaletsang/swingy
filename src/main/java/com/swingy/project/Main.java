package com.swingy.project;

import org.slf4j.*;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        if (args[0].equals("console")) {
            //simulate console view (while loop)
        } else if (args[0].equals("gui")) {
            // simulate GUI view (while loop)
        }
         else {
            //error message
        }
        Logger log = LoggerFactory.getLogger(Main.class);
        log.info("Hello world");
    }
}
