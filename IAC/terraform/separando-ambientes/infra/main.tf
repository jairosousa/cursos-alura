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
  region  = var.regiao_aws
  profile = "aprendizado"
}

resource "aws_instance" "app_server" {
  ami           = "ami-04505e74c0741db8d"
  instance_type = var.instancia
  key_name      = var.chave
  
  tags = {
    Name = "aws Ansible Python Terraform"
  }
}

resource "aws_key_pair" "chaveSSH" {
  key_name = var.chave
  public_key = file("${var.chave}.pub")
  
}

output "IP_publico" {
  value = aws_instance.app_server.public_ip
}