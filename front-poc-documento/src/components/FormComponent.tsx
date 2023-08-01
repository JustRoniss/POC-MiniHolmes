import { Form, Input, Button, Select } from "antd";
import { useState } from "react";

const { Option } = Select;

const FormComponent = ({ dados, identificador }: { dados: any; identificador: string }) => {
  
    const [opcaoSelecionada, setOpcaoSelecionada] = useState<string | null>(null);

  const onFinish = (values: any) => {
    console.log("Form values:", values);


  };

  const renderFormItems = () => {
    return Object.keys(dados).map((dataKey) => {
      const labelValue = dados[dataKey];
      return (
        <Form.Item key={dataKey} label={labelValue} name={dataKey} >
          <Input />
        </Form.Item>
      );
    });
  };

  const renderizarOpcao = () => {
    if (opcaoSelecionada === "header") {
      return (
        <>
          <Form.Item label="Teste 1" name="teste1">
            <Input />
          </Form.Item>
          <Form.Item label="Teste 2" name="teste2">
            <Input />
          </Form.Item>
        </>
      );
    } else if (opcaoSelecionada === "autenticacao") {
      return (
        <>
          <Form.Item label="Usuário" name="usuario">
            <Input />
          </Form.Item>
          <Form.Item label="Senha" name="senha">
            <Input.Password />
          </Form.Item>
        </>
      );
    }
    return null;
  };

  const handleOptionChange = (value: string) => {
    setOpcaoSelecionada(value);
  };

  const renderForm = () => {
    return (
      <Form onFinish={onFinish} layout='vertical'>
        {renderFormItems()}
        {identificador === "fornecedor" && (
          <Form.Item label="Opção" name="opcao">
            <Select style={{ width: 190 }} onChange={handleOptionChange}>
              <Option value="header">Header</Option>
              <Option value="autenticacao">Autenticação</Option>
            </Select>
          </Form.Item>
        )}
        {renderizarOpcao()}
        <Form.Item>
          <Button type="primary" htmlType="submit">
            Enviar
          </Button>
        </Form.Item>
      </Form>
    );
  };

  return <>{renderForm()}</>;
};

export default FormComponent;


const familia = {
    mae: 'Lidia',
    pai: 'Ronaldo',
    irma: 'Taluama',
    avo: 'Nympha',
    namorada: 'Luiza'
}

console.log(familia.mae);
