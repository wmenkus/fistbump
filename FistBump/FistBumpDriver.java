package FistBump;

public class FistBumpDriver {
    public static void main(String[] args) {
        Facade fistBumpApplication = new Facade();
        UI fistBumpUI = new UI(fistBumpApplication);
        fistBumpUI.start();
        fistBumpApplication.save();
    }
}