java-posix
==========

Easily call standard POSIX functions from Java.

For reasons unknown, the JVM does not provide access to a number of POSIX
functions. Usually it provides more appropriate alternatives, but sometimes it
doesn't. This is a small library that wraps JNA to provide POSIX built-ins that
Java has neglected.

At the moment, that means the `execve` family of functions.

# Use

Install using your build tool of choice.

```java
import com.jimbru.posix.Posix

Posix.execve("/bin/sh", new String[]{"/bin/sh", "-c", "foobar"}, new String[]{"PATH=/opt/foobar:/bin"});
```

Functions are all defined as static and except where noted, arguments and
conventions should match up with their `libc` originals. See `man <function>`
for more info.

# Compilation

This project uses Gradle. To build:

```sh
./configure
gradle build
```

Artifacts will be placed in `posix/build/libs/`.

# Author

Copyright © 2015 Jim Brusstar, licensed under the terms of the MIT license.
