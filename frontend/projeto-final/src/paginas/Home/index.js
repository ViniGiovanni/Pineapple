import React, { useContext, useEffect, useState } from "react";
//import api from "../../services/api";
import Context from "../../context";

export default function Home() {
  const [user, setUser] = useContext(Context);

  useEffect(() => {


    /*api
      .get("/users/Yann99999")
      .then((response) => setUser(response.data))
      .catch((err) => {
        console.error("ops! ocorreu um erro" + err);
      });*/
  }
  , []);

  return (
    <div className="App">
      <p>Usuário: {user}</p>
      <p>Biografia: </p>
    </div>  
  );
}