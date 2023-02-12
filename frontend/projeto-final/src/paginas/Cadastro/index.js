import logo from '../../assets/logo.png';
import './cadastro.css';
import { Link, useHistory } from 'react-router-dom';

import { useState } from 'react';
import { FiUser, FiLock, FiUnlock, FiMail } from "react-icons/fi";
import api  from '../../services/api'

export default function Cadastro(){
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [confirmarSenha, setConfirmarSenha] = useState('');
    const history = useHistory();

    function Cadastrar(e){
        e.preventDefault();

        if(senha !== confirmarSenha){
            alert('Digite senhas iguais');   
        }
        else if((username !=='' && email !== '' && senha !=='' && confirmarSenha !== '') && senha === confirmarSenha){
            var usuario={
                nome:username,
                email:email,
                senha:senha
            }

          
            api
            .post("/api/Clientes",usuario)
            .then((response) =>
            {
                if (response.data != null){
                   alert("Usuário cadastrado com sucesso");
                   history.push('/')
                }                
                   else alert("Error on create new user, contact the admin")
            })
            .catch((err) => {
                var erro =err.toString();;
              
                if (erro.includes('400') )
                  alert(`Email ${email} já cadastrado!`)     
               else  alert("ops! ocorreu um erro:\n" + err)
      
              
            });
        
            
        }
    }
    return(
        <div className='fundo-container'>
            <div className='container'>
                <img src={logo} alt='Logo do restaurante'/>

                
                <form onSubmit={Cadastrar}>
                    
                    <div className="input-icons">
                        <span><FiUser size={18} color='rgb(194, 194, 194)'/></span>
                        <input type="text" placeholder='Username' value={username} onChange={(e) => setUsername(e.target.value)}/>
                    </div>
                    
                    <div className="input-icons">
                        <span><FiMail size={18} color='rgb(194, 194, 194)'/></span>
                        <input type="email" placeholder='Email' value={email} onChange={(e) => setEmail(e.target.value)}/>
                    </div>

                    <div className="input-icons">
                        <span><FiLock size={18} color='rgb(194, 194, 194)'/></span>
                        <input type="password" placeholder='Senha' value={senha} onChange={(e) => setSenha(e.target.value)}/>
                    </div>

                    <div className="input-icons">
                    <   span><FiUnlock size={18} color='rgb(194, 194, 194)'/></span>
                        <input type="password" placeholder='Confirmar senha' value={confirmarSenha} onChange={(e) => setConfirmarSenha(e.target.value)}/>
                    </div>
                    
                    
                    <button type="submit" className='form-btn'>Cadastrar</button>
                    
                </form>

                <p className='form-link'>Já possui uma conta? Entre 
                <Link to="/"> aqui</Link> .</p>
            </div>
        </div>
    )
}