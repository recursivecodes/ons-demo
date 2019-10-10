package codes.recursive;

import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.ons.NotificationDataPlaneClient;
import com.oracle.bmc.ons.model.MessageDetails;
import com.oracle.bmc.ons.requests.PublishMessageRequest;

public class Ons {

    public void sendNotification(String title, String message) throws Exception {

        String topicId = System.getenv("TOPIC_ID");

        if( topicId == null ) {
            throw new Exception("Please set a TOPIC_ID environment variable!");
        }

        ConfigFileAuthenticationDetailsProvider provider =  new ConfigFileAuthenticationDetailsProvider("DEFAULT");
        NotificationDataPlaneClient client = NotificationDataPlaneClient.builder().region("us-phoenix-1")
                .build(provider);

        MessageDetails messageDetails = MessageDetails.builder().title(title).body(message).build();

        PublishMessageRequest publishMessageRequest = PublishMessageRequest.builder()
                .messageDetails( messageDetails )
                .topicId(topicId)
                .build();

        client.publishMessage( publishMessageRequest );
    }

}
