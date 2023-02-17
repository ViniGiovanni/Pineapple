import logo from '../../assets/logo.png';
import {Link} from 'react-router-dom';
import {  useContext, useState } from 'react';

import {FiLock, FiMail } from "react-icons/fi";
import api from "../../services/api";
import { useHistory } from 'react-router-dom';
import Context from "../../context";

export default function Cadastro(){
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [usuario, setUsuario] = useState('');
    const history = useHistory();
    const [user, setUser] = useContext(Context);

    function Logar(e){
        e.preventDefault();
       if(email !== '' && senha !==''){
          
            var userLogin={
                email:email,
                senha:senha
            }
            api
            .post("/api/Clientes/autenticar",userLogin)
            .then((response) =>
            {
                if (response.data.token != null){
                   console.log(response.data)
                    setUsuario(response.data.nome)
                    alert(usuario+ ' token:'+ response.data.token);
                    setUser(response.data.nome);
                    history.push('/home'); 
                }
               else alert("Invalid User and Password!")
            })
            .catch((err) => {
   
                var erro =err.toString();;
              
                if (erro.includes('302') ||  erro.includes('404'))
                  alert("Invalid User and Password!" )
      
               else  alert("ops! ocorreu um erro:\n" + err)
      
              
              
            });
        
        }
        else{
           alert('Email ou senha inválido')
        }
    }
    return(
        <div className='fundo-container'>
            <div className='container'>
                <img src={logo} alt='Logo do restaurante'/>

                <form onSubmit={Logar}>
                    <div className="input-icons">
                        <span><FiMail size={18} color='rgb(194, 194, 194)'/></span>
                        <input  type="email" placeholder='Email' value={email} onChange={(e) => setEmail(e.target.value)}/>
                    </div>

                    <div className="input-icons">
                            
                    <span><FiLock size={18} color='rgb(194, 194, 194)'/></span>
                    <input type="password" placeholder='Senha' value={senha} onChange={(e) => setSenha(e.target.value)}/>
                    </div>
                    <button type="submit" className='form-btn' >Login</button>
                </form>

                <p className='form-link'>Não possui cadastro? Registre-se 
                <Link to="/cadastro"> aqui</Link> .</p>
            </div>
        </div>
    )
}