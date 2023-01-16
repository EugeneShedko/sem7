using System;

namespace WebAPIServer.Model
{
    [Serializable]
    public class PhoneRecord
    {
        public int Id { get; set; }
        public string LastName { get; set; }
        public string PhoneNumber { get; set; }

        public PhoneRecord()
        {

        }

        public PhoneRecord(int id, string lastName, string phoneNumber)
        {
            this.Id = id;
            this.LastName = lastName;
            this.PhoneNumber = phoneNumber;
        }
    }
}