package com.translate.domain.demo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrator on 2017/8/6.
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mail implements Serializable
{
    @Getter
    @Setter
    //服务器地址
    private String hostName;

    @Getter
    @Setter
    //发送者
    private String sender;

    @Getter
    @Setter
    //接受者
    private String receiver;

    @Getter
    @Setter
    //账号名
    private String username;

    @Getter
    @Setter
    //密码
    private String password;

    @Getter
    @Setter
    //标题
    private String subject;

    @Getter
    @Setter
    //内容
    private String message;
}