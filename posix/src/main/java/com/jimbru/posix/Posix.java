package com.jimbru.posix;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class Posix {

    private interface CLibrary extends Library {
        int execv(String path, String[] argv);
        int execve(String path, String[] argv, String[] envp);
        int execvp(String file, String[] argv);
    }

    private static CLibrary _instance = null;

    private static CLibrary getInstance() {
        if (_instance == null) {
            _instance = (CLibrary) Native.loadLibrary(Platform.C_LIBRARY_NAME, CLibrary.class);
        }
        return _instance;
    }

    public static int execv(String path, String[] argv) {
        return getInstance().execv(path, argv);
    }

    public static int execve(String path, String[] argv, String[] envp) {
        return getInstance().execve(path, argv, envp);
    }

    public static int execvp(String file, String[] argv) {
        return getInstance().execvp(file, argv);
    }
}
