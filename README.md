[![Build Status](https://travis-ci.org/javadelight/delight-strings.svg)](https://travis-ci.org/javadelight/delight-strings)

# delight-strings

Utilities to work with Strings.

Part of the [Java Delight Suite](http://javadelight.org).

# Usage

Generate a random string:

    String rnd = new RandomString(5).nextString();
    // rnd = "s4fWf" or similar

Remove special characters:

    String san = SanitizeStrings.getSimpleName("hj&^aas", 5);
    // san = "hj__a"

Get domain from URI:

    String domain = UriUtils.getDomain("https://objecthub.io/docs");
    // domain = "objecthub.io"

Get parent in URI:

    String parent = UriUtils.getParent("https://objecthub.io/users/u1");
    // parent = "https://objecthub.io/users"

# Maven

    <dependency>
        <groupId>org.javadelight</groupId>
        <artifactId>delight-strings</artifactId>
        <version>0.0.3</version>
    </dependency>
    
Find out latest version [here](http://modules.appjangle.com/delight-strings/latest/project-summary.html).

Use [Java Delight Repository](https://github.com/javadelight/delight-main#maven-repository).

# Further Documentation

- [JavaDocs](http://modules.appjangle.com/delight-strings/latest/apidocs/index.html)
- [All Maven Reports](http://modules.appjangle.com/delight-strings/latest/project-reports.html)