import React,{useState} from "react";
import Rotas from "./rotas";
import Context from "./context";
import './App.css'
import { setAuthToken } from "./setAuthToken";

function App() {
  const [user, setUser] = useState('');
  const token = localStorage.getItem("token");
  if (token) {
     setAuthToken(token);
  }

  return (
    <Context.Provider value={[user,setUser]}>
      <Rotas/>
      </Context.Provider>
  );
}

export default App;
