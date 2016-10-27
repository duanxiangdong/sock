package com.duan.netty.client;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class BaseClientHandler extends ChannelHandlerAdapter {
	private static final Logger log = Logger.getLogger(BaseClientHandler.class);

	protected String reqXml;

	protected String resXml;

	public BaseClientHandler() {

	}

	public BaseClientHandler(String reqXml) {
		this.reqXml = reqXml;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ByteBuf encoded = ctx.alloc().buffer(4 * reqXml.length());
		encoded.writeBytes(reqXml.getBytes("GBK"));
		ctx.writeAndFlush(encoded);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf result = (ByteBuf) msg;
		byte[] result1 = new byte[result.readableBytes()];
		System.out.println("返回长度"+result1.length);
		result.readBytes(result1);
		String res = new String(result1, "GBK");
		System.out.println("交易返回报文=====\r\n"+res);
		this.resXml = res;
		result.release();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
		System.out.println("客户端收到服务器响应数据处理完成");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
		log.error("客户端异常退出", cause);
		System.out.println("客户端异常退出");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("==============channel--inactive==============");
	}
}
