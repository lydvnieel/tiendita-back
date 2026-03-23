import { Navigate, Route, Routes } from "react-router-dom";
import Home from "../auth/home/Home";
import Error404 from "../error/Error404";
import CustomSidebar from "../auth/components/CustomSiderbar";
import Produts from "../auth/products/Products";

export default function AuthRouter({setSession}){
    return(<main className="row m-0 ">
        <CustomSidebar setSession = {setSession}/>

        <div className="col-10 p-5">
            <Routes>
                <Route path="/" element = {<Navigate to ="/auth/home"/>} />
                <Route path="/auth/home" element = { <Home />}/>
                <Route path="/auth/products" element = { <Produts />}/>
            
                {/* FALLBACKS*/}
                <Route path="*" element = {<Error404 />} /> 
            </Routes>
        </div>
    </main>)
}