package sk.balaz.springbootmongowebflux.notification;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "notification")
public class Notification {

    @Id
    private String id;
    private String message;
}
