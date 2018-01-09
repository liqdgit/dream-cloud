# DREAM-COULD
## 开发时所遇问题总结：
### 网关路由不了
  详情请看：https://segmentfault.com/q/1010000009396363 http://blog.csdn.net/chenqipc/article/details/53322830
  给所有映射添加前缀，可以设置 zuul.prefix 一个值，比如/api。这个前缀默认会删除，在请求跳转之前。（通过 zuul.stripPrefix=false 可以关闭这个功能）。你也可以在单个服务中关闭这个功能, 例如:
  application.yml zuul: routes: users: path: /myusers/** stripPrefix: false
  zuul.stripPrefix只使用于使用了zuul.prefix配置情况下。在一个定义好了的 route’s path中不会有任何影响。
  在这个例子中，”users”service的请求”/myusers/101”将会跳转到”/myusers/101”。
  zuul.routes 实际上绑定到类型为 ZuulProperties 的对象上. 如果你查看这个对象你会发现一个叫”retryable”的字段, 设置为”true”会使Ribbon客户端自动在失败时重试(如果你需要修改重试参数, 可以使用Ribbon client configuration)
  X-Forwarder-Host请求头默认添加到转发请求中。设置zuul.addProxyHeaders=false禁用它。路径前缀默认被删除， 到后台服务的请求会添加一个 “X-Forwarded-Prefix”(“/myusers”在上面的例子中)。
  一个@EnableZuulProxy的应用可以作为单机使用如果你设置了一个默认路由（”/”），例如zuul.route.home: / 会把所有的请求（”/\**”）转到home服务。
  如果需要更细粒度的忽略配置，你可以指定特殊的表达式来配置忽略规则.这些表达式从route location的开始进行匹配，意味着前缀应该被包括在匹配表达式中. 忽略表达式影响所有服务和取代任何路由的特殊配置.
  application.yml zuul: ignoredPatterns: //admin/ routes: users: /myusers/**
  这个的意思是所有请求, 比如”/myusers/101”的请求会跳转到”users”服务的”/101”, 但包含”/admin/”的请求将不被处理.
### springcloud feign 注入bean null问题
springcloud feign 注入bean null问题 解决办法：
如果swagger版本是v1.x，那么请参考：https://segmentfault.com/a/1190000006595187
如果swagger版本是v2.x，那么请将升级swagger版本到2.5.0以上即可。 详情请看：http://blog.csdn.net/caidchen/article/details/73949624
### 调用服务时出现404
服务提供者Controller注解必须使用@RestController，不能使用@Controller，否则找不到该服务
### 使用Feign接口调用时，如果是多个参数需要用@RequestParam注解或者其他，否则调不通
