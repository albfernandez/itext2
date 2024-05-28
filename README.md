# itext2

Java Library to create and manipulate PDF on the fly

This is a fork of iText 2.1.7 version, the last version under MPL/LGPL

## License

MPL / LGPL

## Goals

This library is a fork of iText 2.1.7. Main goals are:

* Maintain API compatibility with iText 2.1.7.
* Maintain JDK compatibility: Update code base to keep runing on new and old JDK releases.
* Maintain BouncyCastle compatibility: Update code base to keep compatibility with new BouncyCastle releases.
* Better support for Linux.
* Bug Fixing.

## Use iText2 as Maven dependency
Add this to your pom.xml file to use the latest version of OpenPDF:

```xml
<dependency>
    <groupId>com.github.albfernandez</groupId>
    <artifactId>itext2</artifactId>
    <version>2.2.2</version>
</dependency>
```

## Building from sources

```bash

    git clone https://github.com/albfernandez/itext2.git
    cd itext2
    mvn clean package
    
``` 
