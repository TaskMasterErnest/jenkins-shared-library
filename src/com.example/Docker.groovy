#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def dockerBuildImage(String imageName) {
        script.echo "Building this Docker ..."
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.echo "Logging into Docker ..."
        script.withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }

    def dockerPush(String imageName) {
        script.echo "Pushing into DockerHub ..."
        script.sh "docker push $imageName"
    }
}