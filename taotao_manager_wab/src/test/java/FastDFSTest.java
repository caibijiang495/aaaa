import com.taotao.util.FastDFSClient;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.IOException;

public class FastDFSTest {
    @Test
    public void testFastDFS() throws Exception {
        //1.创建配置文件fastdfs.conf 用来链接tracker_server(虚拟机上安装的服务端)
        //2.加载配置文件
        ClientGlobal.init("D:\\Idea_GongCheng\\taotao_parent\\taotao_manager_wab\\src\\main\\resources\\resource\\fastdfs.conf");
        //3.构建TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        //4.构建TrackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //5.构建StorageServer对象
        StorageServer storageServer = null;
        //6.构建StorageClient对象 需要参数
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        //7.使用storageClient上传图片(使用local本地文件路径)
        //参数1是文件路径,参数2是文件扩展名,不带点,参数3是源数据(图片高度宽度等,不需要填写)
        String[] jpgs = storageClient.upload_file("C:\\Users\\Administrator\\Desktop\\图片素材\\a.png", "jpg", null);
        for (String jpg : jpgs) {
            System.out.println(jpg);
        }
    }
    @Test
    public void testFastDFSClient() throws Exception {
        FastDFSClient fastDFSClient = new FastDFSClient("D:\\Idea_GongCheng\\taotao_parent\\taotao_manager_wab\\src\\main\\resources\\resource\\fastdfs.conf");
        String jpg = fastDFSClient.uploadFile("C:\\Users\\Administrator\\Desktop\\图片素材\\a.png", "jpg");
        System.out.println(jpg);
    }
}
