# 1-VagrantでUbuntu環境を構築

## VirtualBoxとVagrantをいれる

* VirtualBox
    * https://www.virtualbox.org/wiki/Downloads

* Vagrant
    * https://www.vagrantup.com/downloads.html

Vagrantをいれると再起動を要求されるので再起動する。その後下記コマンドを実行しVagrantのバージョンが表示されることを確認する。

```
$vagrant -v
Vagrant 2.2.2
```

## Power Shellのバージョンをあげる

今回はBoxファイル使ってUbuntuをインストールするが、内部ではWindowsのPower Shellが実行されている。

ただ、Vagrantのバージョンが1.9.7以降である場合はPower Shellのバージョンが3以降でないと下記エラーが発生する。

```
$vagrant up
The version of powershell currently installed on this host is less than
the required minimum version. Please upgrade the installed version of
powershell to the minimum required version and run the command again.
```

もしPower Shellのバージョンが満たしていない場合は下記手順でアップグレードする。

### Power Shellのバージョン確認

「ファイル名を指定して実行」で「powershell」を指定しPower Shellを起動した後、`Get-Host`コマンドを実行する。

```
$ Get-Host
Name             : ConsoleHost
Version          : 2.0 ・・・インストールされているPower Shellのバージョン
InstanceId       : eec453f6-b4da-44cc-8b0f-10eaf3612aef
UI               : System.Management.Automation.Internal.Host.InternalHostUserInterface
CurrentCulture   : ja-JP
CurrentUICulture : ja-JP
PrivateData      : Microsoft.PowerShell.ConsoleHost+ConsoleColorProxy
IsRunspacePushed : False
Runspace         : System.Management.Automation.Runspaces.LocalRunspace
```

### Power Shellのアップグレード

下記サイトのDownloadボタンを押下しPower Shell5のインストーラをダウンロードする。

https://www.microsoft.com/en-us/download/details.aspx?id=54616

ただPower Shell5のインストール条件が下記であるためインストールするPCが満たしているか確認しておく。
もし満たしていない場合は満たすようにするか、バージョン3または4をいれる。

* インストール条件

```
■Supported Operating System
Windows 7 Service Pack 1, Windows 8.1, Windows Server 2008 R2, Windows Server 2012, Windows Server 2012 R2

Windows Server 2012 R2
Windows Server 2012
Windows Server 2008 R2 SP1
Windows 8.1
Windows 7 SP1

■IMPORTANT
Please see release notes for the list of products that are compatible and incompatible with Windows Management Framework 5.1.
WMF 5.1 requires Microsoft .NET Framework 4.5 or above. You can install Microsoft .NET Framework 4.5 or above by following the instructions at Installing the .NET Framework.
```

* Power Shell 3のインストーラ
    * https://www.microsoft.com/en-us/download/details.aspx?id=34595
* Power Shell 4のインストーラ
    * https://qiita.com/busonx/items/969d6656be0086e9242b

あとはダウンロードしたインストーラを実行し完了したら、Power Shellのバージョンがアップされていることを確認する。

```
$ Get-Host
Name             : ConsoleHost
Version          : 5.1.14409.1005
InstanceId       : 1ce1b1a0-fb7f-4539-8293-5b0be6455d48
UI               : System.Management.Automation.Internal.Host.InternalHostUserInterface
CurrentCulture   : ja-JP
CurrentUICulture : ja-JP
PrivateData      : Microsoft.PowerShell.ConsoleHost+ConsoleColorProxy
DebuggerEnabled  : True
IsRunspacePushed : False
Runspace         : System.Management.Automation.Runspaces.LocalRunspace
```

## Ubuntuをいれる

1. 下記サイトよりBoxファイルのインストールコマンドを取得する。
 * https://app.vagrantup.com/boxes/search

Boxファイルとは仮想マシンのテンプレートの事で今回はubuntu/trusty64を選択した。

 * 例

```
$ vagrant init ubuntu/trusty64
```

2. 適当なディレクトリを作成しコマンドプロンプトでそこに移動する。
 * 例
```
$ cd C:\Users\kcc-hsl\asakura\vagrant\ubuntu
```

3. 1で取得した取得したインストールコマンドを実行する。
下記コマンドを実行しフォルダ内にVagrantfileが作成されることを確認する。
```
$  vagrant init ubuntu/trusty64
```
 Vagrantfileとは仮想マシンの構成を記述するファイルの事で下記などが設定されている。
   * 起動する仮想マシン指定
   * ネットワーク設定
   * 共有フォルダ設定
   * マシンスペック設定(CPUやメモリの割り当てなど)
   * プロビジョニング(シェルスクリプトや構成管理ツールの実行指定)

4. インストールするUbuntuにSwap領域を割り当てるincrease_swap.shを作成する。
```
#!/bin/sh

# size of swapfile
swapsize=1G

# does the swap file already exist?
grep -q "swapfile" /etc/fstab

# if not then create it
if [ $? -ne 0 ]; then
  echo 'swapfile not found. Adding swapfile.'
  fallocate -l ${swapsize} /swapfile
  chmod 600 /swapfile
  mkswap /swapfile
  swapon /swapfile
  echo '/swapfile none swap defaults 0 0' >> /etc/fstab
else
  echo 'swapfile found. No changes made.'
fi

# output results to terminal
df -h
cat /proc/swaps
cat /proc/meminfo | grep Swap
```

5. タイムゾーンを変更するスクリプトを作成する。
```
#!/bin/sh

timedatectl set-timezone Asia/Tokyo
```

6. Vagrantfileを編集する。
ubuntuディレクトリ内に作成されたVagrantfileに設定されている下記をコメントアウトする。
```
  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
   config.vm.network "private_network", ip: "192.168.33.10" ・・・これをコメントアウト
```

Ubuntuに構築したMySQLサーバにアクセスできるよう3306ポートの転送設定を追加する。

```

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine. In the example below,
  # accessing "localhost:8080" will access port 80 on the guest machine.
  # NOTE: This will enable public access to the opened port
  config.vm.network "forwarded_port", guest: 3306, host: 3306　・・・これを追加
```

最後の行に作成したスクリプトを実行するよう追記する。
```
  ・
  ・
  ・
  # Enable provisioning with a shell script. Additional provisioners such as
  # Puppet, Chef, Ansible, Salt, and Docker are also available. Please see the
  # documentation for more information about their specific syntax and use.
  # config.vm.provision "shell", inline: <<-SHELL
  #   apt-get update
  #   apt-get install -y apache2
  # SHELL
  config.vm.provision "shell", path: "increase_swap.sh"
  config.vm.provision "shell", path: "timezone.sh"
end
```

5. 仮想マシンを起動する。
下記コマンドを実行し仮想マシンを起動する。
```
$vagrant up
Bringing machine 'default' up with 'virtualbox' provider...
==> default: Box 'ubuntu/trusty64' could not be found. Attempting to find and install...
    default: Box Provider: virtualbox
    default: Box Version: >= 0
==> default: Loading metadata for box 'ubuntu/trusty64'
    default: URL: https://vagrantcloud.com/ubuntu/trusty64
==> default: Adding box 'ubuntu/trusty64' (v20181207.0.2) for provider: virtualbox
    default: Downloading: https://vagrantcloud.com/ubuntu/boxes/trusty64/versions/20181207.0.2/providers/virtualbox.box
    default: Download redirected to host: cloud-images.ubuntu.com
    default: Progress: 100% (Rate: 7791k/s, Estimated time remaining: --:--:--)
==> default: Successfully added box 'ubuntu/trusty64' (v20181207.0.2) for 'virtualbox'!
==> default: Importing base box 'ubuntu/trusty64'...
==> default: Matching MAC address for NAT networking...
==> default: Checking if box 'ubuntu/trusty64' is up to date...
==> default: Setting the name of the VM: ubuntu_default_1545371231465_80500
==> default: Clearing any previously set forwarded ports...
Vagrant is currently configured to create VirtualBox synced folders with
the `SharedFoldersEnableSymlinksCreate` option enabled. If the Vagrant
guest is not trusted, you may want to disable this option. For more
information on this option, please refer to the VirtualBox manual:

  https://www.virtualbox.org/manual/ch04.html#sharedfolders

This option can be disabled globally with an environment variable:

  VAGRANT_DISABLE_VBOXSYMLINKCREATE=1

or on a per folder basis within the Vagrantfile:

  config.vm.synced_folder '/host/path', '/guest/path', SharedFoldersEnableSymlinksCreate: false
==> default: Clearing any previously set network interfaces...
==> default: Preparing network interfaces based on configuration...
    default: Adapter 1: nat
==> default: Forwarding ports...
    default: 22 (guest) => 2222 (host) (adapter 1)
==> default: Booting VM...
==> default: Waiting for machine to boot. This may take a few minutes...
    default: SSH address: 127.0.0.1:2222
    default: SSH username: vagrant
    default: SSH auth method: private key
    default: Warning: Connection reset. Retrying...
    default: Warning: Connection aborted. Retrying...
    default: Warning: Remote connection disconnect. Retrying...
    default:
    default: Vagrant insecure key detected. Vagrant will automatically replace
    default: this with a newly generated keypair for better security.
    default:
    default: Inserting generated public key within guest...
    default: Removing insecure key from the guest if it's present...
    default: Key inserted! Disconnecting and reconnecting using new SSH key...
==> default: Machine booted and ready!
==> default: Checking for guest additions in VM...
    default: The guest additions on this VM do not match the installed version of
    default: VirtualBox! In most cases this is fine, but in rare cases it can
    default: prevent things such as shared folders from working properly. If you see
    default: shared folder errors, please make sure the guest additions within the
    default: virtual machine match the version of VirtualBox you have installed on
    default: your host and reload your VM.
    default:
    default: Guest Additions Version: 4.3.36
    default: VirtualBox Version: 6.0
==> default: Mounting shared folders...
    default: /vagrant => C:/Users/kcc-hsl/asakura/vagrant/ubuntu
```

6. 起動確認をする。
```
$vagrant status
Current machine states:

default                   running (virtualbox)
```

## Teratermで起動したUbuntuに接続

1. 下記よりTeratermのインストーラをダウンロードする。
https://forest.watch.impress.co.jp/library/software/utf8teraterm/
2. インストーラを実行する。
3. 下記を設定しUbuntuにSSH接続する。
 * IPアドレス：127.0.0.1
 * ポート：2222
 * アカウント：vagrant/vagrant
接続先は`vagrant up`で出力された下記を参照する。
```
    default: SSH address: 127.0.0.1:2222
    default: SSH username: vagrant
```
4. インストールしたUbuntuのバージョンを確認する。
```
vagrant@vagrant-ubuntu-trusty-64:~$ cat /etc/lsb-release
DISTRIB_ID=Ubuntu
DISTRIB_RELEASE=14.04
DISTRIB_CODENAME=trusty
DISTRIB_DESCRIPTION="Ubuntu 14.04.5 LTS
```
