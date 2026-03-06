import { NavLink, useNavigate } from "react-router-dom";

export default function CustomSidebar({setSession}){

    const navigate = useNavigate();
    const closeSession = () => {
        sessionStorage.removeItem("token");
        navigate("/");
        setSession(false);
    }

    //Una sola vista para cargar un componente
    //Cargar json y consumo de json
    //Reglas de navegación
    
    return(
        <div className="p-4 col-2 bg-body-tertiary shadow">
            
        <div className="d-flex flex-column" style={{height: '100%'}}>
            <h5 className="mb-4"><i className="fs-3 bi bi-cart"></i>&nbsp;Tiendita</h5>
        
                <NavLink to = "auth/home" className={(isActive) => `text-start btn btn${isActive ? '' : '-outline'}-primary mb-3`}>
                    <i className="bi bi-house">&nbsp;Inicio</i>
                </NavLink>

                <NavLink to = "auth/products" className={(isActive) => `text-start btn btn${isActive ? '' : '-outline'}-primary mb-3`}>
                    <i className="bi bi-basket-fill"></i>&nbsp; Productos
                </NavLink>

                <NavLink to = "auth/brands" className={(isActive) => `text-start btn btn${isActive ? '' : '-outline'}-primary mb-3`}>
                    <i className="bi bi-tag"></i>&nbsp; Marcas
                </NavLink>
                <button onClick = {() => closeSession()} className = "text-start btn btn-outline-danger mt-auto">
                    <i className="bi bi-box-arrow-left"></i>&nbsp;Cerrar sesion
                </button>
                
            </div>
        </div>
    )
}