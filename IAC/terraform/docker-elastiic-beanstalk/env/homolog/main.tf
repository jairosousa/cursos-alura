module "Homologacao" {
  source = "../../infra"

  nome      = "Homologacao"
  descricao = "aplicacao-de-homologacao"
  max       = 3
  maquina   = "t2.micro"
  ambiente  = "ambiente-de-homologacao"
}