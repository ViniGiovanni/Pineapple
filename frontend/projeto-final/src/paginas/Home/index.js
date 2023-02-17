import React, { useContext, useEffect, useState } from "react";
import Context from "../../context";

import Header from "../../componentes/Header";

export default function Home() {
  const [user, setUser] = useContext(Context);

  
  return (
    <main>
      <Header/>
      <h1>{user}</h1>
    </main>
  );
}