# 布壳儿项目(二期)
>一期线上地址: [布壳儿](https://www.buukle.top/)
## 0. 背景
### 0.1 项目简介
````
布壳儿项目(以下简称"布壳儿")目前是一个在萌芽状态的,开源,免费,公益性质的java在线分享项目.
由@elvin(email: 18001268330@163.com)独立开发.目的是为java开发工程师提供一个垂直的精
细的站点.在布壳儿,java er们能分享交流自己的学习经验,技术心得.同时能有一个空间记录开发生
活中发生点滴趣事的照片流.目前网站没有营收,网站运营资源由elvin承担.预计将把网站的营收除去
运营成本外,提供给公益基金(如果有的话 ^_^).

                               ------一个很天真纯粹的想法,但是很想坚持做下去的人
````
### 0.2 本期开发需求要点
````
对一期技术升级:
    1. dubbo --> dubbox[2.8.0] 添加restful接口支持;
    2. ssm   --> springBoot [2.0.5] +spring-data-mybatis 发布形式改为jar包部署发布;
对一期项目结构重构 : 
    1. 拆分buukle-plugin 子项目
    2. 重构项目子父结构
````

## 1. 技术选型
````
springBoot[2.0.5.RELEASE] +rabbitMQ + dubbox[2.8.0] + mybatis[1.3.1] + redis[jedis-2.9.0] + zookeeper
注意 : dubbox 2.8.0 jar 需要下载源码自行打包并安装到本地/私有依赖版本库服务; 

````
>可参考: [dubbo 2.8.4（dubbox）从git下载到安装至maven本地仓库](https://blog.csdn.net/jfqqqqq/article/details/79559036)
## 2. 项目搭建
###2.1 项目结构:
\
buukle-all\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-common\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-daoEntity\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-api\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|------buukle-api-inner\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|------buukle-api-out\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-plugin\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|------buukle-plugin-sso\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|------buukle-plugin-mq\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-provider-mc\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-provider-sso\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-consumer-cms\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-consumer-portal\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-consumer-article\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|---------buukle-consumer-album\
###2.2 buukle-all 父工程(pom)
````
1. 依赖spring-boot-parent ,为项目提供boot环境
2. 集中统一管理依赖版本
3. 按照2.中的版本号,集中依赖公用类库,为项目和子工程提供web环境

````
###2.3 buukle-common 工具包工程 (pom)
````
此工程主要为项目提供常规工具,例如 : 
1. baseRequest : 封装请求类,其实例包含两个部分,即 自定义类型requestHead 和 
   泛型类型(T)info参数对象,其主要用于在项目间沟通时,传递调用方基本信息和请求参数,baseResponse 则封装被调用方响应的基本信息和数据.
2. baseException 全局异常的自定义相关,用于项目工程自身之内,以及工程之间的异常处理和传递.
3. util子包下一些常规工具类,例如:
    <1> springContextUtil(继承ApplicationContextAware) 用于灵活处理spring容器级别的bean对象;
    <2> SpringEnvironmentUtil(继承EnvironmentAware) ,此对象维护了系统配置文件:application.properties
    或application.yml以及placeholder声明的一些配置文件,配置bean中的参数.作为properties中的key,value存储;
    (详细可看 EnvironmentAware/Environment 类源码) 用于灵活处理spring Environment对象中的参数;应用此对象
    可对apring环境变量(Environment)进行操作,从而达到一些不常用的目的.(比如,动态指定requestMapping的映射路径)
    <3> ThreadLocalUtil(继承ThreadLocal) 用于灵活处理线程级别的参数;
    <4> jedis子包下,利用模板模式封装spring-data-redis的api,更加方便的使用redis命令如RedisString等;
        其中也封装了jedis的一些功能工具模块,开发者可直接用工厂+ 模板类通过编写回调逻辑直接使用分布式锁等工具;
    ......
````
###2.4 buukle-api 程序接口工程 (application_interface)

####此工程主要管理项目中所有的服务接口,其包含以下两个子工程:

####2.4.1 buukle-api-inner 内部接口工程(jar)

````
此工程负责管理项目内部间相互沟通的接口 :
    <1> 内部工程应用dubbox可在注册中心注册不同功能的接口服务,此时内部项目可直接引入此接口依赖,
        并在dubbox配置中引入接口服务,便可直接调用远程接口的方法;
    <2> 内部项目之间也可通过dubbox在此项目rest子包下发布rest接口服务,用于适应非dubbox子工程
        和dubbox不友好子项目的rest接口调用需求;
        
````
####2.4.2 buukle-api-out 外部接口工程(jar)
````
此工程负责管理项目内部工程与外部项目进行交流的接口 :
    <1> 自工程可通过本工程rest子包下对外发布rest接口,此时项目外的组织或个人即可调用api方法;例如 :
    buukle-provider-sso对外暴露的登录,注册接口,第三方应用可便捷接入系统;
    
````
###2.5 buukle-plugin 插件工程(pom)

####此工程主要管理项目中所有的插件工具,目前主要分为以下两个工程(可根据需求扩展)
####2.5.1 buukle-plugin-mq 消息插件

````
此工程负责提供相应的消息工具,例如 :
    <1> 单点退出时,发通知广播其他应用及时下线;
    <2> 接受第三方异步通知的消息内容,并做后续处理
````
####2.5.2 buukle-plugin-sso 单点登陆&授权接入插件(jar)
````
此工程负责提供单点登录功能的接入 :
    <1> 该插件通过spring拦截器(inteceptor)实现,应用可通过配置相应的interceptor,传入指定的参数即可接入;
    <2> 传入参数可通过配置文件,也可在直接在代码中用@bean,或者直接new配置;

此工程负责提供认证授权功能 :
    <1> 该插件通过拦截请求,验证用户的cookie缓存的用户信息,并对uri作权限验证 
````
###2.6 buukle-provider-mc 管理中心服务工程 (executable jar)
````
此工程主要为项目提供后台数据处理服务,是一个纯粹的接口服务工程.
    
    1. 严格按照springboot规范来讲,是可以在每个为服务内部实现service层和dao层,做自己的数据服务.
    但是有些模块,用到公用的service,dao层逻辑,这时候没有必要每个为微服务都实现业务层和数据层,
    这时候就需要一个管理中心对接口进行统一的管理.
    2. 提供全局验签服务
````
###2.7 buukle-provider-sss 单点登录&授权接口服务工程 (executable jar)
````
此工程主要为项目提供单点登录数据处理服务以及缓存服务,是一个纯粹的接口服务工程.
    此工程接收buukle-sso-plugin 插件发送的请求,并对请求作相应的登录,认证,授权的处理.其中需要用到
    与buukle-provider-mc(简称mc)做交互,用于用户数据的采集和缓存.
````
###2.8 buukle-consumer-cms 用户管理系统(executable jar)
````
此工程主要为项目提供用户后台管理服务

    不同身份角色的用户,通过不同的菜单按钮实现文章的发布,流程的控制
    等功能,主要分为几个核心模块: 首页 | 文章管理 | 数据统计 | 权限管理 | 系统设置 等;分别
    对应不同的功能流程;
````
###2.9 buukle-consumer-portal 门户系统(executable jar)
````
 此工程主要为项目提供用户门户服务,未登录用户可通过门户完成 :
        
        1. 首页浏览推送轮播的文章推荐;
        2. 登录门进入门户.
````
###3.0 buukle-consumer-article 文章系统(executable jar)
````
 此工程主要为项目提供文章服务,用户可通过文章系统
 
    1. 应用左侧导航栏以及右侧最新top5挑选喜欢的文章进行浏览;
    2. 通过文章右上方的分享组件,对文章进行分享;
    2. 通过按钮对文章点赞;
    4. (登录后)通过文章下的留言板对问张金祥评论和回复;
    5. (登录后)文章作者可以对评论进项管理;
    6. 后台通过消息处理文章的访问数据等;
     
````
###3.1 buukle-consumer-album 相册系统(executable jar)
````

此工程主要为项目提供相册服务
    暂时只对管理员开放,普通用户无法上传,只能浏览;(考虑到人工审核成本比较大,自动审核风险比较大,暂时不作开放)
````
