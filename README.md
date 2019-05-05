# excel2img
将excel里面的数据转化为图片

# 项目打包

```shell
mvn clean install 
```

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.4.RELEASE)

2019-05-05 16:26:30.620  INFO 1152 --- [           main] c.c.w.e.Excel2imgApplicationTests        : Starting Excel2imgApplicationTests on DESKTOP-S3567M0 with PID 1152 (started by siss-cll in C:\Users\siss-cll\Desktop\lottery-mb\excel2img)
2019-05-05 16:26:30.621  INFO 1152 --- [           main] c.c.w.e.Excel2imgApplicationTests        : The following profiles are active: local
2019-05-05 16:26:33.355  INFO 1152 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-05-05 16:26:33.861  INFO 1152 --- [           main] c.c.w.e.Excel2imgApplicationTests        : Started Excel2imgApplicationTests in 3.897 seconds (JVM running for 5.554)
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.519 s - in cn.clare.www.excel2img.Excel2imgApplicationTests
2019-05-05 16:26:34.419  INFO 1152 --- [       Thread-2] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:3.1.1:jar (default-jar) @ excel2img ---
[INFO] Building jar: C:\Users\siss-cll\Desktop\lottery-mb\excel2img\target\excel2img-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.1.4.RELEASE:repackage (repackage) @ excel2img ---
[INFO] Replacing main artifact with repackaged archive
[INFO]
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ excel2img ---
[INFO] Installing C:\Users\siss-cll\Desktop\lottery-mb\excel2img\target\excel2img-0.0.1-SNAPSHOT.jar to C:\Users\siss-cll\.m2\repository\cn\clare\www\excel2img\0.0.1-SNAPSHOT\excel2img-0.0.1-SNAPSHOT.jar
[INFO] Installing C:\Users\siss-cll\Desktop\lottery-mb\excel2img\pom.xml to C:\Users\siss-cll\.m2\repository\cn\clare\www\excel2img\0.0.1-SNAPSHOT\excel2img-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  40.750 s
[INFO] Finished at: 2019-05-05T16:26:43+08:00
[INFO] ------------------------------------------------------------------------

```

显示以上结果 就为成功


启动jar文件

···shell
cd target

 java -jar excel2img-0.0.1-SNAPSHOT.jar --server.port=8080

···

显示以下结果

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.4.RELEASE)

2019-05-05 16:48:03.155  INFO 3960 --- [           main] c.c.www.excel2img.Excel2imgApplication   : Starting Excel2imgApplication v0.0.1-SNAPSHOT on DESKTOP-S3567M0 with PID 3960 (C:\Users\siss-cll\Desktop\lottery-mb\excel2img\target\excel2img-0.0.1-SNAPSHOT.jar started by siss-cll in C:\Users\siss-cll\Desktop\lottery-mb\excel2img\target)
2019-05-05 16:48:03.163  INFO 3960 --- [           main] c.c.www.excel2img.Excel2imgApplication   : The following profiles are active: local
2019-05-05 16:48:05.485  INFO 3960 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2019-05-05 16:48:05.584  INFO 3960 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2019-05-05 16:48:05.585  INFO 3960 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.17]
2019-05-05 16:48:05.750  INFO 3960 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2019-05-05 16:48:05.750  INFO 3960 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2468 ms
2019-05-05 16:48:06.075  INFO 3960 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-05-05 16:48:06.452  INFO 3960 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2019-05-05 16:48:06.460  INFO 3960 --- [           main] c.c.www.excel2img.Excel2imgApplication   : Started Excel2imgApplication in 4.12 seconds (JVM running for 4.783)


```


使用浏览器访问

```
localhost:8080/excel?name=D:\Tencent\WeChat Files\chu1062186165\FileStorage\File\2019-05\四厂\压力表选型工具（天川）.xlsx
```

注意 `D:\Tencent\WeChat Files\chu1062186165\FileStorage\File\2019-05\四厂\压力表选型工具（天川）.xlsx` 为Excel文件路径



