using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.Interface
{
    public interface IPhoneDictionary
    {
        void SaveCollection();
        List<PhoneRecord> GetCollection();
        PhoneRecord GetElement(int id);
        void AddElement(PhoneRecord phoneRecord);
        void DeleteElement(int idDeleted);
        void UpdateElement(PhoneRecord phoneRecord);
    }
}
