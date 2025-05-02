#!/bin/bash
# Basic provisioning for each node


K8S_VERSION="1.31"
# Disable swap (required for kubeadm)
echo "[TASK 1] disable and turn off swap"
sudo swapoff -a
sudo sed -i '/ swap / s/^/#/' /etc/fstab

#containerd pre-requisites, and load two modules and configure them to load on boot
#0 - Install Packages 
#containerd prerequisites, and load two modules and configure them to load on boot
#https://kubernetes.io/docs/setup/production-environment/container-runtimes/
echo "[TASK 2] Enable and Load Kernel modules"
cat <<EOF | sudo tee /etc/modules-load.d/k8s.conf
overlay
br_netfilter
EOF

sudo modprobe overlay
sudo modprobe br_netfilter

# Set sysctl params, these persist across reboots
echo "[TASK 3] Set sysctl params"
cat <<EOF | sudo tee /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-iptables = 1
net.bridge.bridge-nf-call-ip6tables = 1
net.ipv4.ip_forward = 1
EOF

# Apply sysctl params without reboot
sudo sysctl --system >/dev/null 2>&1

# Install containerd
echo "[TASK 4] Install containerd"
sudo apt-get update -qq
sudo  apt-get install -qq -y containerd


# Configure containerd
echo "[TASK 5] Configure containerd"
sudo mkdir -p /etc/containerd
sudo containerd config default | sudo tee /etc/containerd/config.toml
sudo sed -i 's/            SystemdCgroup = false/            SystemdCgroup = true/' /etc/containerd/config.toml

#verify the change
#sudo cat /etc/containerd/config.toml | grep SystemdCgroup

sudo systemctl restart containerd

echo "[TASK 6] Install Kubernetes components (kubelet, kubeadm, kubectl)" 
sudo apt-get update
# apt-transport-https may be a dummy package; if so, you can skip that package
sudo apt-get install -y apt-transport-https ca-certificates curl gpg

sudo mkdir -p -m 755 /etc/apt/keyrings

curl -fsSL "https://pkgs.k8s.io/core:/stable:/v${K8S_VERSION}/deb/Release.key" | sudo gpg --dearmor -o /etc/apt/keyrings/kubernetes-apt-keyring.gpg
echo "deb [signed-by=/etc/apt/keyrings/kubernetes-apt-keyring.gpg] https://pkgs.k8s.io/core:/stable:/v${K8S_VERSION}/deb/ /" > /etc/apt/sources.list.d/kubernetes.list


# If the directory `/etc/apt/keyrings` does not exist, it should be created before the curl command, read the note below.
# sudo mkdir -p -m 755 /etc/apt/keyrings
# curl -fsSL https://pkgs.k8s.io/core:/stable:/v1.29/deb/Release.key | sudo gpg --dearmor -o /etc/apt/keyrings/kubernetes-apt-keyring.gpg


#This overwrites any existing configuration in /etc/apt/sources.list.d/kubernetes.list
#Remove or select specific version i.e. 1.29
# echo 'deb [signed-by=/etc/apt/keyrings/kubernetes-apt-keyring.gpg] https://pkgs.k8s.io/core:/stable:/v1.29/deb/ /' | sudo tee /etc/apt/sources.list.d/kubernetes.list


sudo apt-get update -qq


#multiline comment with the : null command
: <<COMMENT
##list available versions when running manually
#apt-cache policy kubelet | head -n 20
##test specific version run as bellow, starting with creating VERSION variable
#VERSION=1.29.1-1.1
#sudo apt-get install -y kubelet=$K8S_VERSION kubeadm=$K8S_VERSION kubectl=$K8S_VERSION
#sudo apt-mark hold kubelet kubeadm kubectl containerd
##or run as bellow

##Check the status of kubelet and containerd
#sudo systemctl status kubelet.service
#sudo systemctl status containerd.service

COMMENT

# VERSION=1.29.1-1.1
sudo apt-get install -y kubelet=$K8S_VERSION kubeadm=$K8S_VERSION kubectl=$K8S_VERSION
sudo apt-mark hold kubelet kubeadm kubectl containerd



# Install the latest version of kubelet, kubeadm and kubectl
#sudo apt-get install -y kubelet kubeadm kubectl
#sudo apt-mark hold kubelet kubeadm kubectl

#See CreateCluster for more next steps


# kubectl completion bash | sudo tee /etc/bash_completion.d/kubectl > /dev/null
# kubectl completion bash | sudo tee /etc/bash_completion.d/kubectl > /dev/null