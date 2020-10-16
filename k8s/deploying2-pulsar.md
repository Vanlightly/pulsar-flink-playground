# Deploying Pulsar

Use the guide at [Pulsar-helm-chart](https://github.com/apache/pulsar-helm-chart) but use the values file in this repo `pulsar/helm/values-small-local-storage.yaml`

From the pulsar-helm-chart repo.

```bash
./scripts/pulsar/prepare_helm_release.sh -n pulsar -k pulsar -c

helm install --set initialize=true pulsar apache/pulsar \
--values path/to/the/values-small-local-storage.yaml
```