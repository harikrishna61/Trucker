package com.harik.Message;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
public class credentials
{
    private  AWSCredentialsProvider credentialsProvider;

    public AWSCredentialsProvider getCredentialsProvider() {
        return this.credentialsProvider;
    }

    public  credentials() throws IOException{
        Properties prop = new Properties();
        prop.load(getClass().getClassLoader().getResourceAsStream("aws.properties"));

        this.credentialsProvider = new AWSCredentialsProvider() {
            @Override
            public AWSCredentials getCredentials() {
                return new AWSCredentials() {
                    @Override
                    public String getAWSAccessKeyId() {
                        return prop.getProperty("aws.accessKeyId");
                    }

                    @Override
                    public String getAWSSecretKey() {
                        return prop.getProperty("aws.secretKey");
                    }
                };
            }

            @Override
            public void refresh() {

            }
        };

    }



}
