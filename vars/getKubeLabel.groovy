#!/usr/bin/env groovy

def call() {

  def String clearedJobName = env.JOB_NAME.split('/')[0]
  def String clearedJobBaseName = env.JOB_BASE_NAME.replaceAll('%2F','-')
  def String jobBuildNumber = env.BUILD_NUMBER

  if (env.JOB_NAME != env.JOB_BASE_NAME) {
      // multi branch pipeline
      return clearedJobName + '-' + clearedJobBaseName + '-' + jobBuildNumber
  } else {
      // simple pipeline
      return clearedJobName + '-' + jobBuildNumber
  }
}
