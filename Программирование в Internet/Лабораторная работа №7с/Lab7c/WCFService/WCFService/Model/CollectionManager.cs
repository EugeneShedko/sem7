using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WCFService.Model.Utils;

namespace WCFService.Model
{
    public class CollectionManager
    {
        private List<PhoneRecord> phoneRecords;
        public CollectionManager()
        {
            phoneRecords = FileManager.ReadFromFile();
        }

        public void AddElement(PhoneRecord phoneRecord)
        {
            if (phoneRecords.Count == 0)
                phoneRecord.Id = 1;
            else
                phoneRecord.Id = phoneRecords[phoneRecords.Count - 1].Id + 1;

            phoneRecords.Add(phoneRecord);
        }

        public void DeleteElement(int idDeleted)
        {
            phoneRecords.Remove(phoneRecords.FirstOrDefault(i => i.Id == idDeleted));
        }

        public List<PhoneRecord> GetCollection()
        {
            return phoneRecords;
        }

        public PhoneRecord GetElement(int id)
        {
            return phoneRecords.FirstOrDefault(i => i.Id == id);
        }

        public void SaveCollection()
        {
            FileManager.WriteInFile(phoneRecords);
        }

        public void UpdateElement(PhoneRecord phoneRecord)
        {
            PhoneRecord updatedPhoneRecord = phoneRecords.FirstOrDefault(i => i.Id == phoneRecord.Id);
            updatedPhoneRecord.LastName = phoneRecord.LastName;
            updatedPhoneRecord.PhoneNumber = phoneRecord.PhoneNumber;
        }
    }
}
