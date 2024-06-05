package com.example.mailsend.controller;

import com.example.mailsend.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmailSendController {
    private EmailService emailService;

    public EmailSendController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
	public String sendEmail(@RequestParam(value="file" ,required=false)MultipartFile[] file,String to,String[]cc,String subject,String body) {
		
		
		return emailService.sendMail(file, to, cc, subject, body);
	}

//    @PostMapping("/mail/send")
//    public ModelAndView sendMail(@RequestParam(value = "file", required = false) MultipartFile[] file,
//                                 @RequestParam String to,
//                                 @RequestParam(required = false) String[] cc,
//                                 @RequestParam String subject,
//                                 @RequestParam String body) {
//        // Process email sending logic here
//        emailService.sendMail(file, to, cc, subject, body);
//        
//        // Return the view name to render the HTML template
//        return new ModelAndView("sendEmail.html");
//    }

}
