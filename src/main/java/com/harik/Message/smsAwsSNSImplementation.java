package com.harik.Message;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class smsAwsSNSImplementation implements Message,sms
{

    @Autowired
    private credentials credentialsProvider;

    private String message, phoneNumber;

    @Override
    public void sendAlert() throws IOException
    {
        AmazonSNSClient service = new AmazonSNSClient(credentialsProvider.getCredentialsProvider());


        PublishResult result = service.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber));
        System.out.println(result);
    }

    @Override
    public void setMessage(String message) {
        this.message=message;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber=phoneNumber;
    }
}
