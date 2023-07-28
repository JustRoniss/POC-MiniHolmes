import { Input, Space } from "antd";
import React, { useState } from "react";
import NavbarComponent from "../components/NavbarComponent";

const onSearch = () => {
  console.log("Você realizou a pesquisa");
};

const Buscador = () => {
  const [nomeFornecedor, setNomeFornecedor] = useState("");
  return (
    <div>
      <NavbarComponent />
      <Space.Compact>
        <Input.Search
          style={{ width: "440px" }}
          placeholder="Digite o nome do fornecedor"
          onChange={(e) => setNomeFornecedor(e.target.value)}
          allowClear
          value={nomeFornecedor}
          size="large"
          enterButton
          onSearch={onSearch}
        />
      </Space.Compact>
    </div>
  );
};

export default Buscador;
