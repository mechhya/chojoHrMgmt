package services.loginservice;

import services.CoreService;
import services.dto.LoginDto;

public class ServiceLogin {

    public LoginDto login(String userName, String Password){
        LoginDto reqLoginDto = new LoginDto();
        LoginDto resLoginDto = new LoginDto();
        reqLoginDto.setUserName(userName);
        reqLoginDto.setPassword(Password);

        resLoginDto =  CoreService.getInfo("login",reqLoginDto,LoginDto.class);
        return resLoginDto;

    }
}
