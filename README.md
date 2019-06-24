# sd-jenkins-pipeline-library

## Usage

Follow [Extending with Shared Libraries](https://jenkins.io/doc/book/pipeline/shared-libraries/) guide to install the library into Jenkins.
Named it as `sd`.

## Pipeline example

```
@Library('sd')_

def kubeLabel = getKubeLabel()

pipeline {

    agent {
        kubernetes {
            label "${kubeLabel}"
            cloud 'Kube mwdevel'
            defaultContainer 'jnlp'
            ...

```