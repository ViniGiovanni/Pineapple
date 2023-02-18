import logo from '../../assets/logo.png'
import Button from '../Dropdown'
import ButtonUser from '../DropUser'
import './header.css'

import Context from '../../context'
import React, { useContext, useEffect, useState } from "react";
import {FiUser} from "react-icons/fi";

export default function Header(){
    const [user, setUser] = useContext(Context);
    setUser(localStorage.getItem("user"));

    return(
        <header>
            <div className='header-user'>
            <ButtonUser nome={user}/>
            <FiUser color='#ffc400' size={22}></FiUser>
            </div>
            <img src={logo}/>
            <nav>
                <ul className='header-links-box'> 
                    <li className='header-links'>
                        Início
                    </li>
                    <li className='header-links'>
                        Fale Conosco
                    </li>
                    <li>
                        <Button/>
                    </li>
                </ul>
            </nav>
        </header>
    )
}