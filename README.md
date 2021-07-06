# RxTuples
RxTuples is a library to smooth RxJava usage by adding simple Tuple creation functions.

For the RxJava 2.X version, please go to  [RxTuples2](https://github.com/pakoito/RxTuples2).

### Rationale

Quite often when using RxJava you find the need to forward a value alongside the result of an operation, combine several values, or simply adding an external value to the current internal state of the chain. For this you either create ad-hoc types that may only be used locally, which is inefficient.

Other languages have the concept of a Tuple built into them, which is an in-place list of values. Lots of Java libraries implement their own concept of Tuple, being a Pair, a Point, or VecX types. This library uses [javatuples](http://www.javatuples.org/) in an attempt to unify them[.](https://imgs.xkcd.com/comics/standards.png) Javatuples are all "typesafe, immutable, iterable, serializable, comparable" classes  ranging from 1 to 10 elements.

# Source
*****Inspired by GIthub link add version information as well 

## Features
*****Key Features added by this library

## Dependency
****How to add the dependency

## Usage
*****How to use your library 

## Future work
*****Current unsupported features are something which we will implement in future, if there are no features dont add this

License
--------
Copyright (c) pakoito 2015 \
Copyright (C) 2020-21 Application Library Engineering Group

The Apache Software License, Version 2.0

See LICENSE.md
