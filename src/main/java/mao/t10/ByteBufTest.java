package mao.t10;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;
import mao.utils.ByteBufUtils;

import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：Netty_ByteBuf
 * Package(包名): mao.t10
 * Class(类名): ByteBufTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/22
 * Time(创建时间)： 23:07
 * Version(版本): 1.0
 * Description(描述)： Unpooled 是一个工具类，类如其名，提供了非池化的 ByteBuf 创建、组合、复制等操作
 */

@Slf4j
public class ByteBufTest
{
    public static void main(String[] args)
    {
        ByteBuf buffer1 = ByteBufAllocator.DEFAULT.buffer(10);
        ByteBuf buffer2 = ByteBufAllocator.DEFAULT.buffer(10);
        buffer1.writeBytes("12345".getBytes(StandardCharsets.UTF_8));
        buffer2.writeBytes("67890".getBytes(StandardCharsets.UTF_8));
        ByteBufUtils.debug(buffer1);
        ByteBufUtils.debug(buffer2);
        //当包装ByteBuf个数超过一个时, 底层使用了CompositeByteBuf
        ByteBuf buffer = Unpooled.wrappedBuffer(buffer1, buffer2);
        ByteBufUtils.debug(buffer);
        buffer1.setByte(3, 68);
        ByteBufUtils.debug(buffer);
    }
}
