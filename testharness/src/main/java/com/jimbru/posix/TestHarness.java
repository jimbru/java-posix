package com.jimbru.posix;

import com.jimbru.posix.Posix;
import com.sun.jna.LastErrorException;
import java.util.Arrays;

public class TestHarness {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar testharness.jar <fn> <arg0> ... <argN>");
            System.exit(1);
        }

        String path = args[1];
        String[] argv = Arrays.copyOfRange(args, 1, args.length);
        int ret = 0;

        try {
            switch (args[0]) {
                case "execv":
                    ret = Posix.execv(path, argv);
                    break;
                case "execve":
                    ret = Posix.execve(path, argv, new String[]{"PATH=/bin", "TEST=abc"});
                    break;
                case "execvp":
                    ret = Posix.execvp(path, argv);
                    break;
                default:
                    System.out.printf("Unknown function: %s\n", args[0]);
                    System.exit(1);
            }
        } catch (LastErrorException e) {
            // System.out.printf("LastErrorException: %s\n", e.toString());
            System.exit(2);
        }
        if (ret == -1) {
            System.out.printf("Function failed with return code: %d\n", ret);
            System.exit(2);
        }
    }
}
