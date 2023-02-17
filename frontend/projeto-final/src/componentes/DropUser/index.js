import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';
import { Link } from 'react-router-dom';
import {FiLogOut} from "react-icons/fi";

import '../Dropdown/button.css'
import { useContext } from 'react';
import Context from '../../context';
import { useHistory} from 'react-router-dom'
import { setAuthToken } from '../../setAuthToken';

function ButtonUser(prop) {
  const [user,setUser] = useContext(Context)
  const history = useHistory();
  
  const logout = () =>{
    localStorage.removeItem("token");             
    setAuthToken();
    setUser('');
    history.push("/")
     
  } 

  return (
    <Dropdown>
      <Dropdown.Toggle id="dropdown-basic-button" title="Dropdown button" className='dropdown-btn'>
        {user}
      </Dropdown.Toggle>

      <Dropdown.Menu className='dropdown-menu'>
        <Dropdown.Item href="#/action-1"><li> <Link to="/">Editar Perfil</Link></li></Dropdown.Item>
        <Dropdown.Item href="#/action-1"><li> <Link to="/">Meus Pedidos</Link></li></Dropdown.Item>
        <Dropdown.Item href="#/action-1"><li onClick={logout}> <FiLogOut color='color: #ffc400;'></FiLogOut></li></Dropdown.Item>
      </Dropdown.Menu>
    </Dropdown>
  );
}

export default ButtonUser;