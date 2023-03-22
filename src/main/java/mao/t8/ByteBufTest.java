package mao.t8;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import mao.utils.ByteBufUtils;

import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：Netty_ByteBuf
 * Package(包名): mao.t8
 * Class(类名): ByteBufTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/22
 * Time(创建时间)： 15:48
 * Version(版本): 1.0
 * Description(描述)： copy:会将底层内存数据进行深拷贝，因此无论读写，都与原始 ByteBuf 无关
 */

@Slf4j
public class ByteBufTest
{
    public static void main(String[] args)
    {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16);
        buffer.writeBytes("123456".getBytes(StandardCharsets.UTF_8));
        ByteBufUtils.debug(buffer);

        //深拷贝
        ByteBuf copy = buffer.copy();
        ByteBufUtils.debug(copy);

        //读取
        log.debug(String.valueOf(copy.readByte()));
        ByteBufUtils.debug(buffer);
        ByteBufUtils.debug(copy);

        //写入
        buffer.setByte(4, 66);
        ByteBufUtils.debug(buffer);
        ByteBufUtils.debug(copy);
    }
}
