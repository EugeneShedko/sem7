using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models
{
    public class User
    {
        /// <summary>Users Id</summary>
        /// <example>101</example>
        [Required]
        public int Id { get; set; }

        /// <summary>Users Name</summary>
        /// <example>Adam</example>
        public string FirstName { get; set; }

        /// <summary>Users Surname</summary>
        /// <example>Smith</example>
        public string LastName { get; set; }

        /// <summary>Users e-mail</summary>
        /// <example>xxx@yyy.com</example>
        [Required]
        [EmailAddress]
        public string Email { get; set; }

        /// <summary>Password</summary>
        /// <example>pass111</example>
        [Required]
        public string Password { get; set; }

        /// <summary>active/passive</summary>
        /// <example>active</example>
        [Required]
        public string Status { get; set; }

        /// <summary>Admin/Customer/HR</summary>
        /// <example>customer</example>
        [Required]
        public string Role{ get; set; }
    }
}
