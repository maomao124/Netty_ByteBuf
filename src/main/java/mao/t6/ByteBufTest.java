package mao.t6;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import mao.utils.ByteBufUtils;

/**
 * Project name(项目名称)：Netty_ByteBuf
 * Package(包名): mao.t6
 * Class(类名): ByteBufTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/22
 * Time(创建时间)： 15:25
 * Version(版本): 1.0
 * Description(描述)： slice
 */

@Slf4j
public class ByteBufTest
{
    public static void main(String[] args)
    {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16);
        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        ByteBufUtils.debug(buffer);
        log.debug(String.valueOf(buffer.readByte()));

        //这时调用 slice 进行切片，
        // 无参 slice 是从原始 ByteBuf 的 read index 到 write index 之间的内容进行切片，
        // 切片后的 max capacity 被固定为这个区间的大小，因此不能追加 write
        ByteBuf buffer2 = buffer.slice();
        ByteBufUtils.debug(buffer2);

        //如果原始 ByteBuf 再次读操作
        log.debug(String.valueOf(buffer.readByte()));
        ByteBufUtils.debug(buffer);

        //这时的slice后的ByteBuf不受影响，因为它有独立的读写指针
        ByteBufUtils.debug(buffer2);

        //如果slice后的ByteBuf的内容发生了更改
        buffer2.setByte(1, 68);
        ByteBufUtils.debug(buffer2);

        //这时，原始ByteBuf也会受影响，因为底层都是同一块内存
        ByteBufUtils.debug(buffer);
    }
}
