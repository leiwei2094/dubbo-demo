package com.leolei.dubbodemo.api;

import java.io.FileNotFoundException;
import java.io.InputStream;

public interface IFileService2 {
    public void upload(InputStream stream,String destPath) throws FileNotFoundException;
}
