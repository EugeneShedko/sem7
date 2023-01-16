using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.Utils.Database
{
    public class PhoneRecordContext : DbContext
    {
        public PhoneRecordContext(DbContextOptions<PhoneRecordContext> options) : base(options)
        {
            Database.EnsureCreated();
        }

        
        public DbSet<PhoneRecord> Records { get; set; }
    }
}
