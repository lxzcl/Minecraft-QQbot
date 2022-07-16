package com.example.qqbot;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
@Slf4j
public class address {

    public String add(){
        try {
            String ipv4 = InetAddress.getByName( "mymc.xyz" ).getHostAddress();
                    return "IPv4:"+ipv4+"\n";
        } catch (UnknownHostException e) {
            return "IPv4:"+"获取失败"+"\n";
        }
    }
}