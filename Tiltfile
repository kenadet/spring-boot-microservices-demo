# Build
custom_build(
   # Name of the container image
   ref = 'catalog-service',
   # Command to build the container image
   command = 'mvn spring-boot:build-image',
   # Files to watch that trigger a new build
   deps = ['./catalog-service/pom.xml', './catalog-service/src']
)

custom_build(
   # Name of the container image
   ref = 'config-server',
   # Command to build the container image
   command = 'mvn spring-boot:build-image',
   # Files to watch that trigger a new build
   deps = ['./config-server/pom.xml', './config-server/src']
)
local_resource('postgres', cmd='cd k8s; kubectl apply -f postgres.yml')

# Deploy
k8s_yaml(['k8s/config-server.yml', 'k8s/catalog-service.yml'])

# Manage
k8s_resource('catalog-service', resource_deps=['postgres'], port_forwards=['9001'])