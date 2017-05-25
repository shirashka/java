import javax.swing.*;

/**
 * Created by Shira on 5/24/2017.
 */
public class Password_Verifier {
    public static void main(String[] args) {
        String input;
        input = JOptionPane.showInputDialog("Please type in your desired password. " +
                "It must be at least 6 characters long, " +
                "containing at least 1 uppercase, 1 lowercase, and 1 digit.");

        PasswordTest test = new PasswordTest(input);
        if(test.passesTest()) {
            JOptionPane.showMessageDialog(null, "Your password has" +
                    " been successfully changed to " + test.getThePass());
        }
        else {
            JOptionPane.showMessageDialog(null, "Sorry, " + test.getThePass() + " doesn't meet" +
                    "the necessary password requirements. You need to try again. ");
            main(args);
        }
    }
}
