# javaWebDemo
- java web demo，以后开发web应用可以基于这个demo开发
- 使用方法：
    1. idea中checkout from version control
    2. 数据库初始化：在mysql数据库中执行sql脚本文件doc/sqlScript/databaseInit.sql
    3. 在idea中配置tomcat，默认端口8080
    4. 用浏览器访问 http://localhost:8080/hello2
- 主要功能：
    1. mvc结构完整，便于后期基于这个骨架实现业务逻辑
    2. 实现了mybatis热加载
    3. 实现了在开发环境中控制台打印sql语句
    4. 实现了利用maven让应用在不同的环境使用不同的配置
    5. 实现基于springSecurity的登录验证（默认用户名可以随便写，密码是：123）
    6. ErpApplication类添加注解（@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})）
    可以不注入springSecurity，达到不用登录验证的目的
    7. 有完整的日志功能，获取日志语句：private Logger logger = LoggerFactory.getLogger(this.getClass());
    8. 提供了mybatis自动生成代码插件
    9. 实现了mybatis的分页功能
    10. 实现了把maven依赖库和插件远程仓库配置在pom.xml中（目前是阿里云的仓库）
    11. 既支持通过 @RestController 注解生成restful风格（前后端分离用），也支持通过 @Controller 注解，把页面传到freemarker
    12. 实现了mybatisPlus的通用CRUD功能