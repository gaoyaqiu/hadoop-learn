package com.gyq.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

import static org.junit.Assert.assertTrue;

public class HDFSTest {

    private FileSystem fs;

    private static final String HDFS_ADDRESS = "hdfs://172.17.8.101:9000/";

    @Before
    public void init() throws Exception {
        Configuration configuration = new Configuration();
        System.setProperty("hadoop.home.dir", "C:\\data\\tools\\hadoop-2.7.3");
        configuration.set("fs.defaultFS", HDFS_ADDRESS);
        fs = FileSystem.get(new URI(HDFS_ADDRESS), configuration, "root");
    }

    /**
     * 创建目录
     *
     * @throws IllegalArgumentException
     * @throws IOException
     */
    @Test
    public void testMkdir() throws IOException {
        boolean result = fs.mkdirs(new Path("/a/b"));
        assertTrue(result);
        close();
    }

    /**
     * 上传文件
     *
     * @throws IOException
     */
    @Test
    public void testCreate() throws IOException {
        FileInputStream in = new FileInputStream("C:\\data\\tmp\\test.txt");
        FSDataOutputStream out = fs.create(new Path("/a/b/test.txt"));
        IOUtils.copyBytes(in, out, 1024);
        close();
    }

    /**
     * 下载文件
     *
     * @throws IOException
     */
    @Test
    public void testDownload() throws IOException {
        FSDataInputStream in = fs.open(new Path("/a/b/test.txt"));
        FileOutputStream out = new FileOutputStream("c:\\data\\tmp\\test2.txt");
        IOUtils.copyBytes(in, out, 1024);
        close();
    }

    /**
     * 列出所有目录及文件
     *
     * @throws IOException
     */
    @Test
    public void testListFiles() throws IOException {
        listFiles(new Path("/"));
    }

    private void listFiles(Path path) throws IOException {
        FileStatus[] fileStatuses = fs.listStatus(path);
        for (int i = 0; i < fileStatuses.length; i++) {
            FileStatus fileStatus = fileStatuses[i];
            if (fileStatus.isDirectory()) {
                System.out.println("目录: " + fileStatus.getPath());
                listFiles(fileStatus.getPath());
            } else {
                System.out.println(fileStatus.getPath());
            }
        }
    }

    /**
     * 删除文件
     *
     * @throws IOException
     */
    @Test
    public void testDelete() throws IOException {
        boolean result = fs.delete(new Path("/a/b/test.txt"), false);
        assertTrue(result);
        fs.close();
    }

    private void close() throws IOException {
        fs.close();
    }
}
