# autorest and jersey

##Build

```
mvn clean package
```

##Run

Erst den Devmode starten:

```
mvn gwt:codeserver -pl *-client -am
```

... dann den Jetty:

```
mvn jetty:run -pl *-server -am -Denv=dev
```