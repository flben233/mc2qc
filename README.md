# mc2qc
一个mirai插件，可以将Minecraft服务器的消息转发至指定的QQ群，需要配合Minecraft服务端端插件使用

## 内容列表

- [使用说明](#使用说明)
- [插件下载](#插件下载)
- [相关仓库](#相关仓库)
- [如何贡献](#如何贡献)
- [使用许可](#使用许可)

## 使用说明

*LuckPerms与本插件可能冲突，请自行测试*

本插件属于socket服务端，因此请先启动Mirai再启动Minecraft服务端。

为了适应某些服务器有多个子服务器，设计上这个插件支持同时连接多个服务器，你只需要把服务端插件安装在各个子服务器即可。

首次启动时会在以下路径创建配置文件 qqnumber groupnumber token，你需要依次填写.

qqnumber: 用于发送消息的qq账号

groupnumber: 要发送到的群号码

token: 密码，用于验证连接的可靠性，这个值你可以随意设置，但是 **要与spigot端的这个文件的值保持一致**
```
(Mirai主目录)/config/org.shirakawatyu.mc2qc
```
填写完成以后请重启Mirai

## 插件下载

[服务端插件](https://github.com/flben233/mc2qc_spigot/releases)

[mirai端插件](https://github.com/flben233/mc2qc/releases)

## 相关仓库

- [mc2qc_spigot](https://github.com/flben233/mc2qc_spigot) — 本插件对应的服务端插件。
- [qc2mc](https://github.com/flben233/qc2mc) — 你可以配合这个Mirai插件实现QQ群消息推送至Minecraft服务器。

## 维护者

[@flben233](https://github.com/flben233)。

## 如何贡献

非常欢迎你的加入！[提一个 Issue](https://github.com/flben233/mc2qc/issues/new) 或者提交一个 Pull Request。

## 使用许可

[MIT](LICENSE) © flben233

