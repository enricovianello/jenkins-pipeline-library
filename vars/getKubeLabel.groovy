#!/usr/bin/env groovy

def call(script) {

  def String clearedJobName = JOB_NAME.split('/')[0]
  def String clearedJobBaseName = JOB_BASE_NAME.replaceAll('%2F','-')
  def String jobBuildNumber = BUILD_NUMBER

  if (JOB_NAME != JOB_BASE_NAME) {
      // multi branch pipeline
      return clearedJobName + '-' + clearedJobBaseName + '-' + jobBuildNumber
  } else {
      // simple pipeline
      return clearedJobName + '-' + jobBuildNumber
  }
}
