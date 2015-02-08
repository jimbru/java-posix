package com.jimbru.jposix;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class Unistd {

    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("c", CLibrary.class);

        void printf(String format, Object... args);

        int execl(String path, String... args);
    }

    public static void main(String[] args) {
        CLibrary.INSTANCE.printf("Hello from JNA!\n");
        CLibrary.INSTANCE.execl("/bin/sh");
    }
}
