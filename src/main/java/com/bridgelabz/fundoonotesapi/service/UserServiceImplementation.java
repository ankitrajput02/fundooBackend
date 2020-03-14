package com.bridgelabz.fundoonotesapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotesapi.dto.ForgotPasswordDTO;
import com.bridgelabz.fundoonotesapi.dto.LoginDTO;
import com.bridgelabz.fundoonotesapi.dto.RegistrationDTO;
import com.bridgelabz.fundoonotesapi.dto.ResetPasswordDTO;
import com.bridgelabz.fundoonotesapi.exception.UserAlreadyPresentException;
import com.bridgelabz.fundoonotesapi.message.MessageData;
import com.bridgelabz.fundoonotesapi.message.MessageResponse;
import com.bridgelabz.fundoonotesapi.model.User;
import com.bridgelabz.fundoonotesapi.repository.UserRepository;
import com.bridgelabz.fundoonotesapi.response.Response;
import com.bridgelabz.fundoonotesapi.utility.EmailSenderService;
import com.bridgelabz.fundoonotesapi.utility.TokenUtility;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenUtility tokenUtility;
	@Autowired
	private ModelMapper mapper;
	private MessageData messageData;
	SimpleMailMessage email;
	@Autowired
	private MessageResponse messageResponse;
	@Autowired
	private EmailSenderService emailSenderService;
	@Override
	public Response addUser(RegistrationDTO registrationDTO) {
		User checkEmail = userRepository.findByEmail(registrationDTO.getEmail());
		if (checkEmail != null) {
			throw new UserAlreadyPresentException(messageData.validateUser);
		}
		User user = mapper.map(registrationDTO, User.class);
		System.out.println(registrationDTO.getEmail());
		String token = tokenUtility.generateToken(user.getEmail());
		System.out.println(token);
		email = messageResponse.verifyMail(user.getEmail(), user.getFirstName(), token);
		emailSenderService.sendEmail(email);
		user.setPassword(registrationDTO.getPassword());
		userRepository.save(user);
		return new Response(200, "User Registration Successfull", token);

	}
	@Override
	public Response getUser() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Response login(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Response validateUser(String token) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Response deleteUser(String token) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Response resetPassword(String token, ResetPasswordDTO resetPasswordDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Response forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Response signOut(String token) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
