package mao.t5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import mao.utils.ByteBufUtils;

import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：Netty_ByteBuf
 * Package(包名): mao.t5
 * Class(类名): ByteBufTest3
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/22
 * Time(创建时间)： 15:07
 * Version(版本): 1.0
 * Description(描述)： 读取某一个位置的数值，get方法
 */

@Slf4j
public class ByteBufTest3
{
    public static void main(String[] args)
    {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16);
        buffer.writeBytes("1234567890123456".getBytes(StandardCharsets.UTF_8));
        ByteBufUtils.debug(buffer);
        //读取
        log.debug(String.valueOf(buffer.getByte(1)));
        log.debug(String.valueOf(buffer.getByte(1)));
        log.debug(String.valueOf(buffer.getByte(1)));
        log.debug(String.valueOf(buffer.getByte(6)));
        log.debug(String.valueOf(buffer.getByte(0)));
    }
}
