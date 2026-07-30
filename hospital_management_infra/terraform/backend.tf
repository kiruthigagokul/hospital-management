terraform {
  backend "s3" {
    bucket         = "hospital-terraform-state-12345678"
    key            = "eks/terraform.tfstate"
    region         = "ap-south-1"
    dynamodb_table = "hospital-management-lock"
    encrypt        = true
  }
}