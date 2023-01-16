using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TelephoneDirectory.Models
{
    [Serializable]
    public class PhoneRecord
    {
        public int Id { get; set; }
        public string LastName { get; set; }
        public string PhoneNumber { get; set; }
    }
}