package mao.t9;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import lombok.extern.slf4j.Slf4j;
import mao.utils.ByteBufUtils;

import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：Netty_ByteBuf
 * Package(包名): mao.t9
 * Class(类名): ByteBufTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/22
 * Time(创建时间)： 22:31
 * Version(版本): 1.0
 * Description(描述)： CompositeByteBuf：将多个 ByteBuf 合并为一个逻辑上的 ByteBuf
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
        //方法一：性能不高，进行了数据的内存复制操作
        ByteBuf buffer3 = ByteBufAllocator.DEFAULT.buffer(buffer1.readableBytes()
                + buffer2.readableBytes());
        buffer3.writeBytes(buffer1);
        buffer3.writeBytes(buffer2);
        ByteBufUtils.debug(buffer3);

        //方法二：CompositeByteBuf
        CompositeByteBuf compositeByteBuf =
                ByteBufAllocator.DEFAULT.compositeBuffer()
                        // true 表示增加新的 ByteBuf 自动递增 write index, 否则 write index 会始终为 0
                        .addComponents(true,buffer1, buffer2);
        log.info(compositeByteBuf.toString());


    }
}
