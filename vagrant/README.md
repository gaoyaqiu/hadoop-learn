
# 环境准备
## Windows 
vagrant_1.9.7_x86_64.msi
VirtualBox-5.1.24-117012-Win.exe

> 之前用的都是最新版本安装一直卡死。。。

# centos7 box 镜像下载
https://vagrantcloud.com/centos/boxes/7/versions/1905.1/providers/virtualbox.box

# 将 box 添加到本地仓库
```
cd vagrant
vagrant box add centos/7 ./CentOS-7-x86_64.box
```

# 创建并启动虚拟机
```
vagrant up
```
> 首次执行该命令会依次创建master01、node01、node02 三台虚拟机, 如果已经创建好了，会跳转安装步骤，直接启动虚拟机

创建好之后，依次通过`vagrant ssh 虚拟机名称`连接进去，默认ssh进去的用户是vagrant, 然后切到`root`用户（默认密码为 vagrant）, 将宿主机
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