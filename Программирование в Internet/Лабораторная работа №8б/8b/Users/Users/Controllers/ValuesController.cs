using Microsoft.AspNetCore.Mvc;
using Models;
using Models.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Users.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValuesController : ControllerBase
    {
        private IUserRepository _repository;

        public ValuesController(IUserRepository repository)
        {
            _repository = repository;
        }

        /// <summary>Get all Users</summary>
        // GET: api/<ValuesController>
        [HttpGet]
        public IEnumerable<User> Get()
        {
            return _repository.GetCollection();
        }

        /// <summary>Get User by Id</summary>
        /// <param name="id" examle="101">The User id</param>
        // GET api/<ValuesController>/5
        [HttpGet("{id}")]
        public User Get(int id)
        {
            return _repository.GetElement(id);
        }

        /// <summary>Add new User</summary>
        // POST api/<ValuesController>
        [HttpPost]
        public void Post(User user)
        {
            user.Id = 0;

            _repository.AddElement(user);
            _repository.SaveCollection();
        }

        /// <summary>Update user</summary>
        // PUT api/<ValuesController>/5
        [HttpPut("{id}")]
        public void Put(int id, User user)
        {
            user.Id = id;

            _repository.UpdateElement(user);
            _repository.SaveCollection();
        }

        /// <summary>Delete</summary>
        /// <param name="id" example="101">The User id</param>
        // DELETE api/<ValuesController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            _repository.DeleteElement(id);
            _repository.SaveCollection();
        }
    }
}
