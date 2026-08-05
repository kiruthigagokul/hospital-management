module "vpc" {
  source = "./modules/vpc"

  vpc_name = "hospital-vpc"
  vpc_cidr = var.vpc_cidr

  availability_zones = [
    "ap-south-1a",
    "ap-south-1b"
  ]

  public_subnet_cidrs = [
    "10.0.101.0/24",
    "10.0.102.0/24"
  ]

  private_subnet_cidrs = [
    "10.0.1.0/24",
    "10.0.2.0/24"
  ]
}
module "iam" {
  source = "./modules/iam"

  cluster_name = var.cluster_name

  oidc_provider_arn = module.eks.oidc_provider_arn
  oidc_provider     = replace(module.eks.cluster_oidc_issuer_url, "https://", "")
}
module "eks" {
  source = "./modules/eks"

  cluster_name       = var.cluster_name
  kubernetes_version = var.kubernetes_version
  vpc_id             = module.vpc.vpc_id
  private_subnet_ids = module.vpc.private_subnet_ids
}