# Deploying flink

Assumes:

- the k8s cluster has been created
- monitoring is deployed
- pulsar is deployed

Uses a namespace `flink`.

## Deploying flink

Create the flink namespace

```bash
kubectl create -f flink/flink-ns.yaml
```

Create the persistent volumes and their claims

```bash
kubectl create -f flink/local-storage.yaml
kubectl create -f flink/jobmanager-pvc.yaml
```

Create the flink job manager and task managers

```bash
kubectl create -f flink/flink-configuration-configmap.yaml
kubectl create -f flink/jobmanager-service.yaml
kubectl create -f flink/jobmanager-session-deployment.yaml
kubectl create -f flink/taskmanager-session-deployment.yaml

```

## Delete

```bash
kubectl delete namespace flink
```