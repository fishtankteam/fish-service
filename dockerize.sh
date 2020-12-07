#! /bin/bash
{ set -eux -o pipefail; } 2>/dev/null

./gradlew clean build

cp build/libs/*.jar docker/app.jar
tag=${1}/${2}:${3}
cd docker
docker build -t "${tag}" .
