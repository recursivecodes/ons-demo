package codes.recursive;

import java.util.Date;

public class OnsSendExample {

    public static void main(String... args) throws Exception {
        Ons ons = new Ons();
        ons.sendNotification(
                "Test from Java",
                "This is a test notification sent by the Java SDK at " + new Date().toString()
        );
    }

}
