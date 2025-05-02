# Initialize Kubernetes | Creating a Control Plane Node
Back on <span style="color: orange; font-size: 1.3em">Master</span>

vagrant ssh k8s-master


\# specific version run 
<span style="color: green">sudo kubeadm init --kubernetes-version v1.29.1</span> 

sudo kubeadm init --apiserver-advertise-address=192.168.56.10 --pod-network-cidr=10.244.0.0/16



mkdir -p $HOME/.kube

sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config

sudo chown \$(id -u):$(id -g) $HOME/.kube/config



## Install a CNI Plugin Like Flannel (From Master)
wget https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml 

kubectl apply -f kube-flannel.yml

kubectl get nodes





kubeadm join 192.168.56.10:6443 --token lgrns3.tn8y1r6kb817jln4 \
        --discovery-token-ca-cert-hash sha256:909ca1be561e7d9bbac44ee1c895899f1523a603297116462c1ddfd950aa3d2a