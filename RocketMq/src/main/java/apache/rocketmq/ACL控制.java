package apache.rocketmq;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-19 10:26
 * @modified By:
 */
public class ACL控制 {
    /**
     *

    权限控制（ACL）主要为RocketMQ提供Topic资源级别的用户访问控制。
     用户在使用RocketMQ权限控制时，可以在Client客户端通过 RPCHook注入AccessKey和SecretKey签名；
     同时，将对应的权限控制属性（包括Topic访问权限、IP白名单和AccessKey和SecretKey签名等）
     设置在$ROCKETMQ_HOME/conf/plain_acl.yml的配置文件中。Broker端对AccessKey所拥有的权限进行校验，校验不过，抛出异常；

    broker.conf增加​​aclEnable=true​​

    plan_acl.ym修改

#全局白名单，不受ACL控制
#通常需要将主从架构中的所有节点加进来
    globalWhiteRemoteAddresses:
            - 10.10.103.*
            - 192.168.0.*
    accounts:
            #第一个账户
- accessKey: RocketMQ
    secretKey: 12345678
    whiteRemoteAddress:
    admin: false
    defaultTopicPerm: DENY#默认Topic访问策略是拒绝
    defaultGroupPerm: SUB#默认Group访问策略是只允许订阅
    topicPerms:
            - topicA=DENY#topicA拒绝
  - topicB=PUB|SUB#topicB允许发布和订阅消息
  - topicC=SUB#topicC只允许订阅
    groupPerms:
            # the group should convert to retry topic
  - groupA=DENY
  - groupB=PUB|SUB
  - groupC=SUB
#第二个账户，只要是来自192.168.1.*的IP，就可以访问所有资源
- accessKey: rocketmq2
    secretKey: 12345678
    whiteRemoteAddress: 192.168.1.*
            # if it is admin, it could access all resources
    admin: true
  */

}
