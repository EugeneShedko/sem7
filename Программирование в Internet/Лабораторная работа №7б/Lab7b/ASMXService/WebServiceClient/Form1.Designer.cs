
namespace WebServiceClient
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.dataGridView = new System.Windows.Forms.DataGridView();
            this.IdPhoneRecord = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.LastName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.PhoneNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.label1 = new System.Windows.Forms.Label();
            this.addLastNameTextBox = new System.Windows.Forms.TextBox();
            this.addPhoneNumberTextBox = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.addButton = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.updateLastNameTextBox = new System.Windows.Forms.TextBox();
            this.updatePhoneRecordTextBox = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.updateButton = new System.Windows.Forms.Button();
            this.deleteButton = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView
            // 
            this.dataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.IdPhoneRecord,
            this.LastName,
            this.PhoneNumber});
            this.dataGridView.Location = new System.Drawing.Point(12, 12);
            this.dataGridView.Name = "dataGridView";
            this.dataGridView.Size = new System.Drawing.Size(510, 426);
            this.dataGridView.TabIndex = 0;
            this.dataGridView.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView_CellContentClick);
            // 
            // IdPhoneRecord
            // 
            this.IdPhoneRecord.HeaderText = "Id";
            this.IdPhoneRecord.Name = "IdPhoneRecord";
            this.IdPhoneRecord.Visible = false;
            // 
            // LastName
            // 
            this.LastName.HeaderText = "Фамилия";
            this.LastName.Name = "LastName";
            this.LastName.ReadOnly = true;
            // 
            // PhoneNumber
            // 
            this.PhoneNumber.HeaderText = "Телефон";
            this.PhoneNumber.Name = "PhoneNumber";
            this.PhoneNumber.ReadOnly = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(540, 12);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(59, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Фамилия:";
            // 
            // addLastNameTextBox
            // 
            this.addLastNameTextBox.Location = new System.Drawing.Point(606, 12);
            this.addLastNameTextBox.Name = "addLastNameTextBox";
            this.addLastNameTextBox.Size = new System.Drawing.Size(182, 20);
            this.addLastNameTextBox.TabIndex = 2;
            // 
            // addPhoneNumberTextBox
            // 
            this.addPhoneNumberTextBox.Location = new System.Drawing.Point(606, 38);
            this.addPhoneNumberTextBox.Name = "addPhoneNumberTextBox";
            this.addPhoneNumberTextBox.Size = new System.Drawing.Size(182, 20);
            this.addPhoneNumberTextBox.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(540, 38);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(55, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Телефон:";
            // 
            // addButton
            // 
            this.addButton.Location = new System.Drawing.Point(606, 65);
            this.addButton.Name = "addButton";
            this.addButton.Size = new System.Drawing.Size(182, 23);
            this.addButton.TabIndex = 5;
            this.addButton.Text = "Добавить";
            this.addButton.UseVisualStyleBackColor = true;
            this.addButton.Click += new System.EventHandler(this.addButton_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(543, 121);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(56, 13);
            this.label3.TabIndex = 6;
            this.label3.Text = "Фамилия";
            // 
            // updateLastNameTextBox
            // 
            this.updateLastNameTextBox.Location = new System.Drawing.Point(606, 121);
            this.updateLastNameTextBox.Name = "updateLastNameTextBox";
            this.updateLastNameTextBox.Size = new System.Drawing.Size(182, 20);
            this.updateLastNameTextBox.TabIndex = 7;
            // 
            // updatePhoneRecordTextBox
            // 
            this.updatePhoneRecordTextBox.Location = new System.Drawing.Point(606, 148);
            this.updatePhoneRecordTextBox.Name = "updatePhoneRecordTextBox";
            this.updatePhoneRecordTextBox.Size = new System.Drawing.Size(182, 20);
            this.updatePhoneRecordTextBox.TabIndex = 8;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(546, 148);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(52, 13);
            this.label4.TabIndex = 9;
            this.label4.Text = "Телефон";
            // 
            // updateButton
            // 
            this.updateButton.Location = new System.Drawing.Point(606, 175);
            this.updateButton.Name = "updateButton";
            this.updateButton.Size = new System.Drawing.Size(182, 23);
            this.updateButton.TabIndex = 10;
            this.updateButton.Text = "Редактировать";
            this.updateButton.UseVisualStyleBackColor = true;
            this.updateButton.Click += new System.EventHandler(this.updateButton_Click);
            // 
            // deleteButton
            // 
            this.deleteButton.Location = new System.Drawing.Point(606, 415);
            this.deleteButton.Name = "deleteButton";
            this.deleteButton.Size = new System.Drawing.Size(182, 23);
            this.deleteButton.TabIndex = 11;
            this.deleteButton.Text = "Удалить";
            this.deleteButton.UseVisualStyleBackColor = true;
            this.deleteButton.Click += new System.EventHandler(this.deleteButton_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.deleteButton);
            this.Controls.Add(this.updateButton);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.updatePhoneRecordTextBox);
            this.Controls.Add(this.updateLastNameTextBox);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.addButton);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.addPhoneNumberTextBox);
            this.Controls.Add(this.addLastNameTextBox);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.dataGridView);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn IdPhoneRecord;
        private System.Windows.Forms.DataGridViewTextBoxColumn LastName;
        private System.Windows.Forms.DataGridViewTextBoxColumn PhoneNumber;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox addLastNameTextBox;
        private System.Windows.Forms.TextBox addPhoneNumberTextBox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button addButton;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox updateLastNameTextBox;
        private System.Windows.Forms.TextBox updatePhoneRecordTextBox;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button updateButton;
        private System.Windows.Forms.Button deleteButton;
    }
}

