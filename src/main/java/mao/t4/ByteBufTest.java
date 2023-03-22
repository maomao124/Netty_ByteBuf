package mao.t4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import mao.utils.ByteBufUtils;

import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：Netty_ByteBuf
 * Package(包名): mao.t4
 * Class(类名): ByteBufTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/22
 * Time(创建时间)： 14:50
 * Version(版本): 1.0
 * Description(描述)： 扩容测试
 */

@Slf4j
public class ByteBufTest
{
    public static void main(String[] args)
    {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16);
        buffer.writeBytes("123456789012345".getBytes(StandardCharsets.UTF_8));
        ByteBufUtils.debug(buffer);
        //再次写入，发现空间不够，触发扩容
        buffer.writeInt(0x3369);
        ByteBufUtils.debug(buffer);
    }
}
