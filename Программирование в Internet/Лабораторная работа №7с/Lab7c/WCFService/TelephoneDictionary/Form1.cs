using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TelephoneDictionary
{
    public partial class Form1 : Form
    {

        private ServiceReference.PhoneRecord[] _collectionPhoneRecord;
        private ServiceReference.ServiceClient _client;

        private int _idToUpdate = 0;
        private int _idToDelete = 0;
        public Form1()
        {
            InitializeComponent();
            dataGridView.MultiSelect = false;
            dataGridView.SelectionMode = DataGridViewSelectionMode.FullRowSelect;

            _client = new ServiceReference.ServiceClient();

            GetCollection();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            InputInfo();
        }

        private void addButton_Click(object sender, EventArgs e)
        {
            var record = new ServiceReference.PhoneRecord();
            record.Id = 0;
            record.LastName = addLastNameTextBox.Text;
            record.PhoneNumber = addPhoneNumberTextBox.Text;
            _client.Add(record);

            InputInfo();
        }

        private void updateButton_Click(object sender, EventArgs e)
        {
            var record = new ServiceReference.PhoneRecord();
            record.Id = _idToUpdate;
            record.LastName = updateLastNameTextBox.Text;
            record.PhoneNumber = updatePhoneRecordTextBox.Text;
            _client.Update(record);

            InputInfo();
        }

        private void deleteButton_Click(object sender, EventArgs e)
        {
            _client.Delete(_idToDelete);

            InputInfo();
        }

        private void dataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            var item = dataGridView.SelectedRows[0].Cells;

            _idToDelete = int.Parse(item[0].Value.ToString());
            _idToUpdate = _idToDelete;

            updateLastNameTextBox.Text = item[1].Value.ToString();
            updatePhoneRecordTextBox.Text = item[2].Value.ToString();
        }

        private void GetCollection()
        {
            _collectionPhoneRecord = _client.GetCollection();
        }

        private void InputInfo()
        {
            dataGridView.Rows.Clear();
            GetCollection();

            int flag = 0;
            foreach (var item in _collectionPhoneRecord)
            {
                if (flag == 0)
                {
                    _idToDelete = item.Id;
                    _idToUpdate = _idToDelete;
                    flag = 1;
                }
                dataGridView.Rows.Add(item.Id, item.LastName, item.PhoneNumber);
            }
        }
    }
}
