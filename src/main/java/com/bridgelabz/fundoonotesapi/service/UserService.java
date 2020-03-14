package com.bridgelabz.fundoonotesapi.service;



import com.bridgelabz.fundoonotesapi.dto.ForgotPasswordDTO;
import com.bridgelabz.fundoonotesapi.dto.LoginDTO;
import com.bridgelabz.fundoonotesapi.dto.RegistrationDTO;
import com.bridgelabz.fundoonotesapi.dto.ResetPasswordDTO;
import com.bridgelabz.fundoonotesapi.response.Response;

public interface UserService {
	Response getUser();
	Response login(LoginDTO loginDTO);
	Response addUser(RegistrationDTO registrationDTO);
	Response validateUser(String token);
	Response deleteUser(String token);
	Response resetPassword(String token,ResetPasswordDTO resetPasswordDTO);
	Response forgotPassword(ForgotPasswordDTO forgotPasswordDTO);
	Response signOut(String token);
	
	
}
