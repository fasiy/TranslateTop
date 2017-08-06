package com.translate.controller;

/**
 * Created by Administrator on 2017/8/6.
 */
public interface RegisterController {
	boolean sendMail(String receiver, String subject, String message);
}
