package devices;

public class FactoryDevices {

    public static final String ANDROID="android";
    public static final String IOS="ios";
    public static final String WINDOWS_PHONE="windowphone";

    public static IDevices make(String typeDevice){
        IDevices devices;
        switch (typeDevice){
            case ANDROID:
                devices = new Android();
                break;
            case IOS:
                devices = new IOS();
                break;
            case WINDOWS_PHONE:
                devices= new WindowsPhone();
                break;

            default:
                devices = new Android();
                break;
        }
          return  devices;
    }
}
