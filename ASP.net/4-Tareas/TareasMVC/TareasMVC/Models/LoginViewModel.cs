using System.ComponentModel.DataAnnotations;

namespace TareasMVC.Models
{
    public class LoginViewModel
    {
        [Required(ErrorMessage = "El campoo {0} es requerido")]
        [EmailAddress(ErrorMessage = "El campoo {0} debe ser un correo electronico valido")]
        public string Email { get; set; }
        [Required(ErrorMessage = "El campoo {0} es requerido")]
        public string Password { get; set; }

        public bool Recuerdame { get; set; }
    }
}
