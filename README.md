# System Property Extension

System Property Extension is a [Wiremock](http://wiremock.org/) extension that can take the request baseProxyUrl and replace it with a system property.
Built on the extensions platform of Wiremock, it allows your wiremock response to be dynamic and dependent on the request for a smarter testing procesis.

##Installation
```
<dependency>
		<groupId>be.rubengerits.wiremock</groupId>
		<artifactId>system-property-extension</artifactId>
		<version>1.0.0</version>
</dependency>
```

##Usage

[\[Download the system property extension jar file here.\]](https://github.com/rubengerits/system-property-extension/releases/download/system-property-extension-1.0.0/system-property-extension-1.0.0.jar)

[\[Download the Wiremock standalone jar here.\]](http://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-standalone/2.3.1/wiremock-standalone-2.3.1.jar)

Including the extension upon start on the command line via the `--extensions` flag. Note that the SystemPropertyTransformer jar is added to the classpath.

For Unix:
```
java -cp "system-property-extension-1.0.0.jar:wiremock-2.3.1-standalone.jar" com.github.tomakehurst.wiremock.standalone.WireMockServerRunner --verbose --extensions be.rubengerits.wiremock.SystemPropertyTransformer
```

For Windows:
```
java -cp "wiremock-body-transformer-1.1.5.jar;wiremock-2.3.1-standalone.jar" com.github.tomakehurst.wiremock.standalone.WireMockServerRunner --verbose --extensions be.rubengerits.wiremock.SystemPropertyTransformer
```

