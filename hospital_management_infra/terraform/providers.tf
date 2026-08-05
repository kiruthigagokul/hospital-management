provider "aws" {
  region = var.aws_region

  default_tags {
    tags = {
      Project     = "Hospital Management"
      Environment = "Dev"
      ManagedBy   = "Terraform"
    }
  }
}