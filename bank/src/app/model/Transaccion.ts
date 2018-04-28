export class Transaccion {
    valor : number;
    cuenta: string;
    tipoTransaccion: number;
    usuario: string;
    cedula: number;
    clave: string;

    constructor() {
        this.valor = 0;
        this.cuenta = "";
        this.tipoTransaccion = 0;
        this.usuario = "";
        this.cedula = 0;
        this.clave = "";
    }
}