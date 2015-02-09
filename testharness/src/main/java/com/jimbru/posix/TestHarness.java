package com.jimbru.posix;

import com.jimbru.posix.Posix;
import java.util.Arrays;

public class TestHarness {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar testharness.jar <fn> <arg0> ... <argN>");
            System.exit(1);
        }

        String fn = args[0];
        String args_first = args[1];
        String[] args_rest = Arrays.copyOfRange(args, 1, args.length);

        if (fn.equals("execv")) {
            Posix.execv(args_first, args_rest);
        } else if (fn.equals("execve")) {
            Posix.execve(args_first, args_rest, new String[]{"PATH=/bin", "TEST=abc"});
        } else if (fn.equals("execvp")) {
            Posix.execvp(args_first, args_rest);
        } else {
            System.out.printf("Unknown function: %s\n", fn);
            System.exit(1);
        }
    }
}
