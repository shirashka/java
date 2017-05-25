import javax.swing.*;

import static java.lang.Character.*;

/**
 * Created by Shira on 5/24/2017.
 */
public class PasswordTest {

    private String thePass;

    /**
     *  Constructor
     *  @param passString The user's desired password
     */

    public PasswordTest(String passString) {
        thePass = passString;
    }

    /**
     * Checks if all requirements are met for the password
     * @return boolean allGood true if password meets all requirements.
     * Otherwise, returns false.
     */
    public boolean passesTest() {

        boolean allGood = false;

        //Flags to check if meets qualifications
        int i = 0;
        boolean noUpper = true;
        boolean noLower = true;
        boolean noDigit = true;

        while ((i < thePass.length()) && ((noUpper) || (noLower) || (noDigit))) {
            char p = thePass.charAt(i);
            if(isLowerCase(p)) {
                noLower = false;
            }
            if(isUpperCase(p)) {
                noUpper = false;
            }
            if(isDigit(p)) {
                noDigit = false;
            }
            i++;
        }

        if((!noUpper) && (!noLower) && (!noDigit) && (thePass.length() > 5)) {
            allGood = true;
        } else {
            allGood = false;
        }

        return allGood;
    }

    /**
     * Gets the password that was tested, regardless of if it
     * is valid or not.
     * @return thePass The password that was tested.
     */
    public String getThePass() {
        return thePass;
    }
}
