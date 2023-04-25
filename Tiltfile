# Build
custom_build(
   # Name of the container image
   ref = 'kehinde/catalog-service',
   # Command to build the container image
   command = 'cd catalog-service && mvn spring-boot:build-image &&  docker push $EXPECTED_REF',
   disable_push=False,
   # Files to watch that trigger a new build
   skips_local_docker=True,
   tag='latest',
   deps = ['./catalog-service/pom.xml', './catalog-service/src'],
)

# Build
custom_build(
   # Name of the container image
   ref = 'kehinde/order-service',
   # Command to build the container image
   command = 'cd order-service && mvn spring-boot:build-image &&  docker push $EXPECTED_REF',
   disable_push=False,
   skips_local_docker=True,
   tag='latest',
   # Files to watch that trigger a new build
   deps = ['./order-service/pom.xml', './order-service/src'],
)

custom_build(
   # Name of the container image
   ref = 'kehinde/config-server',
   # Command to build the container image
   command = 'cd config-server && mvn spring-boot:build-image &&  docker push $EXPECTED_REF',
   disable_push=False,
   skips_local_docker=True,
   tag='latest',
   # Files to watch that trigger a new build
   deps = ['./config-server/pom.xml', './config-server/src']
)

# Build
custom_build(
   # Name of the container image
   ref = 'kehinde/user-service',
   # Command to build the container image
   command = 'cd user-service && mvn spring-boot:build-image &&  docker push $EXPECTED_REF',
   disable_push=False,
   skips_local_docker=True,
   tag='latest',
   # Files to watch that trigger a new build
   deps = ['./user-service/pom.xml', './user-service/src'],
)

# Build
custom_build(
   # Name of the container image
   ref = 'kehinde/gateway',
   # Command to build the container image
   command = 'cd gateway && mvn spring-boot:build-image &&  docker push $EXPECTED_REF',
   disable_push=False,
   # Files to watch that trigger a new build
   skips_local_docker=True,
   tag='latest',
   deps = ['./gateway/pom.xml', './gateway/src'],
)

k8s_yaml(['k8s/catalog-postgres.yml', 'k8s/order-postgres.yml', 'k8s/user-postgres.yml'])

k8s_yaml(['k8s/config-server.yml',  'k8s/gateway.yml', 'k8s/catalog-service.yml', 'k8s/order-service.yml', 'k8s/user-service.yml'])

# Manage
k8s_resource('config-server', port_forwards=['8888'])
# Manage
k8s_resource('catalog-service',resource_deps=['catalog-postgres', 'config-server'], port_forwards=['9001'])
# Manage
k8s_resource('order-service', resource_deps=['order-postgres', 'config-server'], port_forwards=['9002'])

k8s_resource('user-service', resource_deps=['user-postgres'], port_forwards=['9003'])
# Manage
k8s_resource('gateway', port_forwards=['9000'])