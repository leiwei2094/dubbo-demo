package com.leolei.dubbodemo.api;

import java.io.FileNotFoundException;
import java.io.InputStream;

public interface IFileService {
    public void upload(String destPath, InputStream stream) throws FileNotFoundException;
}
