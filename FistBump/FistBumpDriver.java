package FistBump;

public class FistBumpDriver {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Facade fistBumpApplication = new Facade();
        UI fistBumpUI = new UI(fistBumpApplication);
        fistBumpUI.start();
        fistBumpApplication.save();
    }
}