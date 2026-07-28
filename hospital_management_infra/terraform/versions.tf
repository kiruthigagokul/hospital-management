terraform {
  required_version = ">= 1.7.0"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 6.52"
    }
  }

  backend "s3" {
    bucket         = "hospital-management-terraform-state-897355252117"
    key            = "hospital-management/terraform.tfstate"
    region         = "ap-south-1"
    dynamodb_table = "hospital-terraform-lock"
    encrypt        = true
  }
}