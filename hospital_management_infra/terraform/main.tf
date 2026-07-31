module "vpc" {
  source = "./modules/vpc"

  vpc_cidr = var.vpc_cidr
}

module "iam" {
  source = "./modules/iam"
}

# We'll add the EKS module after creating it.
module "eks" {
  source  = "terraform-aws-modules/eks/aws"
  version = "~> 21.0"

  name               = var.cluster_name
  kubernetes_version = "1.33"

  endpoint_public_access = true

  enable_cluster_creator_admin_permissions = true

  vpc_id = module.vpc.vpc_id

  subnet_ids = module.vpc.private_subnet_ids

  eks_managed_node_groups = {
    hospital = {

      instance_types = ["t3.medium"]

      min_size     = 2
      max_size     = 3
      desired_size = 2

      capacity_type = "ON_DEMAND"
    }

  }

  addons = {
    coredns = {}

    kube-proxy = {}

    vpc-cni = {}

    eks-pod-identity-agent = {}

    aws-ebs-csi-driver = {}
  }

  tags = {
    Project = "Hospital"
  }
}