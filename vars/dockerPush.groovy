#!/usr/bin/env groovy

def call(String imageName) {
    echo "logging into Docker ..."
    withCredentials([usernamePassword(credentialsId: "docker-hub-repo", usernameVariable: 'USER', passwordVariable: 'PASS')]){
        echo $PASS | docker login -u $USER --password-stdin
        sh "docker push $imageName"
    }
}