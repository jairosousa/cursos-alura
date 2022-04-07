module "aws-dev" {
  source = "../../infra"
  instancia = "t2.micro"
  regiao_aws = "us-west-1"
  chave = "IaC-DEV"
  grupoDeSeguranca = "DEV"
}

output "IP" {
  value = module.aws-dev.IP_publico
}