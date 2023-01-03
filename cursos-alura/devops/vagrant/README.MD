* VirtualBox, VMware, Hyper-V, entre outros, são Hypervisors

* Um Hypervisor emula o hardware do computador para criar e executar máquinas virtuais


* O Vagrant é uma ferramenta que controla o Hypervisor a partir de um arquivo simples, o Vagranfile

* O Vagrantfile define detalhes da máquina virtual, como o sistema operacional, a rede, software utilizado, etc

* O comando vagrant init <box> cria um Vagrantfile

* A box é baixada da internet e possui a imagem do sistema operacional, entre outras configurações


* Para inicializar e rodar a VM com Vagrant, usa-se o comando: vagrant up

* O comando vagrant status mostra detalhes sobre o status da máquina virtual
Para se conectar com a máquina virtual, usamos a ferramenta SSH

# Serviços no Ubuntu

 * > sudo apt-get update

## NGINX

* > sudo apt-get install -y nginx

## Ver as portas em operação

> netstat -lntp

