using Microsoft.AspNetCore.Mvc;
using Model;
using Model.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace TelephoneDirectory.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValuesController : ControllerBase
    {
        private IPhoneDictionary _repository;

        public ValuesController(IPhoneDictionary repository)
        {
            _repository = repository;
        }

        // GET: api/<ValuesController>
        [HttpGet]
        public IEnumerable<PhoneRecord> Get()
        {
            return _repository.GetCollection();
        }

        // GET api/<ValuesController>/5
        [HttpGet("{id}")]
        public PhoneRecord Get(int id)
        {
            return _repository.GetElement(id);
        }

        // POST api/<ValuesController>
        [HttpPost]
        public void Post(PhoneRecord phoneRecord)
        {
            phoneRecord.Id = 0;

            _repository.AddElement(phoneRecord);
            _repository.SaveCollection();
        }

        // PUT api/<ValuesController>/5
        [HttpPut("{id}")]
        public void Put(int id, PhoneRecord phoneRecord)
        {
            phoneRecord.Id = id;

            _repository.UpdateElement(phoneRecord);
            _repository.SaveCollection();
        }

        // DELETE api/<ValuesController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            _repository.DeleteElement(id);
            _repository.SaveCollection();
        }
    }
}
