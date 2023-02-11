import logo from '../../assets/logo.png';
import {Link} from 'react-router-dom';
import { useEffect, useState } from 'react';

import {FiLock, FiMail } from "react-icons/fi";
import api from "../../services/api";


export default function Cadastro(){
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [usuario, setUsuario] = useState('');

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
                }
               else alert("Invalid User and Password!")
            })
            .catch((err) => {
              console.error("ops! ocorreu um erro" + err);
            });
        
        }
        else{
            console.log('email erro:');
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
                            
                        <div className='input-login'>
                    <span><FiLock size={18} color='rgb(194, 194, 194)'/></span>
                    <input type="password" placeholder='Senha' value={senha} onChange={(e) => setSenha(e.target.value)}/>
                        
                        </div>
                
                    </div>
                    <button type="submit" className='form-btn' >Login</button>
                </form>

                <p className='form-link'>Não possui cadastro? Registre-se 
                <Link to="/cadastro"> aqui</Link> .</p>
            </div>
        </div>
    )
}