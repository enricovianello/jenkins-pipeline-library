#!/usr/bin/env groovy

def call(Closure script) {

  def String clearedJobName = JOB_NAME.split('/')[0]
  def String clearedJobBaseName = JOB_BASE_NAME.replaceAll('%2F','-')
  def String jobBuildNumber = BUILD_NUMBER
  def String labelPrefix = "build-"
  def String label = ""

  if (JOB_NAME != JOB_BASE_NAME) {
      // multi branch pipeline
      label = clearedJobName + '-' + clearedJobBaseName + '-' + jobBuildNumber
  } else {
      // simple pipeline
      label = clearedJobName + '-' + jobBuildNumber
  }

  echo "kubeLabel = ${labelPrefix}${label}"

  return labelPrefix+label
}
