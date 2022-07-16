package com.example.qqbot;

import com.zhuangxv.bot.annotation.GroupMessageHandler;
import com.zhuangxv.bot.annotation.GroupUserAddHandler;
import com.zhuangxv.bot.core.Group;
import com.zhuangxv.bot.core.Member;
import com.zhuangxv.bot.injector.object.UserAddMessage;
import com.zhuangxv.bot.message.MessageChain;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class remasg {

    @GroupMessageHandler(groupIds = {756181314}, regex = "^状态$")
    public void talk(Group group, Member member) throws Exception {
        log.info(member+"发送：状态");
        MessageChain mc = new MessageChain();
        json x=new json();
        mc.at(member.getUserId()).text("\n")
                .text(x.Json());
        group.sendMessage(mc);
        log.info("回复成功");
    }
    @GroupUserAddHandler(groupIds={756181314})
    public void userAdd(Group group, UserAddMessage um) throws Exception {
        log.info("成员加入");
        MessageChain mc = new MessageChain();
        Long userId = um.getUserId();
        Member member = group.getMember(userId);
        mc.at(member.getUserId()).text("欢迎入群，安卓PC客户端都在群文件里自取，记得在网站注册并在启动器登录账号" )
                .text("\n"+"查看服务器状态发送”状态“查看");
        group.sendMessage(mc);
        log.info("回复新成员");

    }
    @GroupMessageHandler(groupIds = {119295367}, regex = "^状态$")
    public void talktest(Group group, Member member) throws Exception {
        log.info(member+"发送：状态");
        MessageChain mc = new MessageChain();
        json x=new json();
        mc.at(member.getUserId()).text("\n")
                .text(x.Json());
        group.sendMessage(mc);
        log.info("回复成功");
    }
    /*@GroupUserAddHandler(groupIds={756181314})
    public void userAdd(Group group, UserAddMessage um) throws Exception {
        log.info("成员加入");
        MessageChain mc = new MessageChain();
        Long userId = um.getUserId();
        Member member = group.getMember(userId);
        mc.text("热烈欢迎【" + member.getNickname() + "】")
                .text("加入我们【" + group.getGroupName()+"】");
        group.sendMessage(mc);
        log.info("回复新成员");

    }*/
}
