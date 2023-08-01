import React from 'react'
import NavbarComponent from '../components/NavbarComponent'
import FormComponent from '../components/FormComponent'



const CadastroFornecedor = () => {
  return (
    <>
    <NavbarComponent/>
    <div>
        <FormComponent dados={teste} identificador="fornecedor"/>
    </div>
    </>
  )
}

export default CadastroFornecedor



const teste = 
    {
        NomeFornecedor: 'Nome do Fornecedor',
        URLFornecedor: 'URL de conexão',
        Flinston: "Flinston dare dare"
    }

