package com.simplytodo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Configuration
public class CustomBeanConfig
{
    @Bean
    public MessageDigest sha256(byte[] input) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256");
    }
}
