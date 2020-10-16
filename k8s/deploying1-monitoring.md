# Deploying monitoring

## Deploy prometheus with operator

```bash
kubectl create -f monitoring/prometheus-as-operator/setup
sleep 5
kubectl create -f monitoring/prometheus-as-operator/
```

## Port forwarding for monitoring services

```bash
kubectl -n monitoring port-forward svc/grafana 3000
```

```bash
kubectl -n monitoring port-forward svc/prometheus-k8s 9090
```

```bash
kubectl -n monitoring port-forward svc/alertmanager-main 9093
```

## Delete monitoring

kubectl delete --ignore-not-found=true -f monitoring/prometheus-as-operator/ -f monitoring/prometheus-as-operator/setup