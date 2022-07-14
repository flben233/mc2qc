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

首次启动时会在以下路径创建配置文件 qqnumber groupnumber token，你需要依次填写需要用于发消息的QQ号码，需要发的QQ群号，口令（这个口令可以随意填写，但是需要和spigot端插件填写的口令一致，否则无法连接）
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

