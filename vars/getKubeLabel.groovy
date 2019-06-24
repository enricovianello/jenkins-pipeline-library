#!/usr/bin/env groovy

def call() {

  def clearedJobName = env.JOB_NAME.split('/')[0]
  def clearedJobBaseName = env.JOB_BASE_NAME.replaceAll('%2F','-')
  def jobBuildNumber = env.BUILD_NUMBER

  def label = ''

  if (env.JOB_NAME != env.JOB_BASE_NAME) {
      // multi branch pipeline
      label = clearedJobName + '-' + clearedJobBaseName + '-' + jobBuildNumber
  } else {
      // simple pipeline
      label = clearedJobName + '-' + jobBuildNumber
  }

  echo "kubeLabel = ${label}"

  return label
}
