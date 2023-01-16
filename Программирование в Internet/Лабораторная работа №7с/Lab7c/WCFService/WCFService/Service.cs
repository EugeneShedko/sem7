using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using WCFService.Model;

namespace WCFService
{
    // ПРИМЕЧАНИЕ. Команду "Переименовать" в меню "Рефакторинг" можно использовать для одновременного изменения имени класса "Service1" в коде и файле конфигурации.
    public class Service : IService
    {
        private CollectionManager _collectionManager;

        public Service()
        {
            _collectionManager = new CollectionManager();
        }

        public void Add(PhoneRecord phoneRecord)
        {
            _collectionManager.AddElement(phoneRecord);
            _collectionManager.SaveCollection();
        }

        public void Delete(int id)
        {
            _collectionManager.DeleteElement(id);
            _collectionManager.SaveCollection();
        }

        public List<PhoneRecord> GetCollection()
        {
            return _collectionManager.GetCollection();
        }

        public void Update(PhoneRecord phoneRecord)
        {
            _collectionManager.UpdateElement(phoneRecord);
            _collectionManager.SaveCollection();
        }
    }
}
