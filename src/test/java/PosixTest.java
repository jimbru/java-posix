package com.jimbru.posix;

import com.jimbru.posix.Posix;
import org.junit.Assert;
import org.junit.Test;

public class PosixTest {

    @Test
    public void doSomething() {
        Posix.printf("foo bar %s!", "baz");
    }
}
