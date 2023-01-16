using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace TelephoneDirectory.Models
{
    public class PhoneRecordContext : DbContext
    {
        public DbSet<PhoneRecord> Records { get; set; }
    }
}