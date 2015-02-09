package com.jimbru.posix;

import com.jimbru.posix.Posix;
import java.util.Arrays;

public class TestHarness {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar testharness.jar <fn> <arg0> ... <argN>");
            System.exit(1);
        }

        String args_first = args[1];
        String[] args_rest = Arrays.copyOfRange(args, 1, args.length);

        switch (args[0]) {
            case "execv":
                Posix.execv(args_first, args_rest);
                break;
            case "execve":
                Posix.execve(args_first, args_rest, new String[]{"PATH=/bin", "TEST=abc"});
                break;
            case "execvp":
                Posix.execvp(args_first, args_rest);
                break;
            default:
                System.out.printf("Unknown function: %s\n", args[0]);
                System.exit(1);
        }
    }
}
