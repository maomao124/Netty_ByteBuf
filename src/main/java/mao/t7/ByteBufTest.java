package mao.t7;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import mao.utils.ByteBufUtils;

import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：Netty_ByteBuf
 * Package(包名): mao.t7
 * Class(类名): ByteBufTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/22
 * Time(创建时间)： 15:43
 * Version(版本): 1.0
 * Description(描述)： duplicate
 */

@Slf4j
public class ByteBufTest
{
    public static void main(String[] args)
    {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16);
        buffer.writeBytes("123456".getBytes(StandardCharsets.UTF_8));
        ByteBufUtils.debug(buffer);
        //读取
        buffer.readByte();

        //duplicate
        ByteBuf duplicate = buffer.duplicate();
        ByteBufUtils.debug(duplicate);

        //写
        duplicate.setByte(2, 65);
        ByteBufUtils.debug(duplicate);
        ByteBufUtils.debug(buffer);
    }
}
