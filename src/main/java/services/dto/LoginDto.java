package services.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class LoginDto implements Serializable {

    @Getter@Setter
    private String userName;

    @Getter @Setter
    private String password;
}
