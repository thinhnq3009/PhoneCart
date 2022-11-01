package eco.phonecart.app.email;

import java.util.Random;

import eco.phonecart.app.dao.ForgotPasswordDao;
import eco.phonecart.app.helper.RandomHelper;
import eco.phonecart.app.model.ForgotPassword;
import eco.phonecart.app.model.Users;

public class Email {

	public static String PASSWORD = "gshipcerulpdhuuy";
	
	public static String ACCOUNT = "thinhnq3009@gmail.com";
	
	public static void sendResetCode(Users user) {
		
		MailSender sender = new MailSender(ACCOUNT, PASSWORD);
		
		String code = RandomHelper.getCode(8, true);
		
		try {
			ForgotPasswordDao dao = new ForgotPasswordDao();
			
			ForgotPassword f = new ForgotPassword();
			
			f.setUser(user);
			f.setResertCode(code);
			
			dao.insert(f);
			
			sender.send(user.getEmail(), user.getAccountName(), code);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
