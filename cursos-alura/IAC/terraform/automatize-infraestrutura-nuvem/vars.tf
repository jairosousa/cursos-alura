variable "amis" {
  type = map(string)

  default = {
    "us-east-1" = "ami-04505e74c0741db8d"
    "us-east-2" = "ami-0fb653ca2d3203ac1"
  }
}

variable "cidrs_acesso_remoto" {
  type    = list(string)
  default = ["191.31.224.148/32", "192.31.224.148/32"]
}

variable "key_name" {
  default = "terraform-aws"
}