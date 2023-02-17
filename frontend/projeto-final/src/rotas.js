import React from "react";
import { BrowserRouter, Route } from "react-router-dom";

import Cadastro from "./paginas/Cadastro";
import Login from "./paginas/Login";
import Home from "./paginas/Home";


export default function Rotas(){
    return(
     
        <BrowserRouter>
            <Route component={Login} path="/" exact/>
            <Route component={Cadastro} path="/cadastro"/>
            <Route component={Home} path="/home"/>
        </BrowserRouter>
       
    )
}