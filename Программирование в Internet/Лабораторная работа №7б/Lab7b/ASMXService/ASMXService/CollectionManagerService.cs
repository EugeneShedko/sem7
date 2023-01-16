using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ASMXService
{
    [WebService(Namespace ="https://ssa.by/")]
    [WebServiceBinding(ConformsTo =WsiProfiles.BasicProfile1_1)]
    public class CollectionManagerService : WebService
    {
        private CollectionManager _collectionManager = new CollectionManager();

        [WebMethod(Description = "получить все элементы")]
        public List<PhoneRecord> GetCollection()
        {
            return _collectionManager.GetCollection();
        }

        [WebMethod(Description = "добавить элемент")]
        public void AddElement(PhoneRecord phoneRecord)
        {
            _collectionManager.AddElement(phoneRecord);
            _collectionManager.SaveCollection();
        }

        [WebMethod(Description = "обновить элемент")]
        public void UpdateElement(PhoneRecord phoneRecord)
        {
            _collectionManager.UpdateElement(phoneRecord);
            _collectionManager.SaveCollection();
        }

        [WebMethod(Description = "удалить элемент")]
        public void DeleteElement(PhoneRecord phoneRecord)
        {
            _collectionManager.DeleteElement(phoneRecord.Id);
            _collectionManager.SaveCollection();
        }
    }
}