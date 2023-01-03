module "aws-dev" {
  source = "../../infra"
  instancia = "t2.micro"
  regiao_aws = "us-east-1"
  chave = "IaC-PROD"
  env = "prod"
}

output "IP" {
  value = module.aws-dev.IP_publico
}