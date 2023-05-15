﻿namespace ManejoPresupuesto.Models
{
    public class IndiceCuentasViewModel: CuentaCreacionViewModel
    {
        public string TipoCuenta { get; set; }

        public IEnumerable<Cuenta>? Cuentas { get; set; }

        public decimal Balance => Cuentas.Sum(x => x.Balance);
    }
}
