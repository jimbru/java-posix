package com.jimbru.jposix;

import com.jimbru.jposix.Unistd;
import org.junit.Assert;
import org.junit.Test;

public class UnistdTest {

    @Test
    public void doSomething() {
        Unistd.CLibrary.INSTANCE.printf("foo bar %s!", "baz");
    }
}
