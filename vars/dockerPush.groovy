#!/usr/bin/env groovy

def call(String imageName) {
    echo "logging into Docker ..."
    withCredentials([usernamePassword(credentialsId: "docker-hub-repo", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
        echo $PASSWORD | docker login -u $USERNAME --password-stdin
        sh "docker push $imageName"
    }
}