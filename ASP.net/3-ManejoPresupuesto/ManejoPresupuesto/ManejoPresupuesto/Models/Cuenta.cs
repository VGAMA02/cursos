using ManejoPresupuesto.Validaciones;
using System.ComponentModel.DataAnnotations;
using System.Runtime.CompilerServices;

namespace ManejoPresupuesto.Models
{
    public class Cuenta
    {
        public int Id { get; set; }
        [Required(ErrorMessage ="el campo {0} es necesario")]
        [StringLength(maximumLength: 50)]
        [PrimeraLetraMayuscula]
        public string Nombre { get; set; }
        [Display(Name = "Tipo de cuenta")]

        public int TipoCuentaId { get; set; }

        public decimal Balance { get; set; }
        [StringLength(maximumLength:1000)]
        public string Descripcion { get; set; }

        public String TipoCuenta { get; set; }

    }
}
