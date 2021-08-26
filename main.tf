terraform {
  required_providers {
    helm = {
      source = "hashicorp/helm"
      version = "2.2.0"
    }
    vault = {
      source = "hashicorp/vault"
      version = "2.23.0"
    }
    template = {
      source = "hashicorp/template"
      version = "2.2.0"
    }
  }
}
