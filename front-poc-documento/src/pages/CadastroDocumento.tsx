import React from 'react'
import NavbarComponent from '../components/NavbarComponent'
import FormComponent from '../components/FormComponent'

type Props = {}

const CadastroDocumento = (props: Props) => {
  return (
    <>
    <NavbarComponent/>
    <div>
        <h1>Amigo estou lá</h1>
        <FormComponent dados={form} identificador="documento" />
    </div>
    </>
    
  )
}

export default CadastroDocumento

const form = {
    nomeDocumento: 'Nome do documento',
    Teste: 'Olá teste',
}

