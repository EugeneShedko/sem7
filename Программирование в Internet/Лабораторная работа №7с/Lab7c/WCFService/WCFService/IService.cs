using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using WCFService.Model;

namespace WCFService
{
    // ПРИМЕЧАНИЕ. Команду "Переименовать" в меню "Рефакторинг" можно использовать для одновременного изменения имени интерфейса "IService1" в коде и файле конфигурации.
    [ServiceContract]
    public interface IService
    {
        [OperationContract]
        List<PhoneRecord> GetCollection();

        [OperationContract]
        void Add(PhoneRecord phoneRecord);

        [OperationContract]
        void Update(PhoneRecord phoneRecord);

        [OperationContract]
        void Delete(int id);
    }
}
