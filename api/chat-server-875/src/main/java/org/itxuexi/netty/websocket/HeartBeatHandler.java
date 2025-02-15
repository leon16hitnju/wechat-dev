package org.itxuexi.netty.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.itxuexi.enums.MsgTypeEnum;
import org.itxuexi.pojo.netty.ChatMsg;
import org.itxuexi.pojo.netty.DataContent;
import org.itxuexi.utils.JsonUtils;
import org.itxuexi.utils.LocalDateUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 创建的心跳助手类
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // 判断evt类型是否是IdleStateEvent(读空闲、写空闲或者读写空闲)
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
//                System.out.println("进入读空闲...");
            } else if (event.state() == IdleState.WRITER_IDLE) {
//                System.out.println("进入写空闲...");
            } else if (event.state() == IdleState.ALL_IDLE) {
//                System.out.println("channel关闭前, clients的数量为：" + ChatHandler.clients.size());
                Channel channel = ctx.channel();
                System.out.println("Shutting down channels");
                // 关闭无用的channel以防资源浪费
                channel.close();
//                System.out.println("channel关闭后, clients的数量为：" + ChatHandler.clients.size());
            }
        }
    }
}