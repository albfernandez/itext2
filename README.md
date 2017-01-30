# itext2

Java Library to create and manipulate PDF on the fly

This is a fork of 2.1.7 version, the last version under MPL/LGPL

## License

MPL / LGPL

## Goals

This library is a fork of iText 2.1.7. Main goals are:

* Mantain API compatibility with iText 2.1.7: As much as posible, not doing API changes or be backwards compatible.
* Mantain JDK compatibility: Update code base to keep going on new JDK releases.
* Mantain BouncyCastle compatibility: Update code base to keep going on new BouncyCastle releases.
* Better support for Linux.
* Bug Fixing.



## Building from sources

```bash

    git clone https://github.com/albfernandez/itext2.git
    cd itext2
    mvn clean package
    
``` 

## Versions

### 2.1.9 (Unreleased)
* Updated to BouncyCastle 1.56 (1.48 - 1.56)
* Better text extraction
* Code cleanup

### 2.1.8 (30 August 2016)

* Mavenized project.
* Patches to image processing to work with JasperReports 6,
* Removes metadata on generated pdfs.
* Fix TIFFFaxDecoder, fails in some tiff files.
* Updated to BouncyCastle 1.54 (1.48 - 1.56)
