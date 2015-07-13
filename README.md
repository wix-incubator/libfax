# libfax
A simple Java/Scala outgoing fax [SPI](https://en.wikipedia.org/wiki/Service_provider_interface), including out-of-the-box implementations for
* [InterFax SecureLounge](http://www.interfax.net/en/solutions/pci_fax/outbound_pci)
* [Phaxio](https://www.phaxio.com/)
* [Concord Fax](http://concordfax.com/)

This library is actively used by [Wix.com](http://www.wix.com/) to deliver mission-critical food orders to your favorite restaurants.

## Usage
In a nutshell, usage is as simple as instantiating one of the fax provider implementations, and calling `send` with some HTML and destination fax number. You get back a fax document ID that you can query with `retrieveStatus`.

Of course, you'll need to have an account with the fax provider. Sending faxes isn't free, you know.

For actual code, see the [IT](https://en.wikipedia.org/wiki/Integration_testing) suite that accompanies each fax provider implementation.

## Installation
### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.wix.fax</groupId>
  <artifactId>libfax-all</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Reporting Issues

Please use [the issue tracker](https://github.com/wix/libfax/issues) to report issues related to this library.

## License
This library uses the Apache License, version 2.0.

## Contributions
Want to see your fax provider supported by this library? Awesome, we do too!
* Implement the `Fax` trait in any JVM supported language (Scala, Java, Clojure, ...)
* Include a test-kit module for integration testing (see the included *-testkit modules for reference).
* Create a pull request, or add an issue with a link to your implementation
