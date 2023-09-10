/**
 * @Description: 消费者
 * @Author: yichengdong
 * @CreateDate: 2023/9/2 18:52
 * @Copyright : 豆浆油条个人非正式工作室
 * <p>
 * 生成代理对象
 * @see org.apache.dubbo.rpc.proxy.javassist.JavassistProxyFactory 代理工厂
 * @see org.apache.dubbo.rpc.proxy.InvokerInvocationHandler 代理对象调用句柄
 * 一个请求过程
 * @see org.apache.dubbo.rpc.RpcInvocation RPC调用（封装服务接口的相关信息）
 * @see org.apache.dubbo.remoting.exchange.Request 请求对象
 * @see org.apache.dubbo.remoting.transport.AbstractClient#send(Object, boolean) 通过Netty发送数据
 * @see org.apache.dubbo.remoting.transport.netty4.NettyCodecAdapter.InternalDecoder 编码器
 * @see org.apache.dubbo.rpc.protocol.dubbo.DubboCodec#encodeRequestData(Channel, ObjectOutput, Object, String) 对RpcInvocation对象进行编码
 * @see org.apache.dubbo.remoting.transport.netty4.NettyCodecAdapter.InternalDecoder 解码器
 *
 */
package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.common.serialize.ObjectOutput;
import org.apache.dubbo.remoting.Channel;
