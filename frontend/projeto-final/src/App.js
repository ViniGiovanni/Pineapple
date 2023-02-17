import React,{useState} from "react";
import Rotas from "./rotas";
import Context from "./context";
import './App.css'

function App() {
  const [user, setUser] = useState('');
  return (
    <Context.Provider value={[user,setUser]}>
      <Rotas/>
      </Context.Provider>
  );
}

export default App;
