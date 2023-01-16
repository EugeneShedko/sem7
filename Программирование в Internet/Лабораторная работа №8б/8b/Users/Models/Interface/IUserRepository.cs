using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models.Interface
{
    public interface IUserRepository
    {
        void SaveCollection();
        List<User> GetCollection();
        User GetElement(int id);
        void AddElement(User user);
        void DeleteElement(int idDeleted);
        void UpdateElement(User phoneRecord);
    }
}
