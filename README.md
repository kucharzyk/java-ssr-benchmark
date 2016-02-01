# java-ssr-benchmark

> Java server side rendering benchmark

## Features:

* Nashorn server side rendering with React [(https://github.com/facebook/react)](https://github.com/facebook/react)
* Nashorn server side rendering with Preact [(https://github.com/developit/preact)](https://github.com/developit/preact)

## Build and run server:

``` bash
# compile and start
 mvn spring-boot:run
```

## Only rebuild javascript:

``` bash
# compile javascipt
 npm run build
```

server will start on [http://localhost:8080/](http://localhost:8080/)


## My home PC spec:
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
C:\siege-windows>siege -q -b -c 50 -t60s http://localhost:8080/react

Lifting the server siege...      done.

Transactions:                  67475 hits
Availability:                  98.94 %
Elapsed time:                  59.86 secs
Data transferred:              46.21 MB
Response time:                  0.04 secs
Transaction rate:            1127.19 trans/sec
Throughput:                     0.77 MB/sec
Concurrency:                   48.33
Successful transactions:       67475
Failed transactions:             726
Longest transaction:            4.51
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

## Benchmarks using apache benchmark (other machine)

* Main page (with no server side rendered context)

```
root@tkucharzyk:/home/tomasz# ab -n 10000 -c150 http://localhost:9999/
This is ApacheBench, Version 2.3 <$Revision: 1638069 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 1000 requests
Completed 2000 requests
Completed 3000 requests
Completed 4000 requests
Completed 5000 requests
Completed 6000 requests
Completed 7000 requests
Completed 8000 requests
Completed 9000 requests
Completed 10000 requests
Finished 10000 requests


Server Software:        Apache-Coyote/1.1
Server Hostname:        localhost
Server Port:            9999

Document Path:          /
Document Length:        352 bytes

Concurrency Level:      150
Time taken for tests:   0.802 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      5390000 bytes
HTML transferred:       3520000 bytes
Requests per second:    12467.10 [#/sec] (mean)
Time per request:       12.032 [ms] (mean)
Time per request:       0.080 [ms] (mean, across all concurrent requests)
Transfer rate:          6562.27 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   1.3      1       8
Processing:     0    9   7.7      7     201
Waiting:        0    8   7.4      6     200
Total:          0   10   7.7      8     202

Percentage of the requests served within a certain time (ms)
  50%      8
  66%     11
  75%     13
  80%     15
  90%     19
  95%     25
  98%     32
  99%     38
 100%    202 (longest request)
```

* React page

```
root@tkucharzyk:/home/tomasz# ab -n 10000 -c150 http://localhost:9999/react/
This is ApacheBench, Version 2.3 <$Revision: 1638069 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 1000 requests
Completed 2000 requests
Completed 3000 requests
Completed 4000 requests
Completed 5000 requests
Completed 6000 requests
Completed 7000 requests
Completed 8000 requests
Completed 9000 requests
Completed 10000 requests
Finished 10000 requests


Server Software:        Apache-Coyote/1.1
Server Hostname:        localhost
Server Port:            9999

Document Path:          /react/
Document Length:        730 bytes

Concurrency Level:      150
Time taken for tests:   8.224 seconds
Complete requests:      10000
Failed requests:        8833
   (Connect: 0, Receive: 0, Length: 8833, Exceptions: 0)
Non-2xx responses:      688
Total transferred:      8838943 bytes
HTML transferred:       6982703 bytes
Requests per second:    1216.01 [#/sec] (mean)
Time per request:       123.355 [ms] (mean)
Time per request:       0.822 [ms] (mean, across all concurrent requests)
Transfer rate:          1049.63 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   1.0      0      12
Processing:     1  106 348.4      7    2183
Waiting:        0  106 348.3      6    2183
Total:          1  107 348.4      8    2183

Percentage of the requests served within a certain time (ms)
  50%      8
  66%     18
  75%     28
  80%     38
  90%     85
  95%   1194
  98%   1459
  99%   1728
 100%   2183 (longest request)
```

* Pract page

```
root@tkucharzyk:/home/tomasz# ab -n 10000 -c150 http://localhost:9999/preact/
This is ApacheBench, Version 2.3 <$Revision: 1638069 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 1000 requests
Completed 2000 requests
Completed 3000 requests
Completed 4000 requests
Completed 5000 requests
Completed 6000 requests
Completed 7000 requests
Completed 8000 requests
Completed 9000 requests
Completed 10000 requests
Finished 10000 requests


Server Software:        Apache-Coyote/1.1
Server Hostname:        localhost
Server Port:            9999

Document Path:          /preact/
Document Length:        642 bytes

Concurrency Level:      150
Time taken for tests:   1.047 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      8290000 bytes
HTML transferred:       6420000 bytes
Requests per second:    9547.92 [#/sec] (mean)
Time per request:       15.710 [ms] (mean)
Time per request:       0.105 [ms] (mean, across all concurrent requests)
Transfer rate:          7729.72 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   1.1      1       9
Processing:     0   11   7.6     11     405
Waiting:        0   10   7.2     10     402
Total:          1   13   7.4     12     405

Percentage of the requests served within a certain time (ms)
  50%     12
  66%     14
  75%     16
  80%     17
  90%     20
  95%     23
  98%     27
  99%     29
 100%    405 (longest request)
```



## Final notes

* All tests was run after proper JVM warmup
* React does not perform well on nashrorn becouse it's not thread-safe and Nashorn throws concurency exceptions
* See failed transations count for React
* React should be run with dedicated ScriptEngine instance per thread (performance degradation)
* It looks like Preact (3KB React clone) is thread safe and run surprisingly well.
