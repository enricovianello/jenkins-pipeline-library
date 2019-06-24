#!/usr/bin/env groovy

def call(String jobName, String jobBaseName, String jobBuildNumber) {
  def clearedJobName = jobName.split('/')[0]
  def clearedJobBaseName = jobBaseName.replaceAll('%2F','-')
  if (jobName != jobBaseName) {
      // multi branch pipeline
      return clearedJobName + '-' + clearedJobBaseName + '-' + jobBuildNumber
  }
  return clearedJobName + '-' + jobBuildNumber
}
