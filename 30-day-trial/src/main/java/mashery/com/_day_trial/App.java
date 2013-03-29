package mashery.com._day_trial;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        PortalSetup portalSetup = new PortalSetup();
        String portalName = "trial1004";
        String userName = "jwilfong";
        String password = "Hillingdon1";
        portalSetup.createService(portalName, userName, password);
    }
}
