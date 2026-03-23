import { useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function Login(setSession){
    
    const navigate = useNavigate();
    const changeSession = () => {
        sessionStorage.setItem("token", "test.token.tiendita"); 
        navigate("/")
        setSession(true)
    }

    useEffect(() => {
        if(!!sessionStorage.getItem("token")){
            navigate("/")
        }
    }, [])

    return(<main className="d-flex align-items-center justify-content-center bg-dark">
        <div className="card border-2 rounded-4 shadow" style={{width: 500}}>
            <div className="card-body">
                <p className="fw-bold">Inicio de sesión</p>
                <form action="" className="mt-4 row g-2">
                    <div className="col-12">
                        <label htmlFor="">Usuario o correo electrónico</label>
                        <input type="text" className="form-control" />
                    </div>
                    <div className="col-12">
                        <label htmlFor="">Contraseña</label>
                        <input type="password" className="form-control" />
                    </div>
                    <div className="col-12 text-center">
                        <button onClick={() => changeSession()} className="btn btn-primary col-12">Iniciar sesion</button>
                        <p className="my-3">O</p>
                        <Link className="btn btn-outline-primary col-12" to="/register">Registrarme</Link>
                    </div>
                    <p className="mb-0 mt-3 text-center">
                        <Link to="/recovery">¿Olvidaste tu contraseña?</Link>
                    </p>
                </form>
            </div>    
        </div>        
    </main>)
}