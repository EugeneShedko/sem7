using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    [Table("PhoneRecords")]
    public class PhoneRecord
    {
        [Key]
        public int Id { get; set; }
        public string LastName { get; set; }
        public string PhoneNumber { get; set; }
    }
}
