package com.translate.support;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Administrator on 2017/8/9.
 * 设置邮件队列，过多或者频率过快的发送都会被判定为垃圾邮件
 */
public class MailQueue {

  private static final int MAIL_QUEUE_MAX_SIZE = 1000;

  private static BlockingQueue<SimpleMailMessage> blockingQueue = new LinkedBlockingQueue<>(
      MAIL_QUEUE_MAX_SIZE);

  /**
   * 私有的默认构造子，保证外界无法直接实例化
   */
  private MailQueue() {
  }

  /**
   * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
   * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
   */
  private static class SingletonHolder {

    /**
     * 静态初始化器，由JVM来保证线程安全
     */
    private static MailQueue mailQueue = new MailQueue();
  }

  /**
   * 单例队列
   */
  public static MailQueue getMailQueueInstance() {
    return SingletonHolder.mailQueue;
  }

  /**
   * 生产邮件如队列
   */
  public void produce(SimpleMailMessage mail) throws InterruptedException {
    blockingQueue.put(mail);
  }

  /**
   * 消费邮件出队
   */
  public SimpleMailMessage consume() throws InterruptedException {
    return blockingQueue.take();
  }

  /**
   * 获取邮件队列数量
   */
  public int size() {
    return blockingQueue.size();
  }
}