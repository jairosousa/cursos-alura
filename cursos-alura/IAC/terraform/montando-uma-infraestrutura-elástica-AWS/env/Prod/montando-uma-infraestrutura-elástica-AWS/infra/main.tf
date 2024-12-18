terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.27"
    }
  }

  required_version = ">= 0.14.9"
}

provider "aws" {
  profile = "apredizado"
  region  = var.regiao_aws
}

resource "aws_launch_template" "maquina" {
  image_id           = "ami-04505e74c0741db8d"
  instance_type = var.instancia
  key_name = var.chave
  tags = {
    Name = "Terraform Ansible Python"
  }
  security_group_names = [var.grupoDeSeguranca]
}

resource "aws_key_pair" "chaveSSH" {
  key_name = var.chave
  public_key = file("${var.chave}.pub") 
}

output "IP_publico" {
  value = aws_instance.app_server.public_ip
}