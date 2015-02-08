package com.jimbru.posix;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class Posix {

    interface CLibrary extends Library {
        void printf(String format, Object... args);
        int execl(String path, String... args);
    }

    private static CLibrary _instance = null;

    private static CLibrary getInstance() {
        if (_instance == null) {
            _instance = (CLibrary) Native.loadLibrary(Platform.C_LIBRARY_NAME, CLibrary.class);
        }
        return _instance;
    }

    public static void printf(String format, Object... args) {
        getInstance().printf(format, args);
    }

    public static int execl(String path, String... args) {
        return getInstance().execl(path, args);
    }

    public static void main(String[] args) {
        Posix.printf("Hello from JNA!\n");
        Posix.execl("/bin/sh");
    }
}
