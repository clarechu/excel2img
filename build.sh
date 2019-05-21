#!/usr/bin/env bash

mvn clean install -U

docker build -t clarechu/excel2img .

docker login -u clarechu -p lei13971368720

docker push clarechu/excel2img


