package com.example.qqbot;

import java.net.Inet6Address;
import java.net.UnknownHostException;

public class address6 {

    public String add(){
        try {
            String ipv6 = Inet6Address.getByName( "ipv6.mymc.xyz" ).getHostAddress();
            return "IPv6:"+ipv6+"\n";
        } catch (UnknownHostException e) {
            return "IPv6:"+"获取失败"+"\n";
        }
    }
}
