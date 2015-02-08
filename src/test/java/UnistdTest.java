package com.jimbru.posix;

import com.jimbru.posix.Unistd;
import org.junit.Assert;
import org.junit.Test;

public class UnistdTest {

    @Test
    public void doSomething() {
        Unistd.CLibrary.INSTANCE.printf("foo bar %s!", "baz");
    }
}
