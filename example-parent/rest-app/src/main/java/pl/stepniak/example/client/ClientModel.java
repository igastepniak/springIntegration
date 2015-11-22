package pl.stepniak.example.client;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {

    private Long id;
    private String email;
    private String promo;
    private String name;
    private String username;
    private String password;
    private String timeZone;
    private Integer replacementCount;
    private Integer trackingUrlCount;
    private Long accountLevel;
    private Date createdDate;
    private Date termsAcceptedDate;
}
