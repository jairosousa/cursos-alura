terraform {
  backend "s3" {
    bucket = "terraform-state-jnsdev"
    key    = "homolog/terraform.tfstate"
    region = "us-east-1"
  }
}
