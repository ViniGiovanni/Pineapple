import logo from '../../assets/logo.png';
import './cadastro.css';
import { Link } from 'react-router-dom';

import { useState } from 'react';
import { FiUser, FiLock, FiUnlock, FiMail } from "react-icons/fi";

export default function Cadastro(){
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [confirmarSenha, setConfirmarSenha] = useState('');

    function Cadastrar(){
        if(senha !== confirmarSenha){
            alert('Digite senhas iguais')
        }
        if((username !=='' && email !== '' && senha !=='' && confirmarSenha !== '') && senha === confirmarSenha){
            //função de cadastrar
            alert(senha)
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