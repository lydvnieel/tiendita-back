import CreateProductModal from "./components/CreateProductModal";
import ProductRow from "./components/ProductRow";

export default function Produts(){
    return(<div>
        <h2>Productos</h2>

        <section className="mt-4 d-flex align-items-center">

        
        <div className="input-group me-auto" style ={{width: 500}}>
            <input type="text" className = "form-control" placeholder = "Buscar..." name="" id="" />
            <span className="input-group-text"><i className="bi bi-search"></i></span>

        </div>
        <button className="btn btn-success" data-bs-toggle = "modal" data-bs-target = "#createProductModal">
            <i className=" bi bi-plus-lg">
            &nbsp;Agregar producto
            </i>
        </button>
        </section>

        <section className="mt-4">
            <div className="taable-responsive">
                <table className="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Marca</th>
                            <th scope="col">Costo unitario</th>
                            <th scope="col">¿A la venta?</th>
                            <th scope="col" className="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <ProductRow />
                    </tbody>
                </table>
            </div>
        </section>
        {/*MODALES*/}
        <CreateProductModal />
    </div>
    );
}