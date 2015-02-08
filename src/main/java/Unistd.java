package com.jimbru.posix;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class Unistd {

    interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary(Platform.C_LIBRARY_NAME, CLibrary.class);

        void printf(String format, Object... args);

        int execl(String path, String... args);
    }

    public static void main(String[] args) {
        CLibrary.INSTANCE.printf("Hello from JNA!\n");
        CLibrary.INSTANCE.execl("/bin/sh");
    }
}
