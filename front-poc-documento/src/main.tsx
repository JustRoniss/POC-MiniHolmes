import './index.css'

import React from 'react'
import ReactDOM from 'react-dom/client'
import {BrowserRouter, Routes, Route} from 'react-router-dom'


// import pages
import Home from './pages/Home.tsx'
import CadastroDocumento from './pages/CadastroDocumento.tsx'
import CadastroFornecedor from './pages/CadastroFornecedor.tsx'
import Buscador from './pages/Buscador.tsx'
//end


ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Home/>} />
        <Route path='/cadastro-documento' element={<CadastroDocumento/>} />
        <Route path='/cadastro-fornecedor' element={<CadastroFornecedor/>} />
        <Route path='/buscador' element={<Buscador />} />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>,
)
