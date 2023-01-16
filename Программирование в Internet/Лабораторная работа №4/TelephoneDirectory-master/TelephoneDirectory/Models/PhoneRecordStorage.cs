using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TelephoneDirectory.Models
{
    public class PhoneRecordStorage
    {
        private static PhoneRecordContext context = new PhoneRecordContext();
        public static void SaveCollection()
        {
            context.SaveChanges();
        }

        public static List<PhoneRecord> GetCollection()
        {
            return new List<PhoneRecord>(context.Records);
        }

        public static void AddElement(PhoneRecord phoneRecord)
        {
            if (context.Records.Count() == 0)
                phoneRecord.Id = 1;
            else
                phoneRecord.Id = context.Records.ToList()[context.Records.Count() - 1].Id + 1;

            context.Records.Add(phoneRecord);
        }

        public static void DeleteElement(int idDeleted)
        {
            context.Records.Remove(context.Records.FirstOrDefault(i => i.Id == idDeleted));
        }

        public static void UpdateElement(PhoneRecord phoneRecord)
        {
            PhoneRecord updatedPhoneRecord = context.Records.FirstOrDefault(i => i.Id == phoneRecord.Id);
            updatedPhoneRecord.LastName = phoneRecord.LastName;
            updatedPhoneRecord.PhoneNumber = phoneRecord.PhoneNumber;
        }

        public static PhoneRecord GetElement(int id)
        {
            return context.Records.FirstOrDefault(i => i.Id == id);
        }
    }
}