import { ApiOutlined, AuditOutlined, HomeOutlined, SearchOutlined } from "@ant-design/icons";
import { Menu } from "antd";
import React from "react";
import { NavLink } from "react-router-dom";

const items = [
  {
    label: "Home",
    key: "home",
    icon: <HomeOutlined />,
    path: "/",
  },
  {
    label: "Cadastro Fornecedor",
    key: "fornecedor",
    icon: <ApiOutlined />,
    path: "/cadastro-fornecedor",
  },
  {
    label: "Cadastro Documento",
    key: "doc",
    icon: <AuditOutlined />,
    path: "/cadastro-documento",
  },
  {
    label: "Buscador",
    key: "buscador",
    icon: <SearchOutlined/>,
    path: "/buscador"
  }
];

const NavbarComponent: React.FC = () => {
  return (
    <Menu mode="horizontal">
      {items.map((item) => {
        if (item) {
          return (
            <Menu.Item key={item.key} icon={item.icon}>
              <NavLink to={item.path}>{item.label}</NavLink>
            </Menu.Item>
          );
        }
      })}
    </Menu>
  );
};

export default NavbarComponent;
