import React from 'react'
import logoHolmes from "/home/ronis/Projects/POC-Buscador/src/assets/logoHolmesConvertida.svg";
import NavbarComponent from '../components/NavbarComponent'

type Props = {}

const Home = (props: Props) => {
  return (
    <>
      <NavbarComponent/>
      <img className="logo" src={logoHolmes} alt="Logo da decolar" />
      <h1>Mini-Holmes</h1>
    
    
    </>
  )
}

export default Home