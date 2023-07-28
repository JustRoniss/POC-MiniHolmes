import { Form, Input, Button } from "antd";

const FormComponent = ({ dados }) => {
  const onFinish = (values: string) => {
    console.log("Form values:", values);
  };

  const renderFormItems = () => {
    return Object.keys(dados).map((dataKey) => {
      return (
        <Form.Item key={dataKey} label={dataKey} name={dataKey}>
          <Input />
        </Form.Item>
      );
    });
  };

  return (
    <Form onFinish={onFinish} labelCol={{ span: 5 }} wrapperCol={{ span: 14 }} layout='vertical'>
      {renderFormItems()}
      <Form.Item>
        <Button type="primary" htmlType="submit">
          Enviar
        </Button>
      </Form.Item>
    </Form>
  );
};

export default FormComponent;
