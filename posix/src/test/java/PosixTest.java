package com.jimbru.posix;

import com.jimbru.posix.Posix;
import java.lang.Process;
import java.lang.ProcessBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;

public class PosixTest {

    private String harnessLocation = "../testharness/build/libs/testharness-all-0.1.0.jar";

    private int execHarness(String... args) {
        int ret = 0;
        ArrayList<String> cmd = new ArrayList<String>();
        cmd.addAll(Arrays.asList("java", "-jar"));
        cmd.add(this.harnessLocation);
        cmd.addAll(Arrays.asList(args));
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.inheritIO();
            Process p = pb.start();
            ret = p.waitFor();
        } catch (Exception e) {
            Assert.fail(e.toString());
        }
        return ret;
    }

    @Test
    public void execv() {
        Assert.assertEquals(5, this.execHarness("execv", "/bin/sh", "-c", "exit 5"));
    }

    @Test
    public void execve() {
        String test_cmd = "/usr/bin/env | /usr/bin/grep -q 'TEST=abc'";
        Assert.assertEquals(0, this.execHarness("execve", "/bin/sh", "-c", test_cmd));
    }

    @Test
    public void execvp() {
        Assert.assertEquals(5, this.execHarness("execvp", "sh", "-c", "exit 5"));
    }
}
