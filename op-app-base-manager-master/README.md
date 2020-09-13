# op-app-base-manager 

abm app-base-manager    应用基础管理平台  前端应用模块  

项目说明：
1、前后端分离条件下，使用token 实现前后端分离;并构建通用后台权限管理框架


2、关键技术： dedupKey 根据合理的业务生成  
3、防重增加 dedupKey + 分布式锁方案
4、防重update  乐观锁方案     业务状态控制+数据库事务+乐观锁多重防止数据不一致



为移动端提供接口平台
主要关键技术：
spring
JWT
APIDoc
接口安全机制 
支持多节点
支持大并发
Swagger构建 


JWT 知识点
https://blog.csdn.net/ech13an/article/details/80779973
https://blog.csdn.net/sun_t89/article/details/51923017


## 
角色权限整体解决方案
平台统一角色管理 -统一人员角色接口
人员-角色 1对多

角色-权限菜单下放给各应用单独模块处理 - 应用初始化脚本处理一般设置 分配系统管理员 


菜单只支持二级菜单 优雅与体验    


用户与角色-多对多 

角色与菜单-多对多


角色-有父菜单权限就必有至少一个子菜单  （前后端共同控制）

多角色 菜单需要遍历一遍，生成菜单

菜单顺序可以使用一个序列号（顺序号构建）

 
 
 ## 第二版技术构建  
 Spring Security + Json Web Token 