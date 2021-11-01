/**
 * @author Walker Menkus
 */

package FistBump;

/**
 * Data class that stores a reference's name and contact info.
 * To be contained within the Resume class and used in the UI's
 * createResume() method.
 */
public class Reference {
    private String name;
    private String contactInfo;

    public Reference(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String toString() {
        //TODO
    }
}
