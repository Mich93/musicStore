package music.util;

import javax.servlet.*;
import java.util.*;

public class musicContextListener implements ServletContextListener
{
    public void contextInitialized(ServletContextEvent event)
    {
        ServletContext sc = event.getServletContext();      
 
        // initialize the customer service email address that's used throughout the web site
        String custServEmail = sc.getInitParameter("custServEmail");
        sc.setAttribute("custServEmail", custServEmail);

        // initialize the current year that's used in the copyright notice
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        sc.setAttribute("currentYear", currentYear);
        
        // initialize the array of years that's used for the credit card year
        ArrayList<String> creditCardYears = new ArrayList<String>();
        for (int i = 0; i < 8; i++)
        {
            int year = currentYear + i; 
            String yearString = Integer.toString(year);
            creditCardYears.add(yearString);
        }
        sc.setAttribute("creditCardYears", creditCardYears);
    }
    
    public void contextDestroyed(ServletContextEvent event)
    {
        // no cleanup necessary
    }    
}