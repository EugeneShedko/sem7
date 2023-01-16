using Model.Interface;
using Model.Utils.Database;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class DbRepository : IPhoneDictionary
    {
        private PhoneRecordContext context;

        public DbRepository(PhoneRecordContext context)
        {
            this.context = context;
        }

        public void AddElement(PhoneRecord phoneRecord)
        {
            context.Records.Add(phoneRecord);
        }

        public void DeleteElement(int idDeleted)
        {
            context.Records.Remove(context.Records.FirstOrDefault(i => i.Id == idDeleted));
        }

        public List<PhoneRecord> GetCollection()
        {
            return new List<PhoneRecord>(context.Records);
        }

        public PhoneRecord GetElement(int id)
        {
            return context.Records.FirstOrDefault(i => i.Id == id);
        }

        public void SaveCollection()
        {
            context.SaveChanges();
        }

        public void UpdateElement(PhoneRecord phoneRecord)
        {
            PhoneRecord updatedPhoneRecord = context.Records.FirstOrDefault(i => i.Id == phoneRecord.Id);
            updatedPhoneRecord.LastName = phoneRecord.LastName;
            updatedPhoneRecord.PhoneNumber = phoneRecord.PhoneNumber;
        }
    }
}
