package com.harik.Message;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailAwsSESImplementation implements Message, email {
    private  String from, to ,subject, body;

    @Autowired
    private credentials credentialsProvider;

    @Override
    public void sendAlert() throws IOException
    {

        AmazonSimpleEmailService emailService =AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(credentialsProvider.getCredentialsProvider())
                .withRegion(Regions.US_EAST_1).build();

        emailService.sendEmail(new SendEmailRequest()
                .withDestination(
                        new Destination().withToAddresses(to))
                .withMessage(new com.amazonaws.services.simpleemail.model.Message()
                        .withBody(new Body()
                                .withHtml(new Content()
                                        .withCharset("UTF-8").withData(body))
                                )
                        .withSubject(new Content()
                                .withCharset("UTF-8").withData(subject)))
                .withSource(from));

    }



    @Override
    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }


}
