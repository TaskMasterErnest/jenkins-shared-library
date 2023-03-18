#!/usr/bin/env groovy

com.example.Docker

def call() {
    return new Docker(this).dockerBuildImage(imageName)
}