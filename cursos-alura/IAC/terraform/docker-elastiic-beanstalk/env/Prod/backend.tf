terraform {
  backend "s3" {
    bucket = "terraform-state-jnsdev"
    key    = "Prod/terraform.tfstate"
    region = "us-east-1"
  }
}
