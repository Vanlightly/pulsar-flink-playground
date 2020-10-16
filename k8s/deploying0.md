# Deploying notes

Running this from VMware workstation so remember to set an upstream DNS by:

``` bash
kubectl apply -f kube-dns-configmap.yaml
```

Currently assumes 7 VMs kubew1 to kubew7 with 4 vCPUs and 16GB RAM per VM and only 20GB usable drive.

Pulsar and Flink will use local persistent volumes, so remember to setup the local storage provisioner first.

```bash
kubectl apply -f local-storage-class.yaml
```