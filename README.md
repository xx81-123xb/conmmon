# conmmon
maven创建私服仓库demo

1.maven的setting.xml配置添加server,![image](https://github.com/xx81-123xb/conmmon/assets/98568292/142f1e13-d11e-48e2-8634-74f3c35f080b)

2.其他的跟着本项目的pom操作即可,配置完后执行mvn clean deploy即可发布到github仓库


使用:
1.在其他项目使用的时候,先在pom中配置仓库:![image](https://github.com/xx81-123xb/conmmon/assets/98568292/2353a7d4-1a88-4426-85a4-226429c18a72)
2.然后在dependencies中正常配置jar地址即可
