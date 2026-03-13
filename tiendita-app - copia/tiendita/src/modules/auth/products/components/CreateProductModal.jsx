export default function CreateProductModal(){
    return(
        <div className="modal fade" data-bs-backdrop="static" data-bs-keyboard="false" id="createProductModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div className="modal-dialog modal-dialog-centered">
                <div className="modal-content border-0 rounded-3">
                    <div className="modal-body">
                        <h4>Registrar producto</h4>
                        <hr />
                        <form action="" className="row">
                            <div className="col-12">
                                <label htmlFor=""><small>Nombre del producto</small></label>
                                <input type="text" className="form-control" />
                            </div>
                            <div className="col-8">
                                <label htmlFor=""><small>Marca</small></label>
                                <input type="text" className="form-control" />
                            </div>
                            <div className="col-4">
                                <label htmlFor=""><small>Costo unitario</small></label>
                                <input type="number" className="form-control" />
                            </div>
                        </form>
                        
                        <div className="text-end mt-3">
                            
                            <button className="btn btn-secondary me-2" data-bs-dismiss = "modal">
                                <i className="bi bi-ban"></i>
                                &nbsp; Cancelar
                                </button>

                                <button className="btn btn-success">
                                <i className="bi bi-save"></i>
                                &nbsp; Guardar
                                </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}