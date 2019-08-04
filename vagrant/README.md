
# 环境准备
## Windows 
vagrant_1.9.7_x86_64.msi
VirtualBox-5.1.24-117012-Win.exe

> 在 Windows系统下，vagrant 和 virtualbox 版本最好对应，之前用的都官方最新版本，系统一直安装不上，在Mac下就没问题。。。

# centos7 box 镜像下载
https://vagrantcloud.com/centos/boxes/7/versions/1905.1/providers/virtualbox.box

> box镜像下载好之后，放入 vagrant/ 下
# 将 box 添加到本地仓库
```
cd vagrant
vagrant box add centos/7 ./CentOS-7-x86_64.box
```

# 创建并启动虚拟机
```
vagrant up
```
> 首次执行该命令会依次创建master01、node01、node02（如果对名字不满意，或者需要创建更多的虚拟机，可以在 Vagrantfile 中修改） 三台虚拟机, 如果已经创建好了，会跳转安装步骤，直接启动虚拟机

# ssh 连接虚拟机
```shell
vagrant ssh 虚拟机名称
```
通过`vagrant ssh`方式进入之后，默认用户是vagrant, 然后切到`root`用户（默认密码为 vagrant）, 将宿主机
下的ssh公钥拷贝到三台虚拟机中的`~/.ssh/authorized_keys`文件中， 最后就可以通过`ssh root@172.17.8.101`连接了

# 启动某台虚拟机
```
vagrant up 虚拟机名称
```
# 关闭所有虚拟机
```
vagrant halt
```
# 关闭某台虚拟机
```
vagrant halt 虚拟机名称
```
