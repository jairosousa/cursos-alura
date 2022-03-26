terraform {
  required_version = ">= 1.1.6"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.27"
    }
  }
}

provider "aws" {
  region  = "us-east-1"
  profile = "aprendizado"
}

resource "aws_instance" "app_server" {
  ami           = "ami-04505e74c0741db8d"
  instance_type = "t2.micro"
  key_name      = "aws-jairo"
  security_groups = ["sgr-access-tf", "sgr-access-web-tf"]

  tags = {
    Name = "aws Ansible Python Terraform"
  }
}