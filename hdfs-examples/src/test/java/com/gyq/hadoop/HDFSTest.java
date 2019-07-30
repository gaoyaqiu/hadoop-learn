package com.gyq.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

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

    @Test
    public void testMkdir() throws IllegalArgumentException, IOException {
        fs.mkdirs(new Path("/a/b"));
    }
}
