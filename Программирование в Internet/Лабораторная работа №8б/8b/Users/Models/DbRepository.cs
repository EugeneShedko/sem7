using Models.Interface;
using Models.Utils.Database;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models
{
    public class DbRepository : IUserRepository
    {
        /// <summary>Database context</summary>
        private UserContext _context;

        public DbRepository(UserContext context)
        {
            _context = context;
        }

        public void AddElement(User user)
        {
            _context.Add(user);
        }

        public void DeleteElement(int idDeleted)
        {
            _context.Users.Remove(_context.Users.FirstOrDefault(i => i.Id == idDeleted));
        }

        public List<User> GetCollection()
        {
            return new List<User>(_context.Users);
        }

        public User GetElement(int id)
        {
            return _context.Users.FirstOrDefault(i => i.Id == id);
        }

        public void SaveCollection()
        {
            _context.SaveChanges();
        }

        public void UpdateElement(User user)
        {
            User updatedUser = _context.Users.FirstOrDefault(i => i.Id == user.Id);
            updatedUser.FirstName = user.FirstName;
            updatedUser.LastName = user.LastName;
            updatedUser.Email = user.Email;
            updatedUser.Password = user.Password;
            updatedUser.Status = user.Status;
            updatedUser.Role = user.Role;
        }
    }
}
