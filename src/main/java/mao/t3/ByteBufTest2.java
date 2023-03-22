package mao.t3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import mao.utils.ByteBufUtils;

import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：Netty_ByteBuf
 * Package(包名): mao.t3
 * Class(类名): ByteBufTest2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/22
 * Time(创建时间)： 14:42
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class ByteBufTest2
{
    public static void main(String[] args)
    {
        //创建一个16字节的ByteBuf
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16);
        buffer.writeCharSequence("12345", StandardCharsets.UTF_8);
        //打印
        ByteBufUtils.debug(buffer);
        //设置数据
        buffer.setByte(0, 0x45);
        //打印
        ByteBufUtils.debug(buffer);
        //设置数据
        buffer.setByte(2, 0x47);
        //打印
        ByteBufUtils.debug(buffer);
    }
}
