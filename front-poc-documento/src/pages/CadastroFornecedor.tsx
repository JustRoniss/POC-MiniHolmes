import React from 'react'
import NavbarComponent from '../components/NavbarComponent'
import FormComponent from '../components/FormComponent'

type Props = {}

const CadastroFornecedor = (props: Props) => {
  return (
    <>
    <NavbarComponent/>
    <div>
        <FormComponent dados={teste}/>
    </div>
    </>
  )
}

export default CadastroFornecedor



const teste = 
    {
        NomeFornecedor: 'text',
        URLFornecedor: 'number'
    }

