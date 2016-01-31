# java-ssr-banchmark

> Java server side rendering benchmark

## Features:

* Nashorn server side rendering with React [(https://github.com/facebook/react)](https://github.com/facebook/react)
* Nashorn server side rendering with Preact [(https://github.com/developit/preact)](https://github.com/developit/preact)

## Run in production mode

``` bash
# compile and start
 mvn spring-boot:run
```

## Only rebuild javascript

``` bash
# compile javascipt
 npm run build
```

server will start on [http://localhost:8080/](http://localhost:8080/)


# My home PC spec:
* AMD FX 8350 4.0Ghz (8 cores)
* 16 GB RAM
* SSD
* Windows 10 64bit

## Benchmark results for my configuration using siege 3.0.5


* Main page (with no server side rendered context)

```
C:\siege-windows>siege -q -b -c 50 -t60s http://localhost:8080/

Lifting the server siege...      done.

Transactions:                 230464 hits
Availability:                 100.00 %
Elapsed time:                  59.55 secs
Data transferred:              70.33 MB
Response time:                  0.01 secs
Transaction rate:            3870.09 trans/sec
Throughput:                     1.18 MB/sec
Concurrency:                   43.87
Successful transactions:      230472
Failed transactions:               0
Longest transaction:            0.15
Shortest transaction:           0.00
```

* React page

```
C:\siege-windows>siege -q -b -c 50 -t60s http://localhost:8080/react/

Lifting the server siege...      done.

Transactions:                  57463 hits
Availability:                  98.67 %
Elapsed time:                  59.55 secs
Data transferred:              39.39 MB
Response time:                  0.05 secs
Transaction rate:             964.99 trans/sec
Throughput:                     0.66 MB/sec
Concurrency:                   48.47
Successful transactions:       57463
Failed transactions:            773
Longest transaction:            4.33
Shortest transaction:           0.00
```

* Preact page

```
C:\siege-windows>siege -q -b -c 50 -t60s http://localhost:8080/preact/

Lifting the server siege...      done.

Transactions:                 215366 hits
Availability:                 100.00 %
Elapsed time:                  59.57 secs
Data transferred:             128.58 MB
Response time:                  0.01 secs
Transaction rate:            3615.34 trans/sec
Throughput:                     2.16 MB/sec
Concurrency:                   44.50
Successful transactions:      215369
Failed transactions:               0
Longest transaction:            0.14
Shortest transaction:           0.00
```

## Final notes

* All tests was run after proper JVM warmup
* React does not perform well on nashrorn becouse it's not thread-safe and Nashorn throws concurency exceptions. 
* React should be run with dedicated ScriptEngine instance per thread (performance degradation)
* It looks like Preact (3KB React clone) is thread safe and run surprisingly well.
