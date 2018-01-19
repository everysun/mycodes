package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wangdecheng on 2017/12/18.
 */
public class FileChannelDemo {

    public static void main(String[] args){

        try {
            RandomAccessFile accessFile = new RandomAccessFile("data/testFileChannel.txt","rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int byteRead = fileChannel.read(byteBuffer);
            while (byteRead != -1){
                System.out.println("Read "+ byteRead);
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.print((char)byteBuffer.get());
                }
                byteBuffer.clear();
                byteRead = fileChannel.read(byteBuffer);
            }
            accessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
