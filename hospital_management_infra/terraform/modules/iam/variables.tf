variable "cluster_name" {
  description = "EKS Cluster Name"
  type        = string
}
variable "oidc_provider_arn" {
  description = "EKS OIDC provider ARN"
  type        = string
}

variable "oidc_provider" {
  description = "EKS OIDC provider URL without https://"
  type        = string
}